package com.tlabs.eve.api;

import org.apache.commons.digester3.Digester;
import com.tlabs.eve.parser.SetAttributePropertyRule;
import com.tlabs.eve.parser.SetNextRule;

public final class FacWarSystemsParser extends EveAPIParser<FacWarSystemsResponse> {

    public FacWarSystemsParser() {
        super(FacWarSystemsResponse.class);
    }

    @Override
    protected void onInit(Digester digester) {
        digester.addObjectCreate("eveapi/result/rowset/row", FacWarSystem.class);

        digester.addRule("eveapi/result/rowset/row", new SetAttributePropertyRule());
        digester.addRule("eveapi/result/rowset/row", new SetNextRule("addFactionWarSystem"));
    }
    
}
