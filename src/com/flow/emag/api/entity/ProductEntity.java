package com.flow.emag.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "products" )
public class ProductEntity {
				
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	/**
	 * Emag internal id for this product
	 */
	@Column(name="emag_id")
	private String emagId;
	
	/**
	 * Manufacturer unique identifier of the product
	 */
	@Column(name="part_number")	
	public String number;
	
	/**
	 * Product name
	 */
	@Column
	public String name;
	
	/**
	 * Product short description
	 */
	@Column(name="short_description")
	public String shortDescription;
	
	/**
	 * Product description
	 */
	@Column
	public String description;
	
	/**
	 * Product category
	 */
	@OneToOne(cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	public CategoryEntity category;
	
	/**
	 * Product images
	 */
	@OneToMany(mappedBy="product",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)	
	public List<ImageEntity> images;
	
	/**
	 * Product brand
	 */
	@OneToOne(cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
	public BrandEntity brand;
	
	/**
	 * Product charateriscs
	 */
	@OneToMany(mappedBy="product",cascade = {CascadeType.ALL},fetch=FetchType.LAZY)	
	public List<ProductCharacteristicValueEntity> characteristics;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getEmagId() {
		return emagId;
	}

	public void setEmagId(String emagId) {
		this.emagId = emagId;
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

	public List<ProductCharacteristicValueEntity> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(
			List<ProductCharacteristicValueEntity> characteristics) {
		this.characteristics = characteristics;
	}

	public CategoryEntity getCategory() {
		return this.category;
	}


	public void setCategory(CategoryEntity category) {
		this.category = category;
	}


	public BrandEntity getBrand() {		
		return this.brand;
	}


	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}
	
	public List<ImageEntity> getImages() {
		return images;
	}

	public void setImages(List<ImageEntity> images) {
		this.images = images;
	}

	
}
