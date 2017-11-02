package com.tlabs.eve.api;

public class Alliance {

    private String name; // Name of the alliance.
    private String shortName; // Alliance ticker.
    private int allianceID; // ID number of the alliance.
    private int executorCorpID; // Corporation ID of the executor corporation.
    private int memberCount; // Number of pilots in the alliance.
    private long startDate; // Date the alliance was founded.
    // Rowset memberCorporations

    @Override
    public String toString() {
        return "Alliance [name=" + name + ", shortName=" + shortName + ", allianceID=" + allianceID + ", executorCorpID=" + executorCorpID + ", memberCount="
                + memberCount + ", startDate=" + startDate + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(int allianceID) {
        this.allianceID = allianceID;
    }

    public int getExecutorCorpID() {
        return executorCorpID;
    }

    public void setExecutorCorpID(int executorCorpID) {
        this.executorCorpID = executorCorpID;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

}
