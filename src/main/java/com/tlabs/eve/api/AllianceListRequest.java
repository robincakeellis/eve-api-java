package com.tlabs.eve.api;

import com.tlabs.eve.api.EveAPIRequest.Public;

public final class AllianceListRequest extends EveAPIRequest<AllianceListResponse> implements Public {

    public AllianceListRequest() {
        super(AllianceListResponse.class, "/eve/AllianceList.xml.aspx", 0);
        putParam("version", "1");
    }

}
