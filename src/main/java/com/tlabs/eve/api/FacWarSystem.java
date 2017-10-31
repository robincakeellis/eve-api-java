package com.tlabs.eve.api;

import java.io.Serializable;

public class FacWarSystem implements Serializable {

	private static final long serialVersionUID = -3348478046604242464L;
	
	private int solarSystemID = -1;
	private String solarSystemName = "";
	private int occupyingFactionID = -1;
	private String occupyingFactionName = "";
	private String contested = "";
	private int owningFactionID = -1;
	private String owningFactionName = "";
	private int victoryPoints = -1;
	private int victoryPointThreshold = -1;

	public int getOwningFactionID() {
		return owningFactionID;
	}

	public void setOwningFactionID(int owningFactionID) {
		this.owningFactionID = owningFactionID;
	}

	public String getOwningFactionName() {
		return owningFactionName;
	}

	public void setOwningFactionName(String owningFactionName) {
		this.owningFactionName = owningFactionName;
	}

	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}

	public int getVictoryPointThreshold() {
		return victoryPointThreshold;
	}

	public void setVictoryPointThreshold(int victoryPointThreshold) {
		this.victoryPointThreshold = victoryPointThreshold;
	}

	public int getSolarSystemID() {
		return solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public String getSolarSystemName() {
		return solarSystemName;
	}

	public void setSolarSystemName(String solarSystemName) {
		this.solarSystemName = solarSystemName;
	}

	public int getOccupyingFactionID() {
		return occupyingFactionID;
	}

	public void setOccupyingFactionID(int occupyingFactionID) {
		this.occupyingFactionID = occupyingFactionID;
	}

	public String getOccupyingFactionName() {
		return occupyingFactionName;
	}

	public void setOccupyingFactionName(String occupyingFactionName) {
		this.occupyingFactionName = occupyingFactionName;
	}

	public String getContested() {
		return contested;
	}

	public void setContested(String contested) {
		this.contested = contested;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
