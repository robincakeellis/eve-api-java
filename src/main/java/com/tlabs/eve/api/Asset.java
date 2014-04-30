package com.tlabs.eve.api;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * %%
 * Copyright (C) 2010 - 2012 Evanova (Traquenard Labs)
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Asset extends Object implements Serializable  {

	private static final long serialVersionUID = 3312515668424970872L;

	private long itemID;//it is the typeID	
	
	private long locationID;
	private String locationName;//Not in XML

	private long quantity;

	private int inventoryFlag;
	private String inventoryFlagName;//not in XML
	private boolean packaged;
	
	private List<Asset> items = new LinkedList<Asset>();
	
	public Asset() {
		super();
	}
	
	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;	
	}
	
	public long getLocationID() {
		return locationID;
	}

	public void setLocationID(long locationID) {
		this.locationID = locationID;
	}

	public void setLocationID(String locationID) {
		if (StringUtils.isBlank(locationID)) {
			this.locationID = -1;
		}
		else {
			this.locationID = Long.parseLong(locationID);
		}		
	}
	
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = Integer.parseInt(quantity);
	}

	public int getInventoryFlag() {
		return inventoryFlag;
	}

	public void setInventoryFlag(int inventoryFlag) {
		this.inventoryFlag = inventoryFlag;
		this.inventoryFlagName = "" + inventoryFlag;
	}

	public void setInventoryFlag(String inventoryFlag) {
		this.inventoryFlag = Integer.parseInt(inventoryFlag);
		this.inventoryFlagName = inventoryFlag;
	}

	public boolean getPackaged() {
		return packaged;
	}

	public void setPackaged(boolean packaged) {
		this.packaged = packaged;
	}
	
	public void setPackaged(String packaged) {
		if ("0".equals(packaged)) {
			this.packaged = true;		
		}
		else {
			this.packaged = false;
		}
	}
	
	public final String getInventoryName() {
		return inventoryFlagName;
	}

	public final void setInventoryName(String inventoryName) {
		this.inventoryFlagName = inventoryName;
	}

	public final String getLocationName() {
		return locationName;
	}

	public final void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public void addAsset(Asset item) {
		this.items.add(item);		
	}	
	
	public final List<Asset> getAssets() {
		return items;
	}

	public final void setAssets(List<Asset> items) {
		this.items = items;
	}

	public final List<Asset> getContainedItems() {
		return this.items; 
	}
	
	public final int getContainedCount() {
		return this.items.size();
	}
}