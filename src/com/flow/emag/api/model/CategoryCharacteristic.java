package com.flow.emag.api.model;

import com.google.gson.annotations.SerializedName;

public class CategoryCharacteristic {

	/**
	 * Characteristic eMAG id, Integer emag_id=4478
	 */
	@SerializedName("emag_id")
	private Integer id;

	/**
	 * Characteristic name , String name=”Tip produs”
	 */
	@SerializedName("name")
	private String name;

	/**
	 * Characteristic display order
	 */
	@SerializedName("display_order")
	private Integer displayOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
}
