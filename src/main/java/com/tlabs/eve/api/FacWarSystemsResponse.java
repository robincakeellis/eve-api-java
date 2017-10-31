package com.tlabs.eve.api;

import java.util.ArrayList;
import java.util.List;

public final class FacWarSystemsResponse extends EveAPIResponse {

    private static final long serialVersionUID = -8487801645146942276L;

    private final List<FacWarSystem> factionWarSystems;

    public FacWarSystemsResponse() {
        factionWarSystems = new ArrayList<>();
    }

    public void addFactionWarSystem(final FacWarSystem s) {
        factionWarSystems.add(s);
    }

    public List<FacWarSystem> getFactionWarSystems() {
        return factionWarSystems;
    }
    
}
