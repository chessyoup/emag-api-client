package com.flow.emag.api.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@EmagResource(name="category")
public class Category {
	
	@SerializedName("emag_id")	
	private String id;
	
	@SerializedName("name")	
	private String name;
	
	@SerializedName("characteristics")	
	private List<CategoryCharacteristic> characteristics;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryCharacteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<CategoryCharacteristic> characteristics) {
		this.characteristics = characteristics;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", characteristics="
				+ characteristics + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((characteristics == null) ? 0 : characteristics.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (characteristics == null) {
			if (other.characteristics != null)
				return false;
		} else if (!characteristics.equals(other.characteristics))
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
		return true;
	}
}
