package com.tlabs.eve.api;

import java.util.ArrayList;
import java.util.List;

public final class AllianceListResponse extends EveAPIResponse {

    private static final long serialVersionUID = 761944898945283238L;

    private final List<Alliance> alliances;

    public AllianceListResponse() {
        alliances = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "AllianceListResponse [alliances=" + alliances + "]";
    }

    public void addAlliance(final Alliance s) {
        alliances.add(s);
    }

    public List<Alliance> getAlliances() {
        return alliances;
    }

}
