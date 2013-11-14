package com.flow.emag.api.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ProductsCharacteristic {
	
	/**
	 * Product characteristic eMAG id,  Integer emag_id=4478
	 */
	@SerializedName("emag_id")
	private Integer id;
	
	/**
	 * Product characteristic name , String name=”Tip produs”
	 */
	@SerializedName("name")	
	private String name;
	
	/**
	 * We support multiple values for characteristics , Array(‘value1’,’value2’)
	 */	
	@SerializedName("values")	
	private List<String> values;

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

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "ProductsCharacteristic [id=" + id + ", name=" + name
				+ ", values=" + values + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
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
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}
}
