package com.tlabs.eve.net;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tlabs.eve.EveFacade;
import com.tlabs.eve.EveNetwork;
import com.tlabs.eve.EveRequest;
import com.tlabs.eve.EveResponse;

public abstract class AbstractEveNetwork implements EveNetwork {
	
    private static final Logger LOG = LoggerFactory.getLogger(AbstractEveNetwork.class);

    private static final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
    
    private static String userAgentExtension;
    
    static {
    	userAgentExtension = "";
    }
    
    public static void setUserAgentExtension(final String newExtension) {
    	AbstractEveNetwork.userAgentExtension = newExtension;
    }

    private static SSLSocketFactory sslSocketFactory;

    static {
        try {
            final SSLContext context = SSLContext.getInstance("SSL");

            TrustManager tm = new X509TrustManager() {
                @Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
				public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };

            context.init(null, new TrustManager[]{tm}, null);
            sslSocketFactory = context.getSocketFactory();
        }
        catch (Exception e) {
            LOG.error(e.getMessage(), e);
            sslSocketFactory = null;
        }
    }

    public abstract String getUri(final EveRequest<?> request);

    @Override
    public <T extends EveResponse> T execute(final EveRequest<T> request) {
        return (T)get(getUri(request), request);
    }

    protected void onPrepareConnection(final HttpURLConnection connection) {}

    private EveResponse get(final String rootUri, final EveRequest<?> request) {
        HttpURLConnection connection = null;
        try {
            connection = prepare(rootUri, request, "GET");
            onPrepareConnection(connection);
            connection.setDoOutput(false);
            return executeImpl(request, connection);
        }
        catch (IOException e) {
            LOG.debug(e.getMessage());
            return request.createError(500, "IOException: " + e.getMessage());
        }
        finally {
            if (null != connection) {
                connection.disconnect();
            }
        }
    }

    private static HttpURLConnection prepare(final String rootUri, final EveRequest<?> request, final String methodName) throws IOException {
    	String ua = "eveapijava/4.6.2";
    	if (StringUtils.isNotBlank(userAgentExtension)) {
    		ua += " " + userAgentExtension;
    	}
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} as {}", request.toURI(rootUri), ua);
        }
        
        HttpURLConnection connection = (HttpURLConnection)(new URL(request.toURI(rootUri)).openConnection());
        connection.setRequestMethod(methodName);
        connection.setRequestProperty("user-agent", ua);

        if (connection instanceof HttpsURLConnection) {
            setupHttps((HttpsURLConnection)connection);
        }
        return connection;
    }

    private static EveResponse executeImpl(final EveRequest<?> request, final HttpURLConnection httpConnection) throws IOException {
        InputStream in  = null;
        EveResponse returned = null;

        try {
            in = new BufferedInputStream(httpConnection.getInputStream());
            if (httpConnection.getResponseCode() == 200) {
                final ByteArrayOutputStream out = new ByteArrayOutputStream();
                IOUtils.copyLarge(in, out);
                out.flush();
                out.close();
                final byte[] data = out.toByteArray();
                returned = EveFacade.parse(request, new ByteArrayInputStream(data));
                returned.setContent(data);
            }
            else {
                returned = request.createError(httpConnection.getResponseCode(), httpConnection.getResponseMessage());
            }
        }
        catch (IOException e) {
            LOG.debug(e.getMessage());
            returned = request.createError(400, e.getMessage());
        }
        finally {
            IOUtils.closeQuietly(in);
        }
        if (LOG.isDebugEnabled()) {
            if (returned.hasError()) {
                LOG.debug(request.getClass().getSimpleName() + " " + returned.getErrorCode() + ": " + returned.getErrorMessage());
            }
            else {
                LOG.debug(request.getClass().getSimpleName() + " completed.");
            }
        }
        return returned;
    }

    private static void setupHttps(final HttpsURLConnection c) throws IOException {
        if (null == sslSocketFactory) {
            throw new IOException("SSLFactory not set.");
        }
        c.setHostnameVerifier(hostnameVerifier);
        c.setSSLSocketFactory(sslSocketFactory);
    }

}
