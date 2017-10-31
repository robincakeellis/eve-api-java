package com.tlabs.eve.api;

import com.tlabs.eve.api.EveAPIRequest.Public;

public final class FacWarSystemsRequest extends EveAPIRequest<FacWarSystemsResponse> implements Public {

    public FacWarSystemsRequest() {
        super(FacWarSystemsResponse.class, "/map/FacWarSystems.xml.aspx", 0);
    }

}
