package com.flow.emag.api.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@EmagResource(name="product")
public class Product {
	
	/**
	 * Product eMAG id
	 */	
	@SerializedName("emag_id")	
	public Integer id;
	
	/**
	 * Manufacturer unique identifier of the product
	 */
	@SerializedName("part_number")	
	public String number;
	
	/**
	 * Product name
	 */
	@SerializedName("name")		
	public String name;
	
	/**
	 * Product short description
	 */
	@SerializedName("short_description")		
	public String shortDescription;
	
	/**
	 * Product description
	 */
	@SerializedName("description")			
	public String description;
	
	/**
	 * Product category
	 */
	@SerializedName("category")
	public Category category;
	
	/**
	 * Product brand
	 */
	@SerializedName("brand")	
	public Brand brand;
	
	
	@SerializedName("characteristics")	
	public List<ProductsCharacteristic> characteristics;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<ProductsCharacteristic> getCharacteristics() {
		return characteristics;
	}


	public void setCharacteristics(List<ProductsCharacteristic> characteristics) {
		this.characteristics = characteristics;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", number=" + number + ", name=" + name
				+ ", shortDescription=" + shortDescription + ", description="
				+ description + ", category=" + category + ", brand=" + brand
				+ ", characteristics=" + characteristics + "]";
	}
}
