package com.flow.emag.api.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@EmagResource(name="offer")
public class ProductOffer {
			
	/**
	 * Product eMAG id
	 * Required. Integer value between 1 and 9999999
	 */	
	@SerializedName("product_emag_id")
	private Integer productEmagId;
	
	/**
	 * Vendor internal product id (Senia product id)
	 */	
	@SerializedName("id")	
	private Integer vendorId;
		
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
	@SerializedName("category_emag_id")
	public Integer categoryId;
	
	/**
	 * Product brand
	 */
	@SerializedName("brand")	
	public Brand brand;
		
	@SerializedName("characteristics")	
	public List<ProductsCharacteristic> characteristics;
	
	@SerializedName("images")	
	public List<Image> images;
	
	/**
	 * Delivery time id.
	 * Required. Integer value between 0 and 65535
	 * 1 – delivery in 1 day.
	 * 2 – delivery in 2 days.
	 */	
	@SerializedName("delivery_time_id")
	private Integer deliveryTimeId;
	
	/**
	 * Vendor offer status.
	 * 1 – status active
	 * 0 – status inactive
	 * Optional. Default value 1. status=0
	 */
	@SerializedName("status")
	private Integer status;
	
	/**
	 * Vendor offer sale price without VAT
	 * Required. Decimal value between 0 and 99999999999999
	 * Ex: sale_price=51.64
	 */	
	@SerializedName("sale_price")	
	private String salePrice;
	
	/**
	 * Vendor offer sale price before discount without VAT
	 */	
	@SerializedName("original_sale_price")
	private String originalSalePrice;
	
	/**
	 * Vendor offer VAT rate
	 * Optional. Default value 0.24. Decimal value between 0 and 1.
	 * Ex vat_rate=0.09
	 */	
	@SerializedName("vat_rate")	
	private String vatRate;
	
	/**
	 * Vendor offer currency
	 * DEFAULT_CURRENCY. String of 1 to 4 characters currency=”RON”
	 */
	@SerializedName("currency")
	private String currency;
	
	/**
	 * Vendor product availability id.
	 * Integer between 0 and 9
	 * 0 – available on demand
	 * 1 – limited stock reserved 
	 * 2 – limited stock 
	 * 3 – in stock 
	 * 4 – in supplier stock 
	 * 5 – not available 
	 * 9 – available in 10 days 
	 * Optional. Default value availability_id = 9
	 */	
	@SerializedName("availability_id")	
	private Integer availabilityId; 
	
	@SerializedName("popularity")	
	private Integer popularity;
	
	/**
	 * Value represents the warranty in months.
	 * 0 – no warranty
	 * Integer between 0 and 255
	 * Optional. Default warranty=24
	 */	
	@SerializedName("warranty")	
	private Integer warranty;
	
	
}
