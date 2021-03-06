package com.flow.emag.api.model;

import com.google.gson.annotations.SerializedName;

public class ProductsCharacteristic {
	
	@SerializedName("id")
	private Long id;
		
	/**
	 * Product characteristic eMAG id,  Integer emag_id=4478
	 */	
	@SerializedName("emag_id")
	private Integer emagId;
	
	/**
	 * Product characteristic name , String name=”Tip produs”
	 */
	@SerializedName("name")
	private String name;
		
	@SerializedName("characteristic_value")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getEmagId() {
		return emagId;
	}

	public void setEmagId(Integer emagId) {
		this.emagId = emagId;
	}

	@Override
	public String toString() {
		return "ProductsCharacteristic [id=" + id + ", emagId=" + emagId
				+ ", name=" + name + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emagId == null) ? 0 : emagId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductsCharacteristic other = (ProductsCharacteristic) obj;
		if (emagId == null) {
			if (other.emagId != null)
				return false;
		} else if (!emagId.equals(other.emagId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
