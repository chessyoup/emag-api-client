package com.flow.emag.api.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "product_offers" )
public class ProductOfferEntity {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	
	/**
	 * Product eMAG id
	 * Required. Integer value between 1 and 9999999
	 */
	@OneToOne	
	private ProductEntity product;
	
	/**
	 * Vendor internal product id (Senia product id)
	 */
	@Column(name="product_senia_id")
	private Integer vendorId;
	
	/**
	 * Delivery time id.
	 * Required. Integer value between 0 and 65535
	 * 1 – delivery in 1 day.
	 * 2 – delivery in 2 days.
	 */
	@Column(name="delivery_time_id")
	private Integer deliveryTimeId;
	
	/**
	 * Vendor offer status.
	 * 1 – status active
	 * 0 – status inactive
	 * Optional. Default value 1. status=0
	 */
	@Column
	private Integer status;
	
	/**
	 * Vendor offer sale price without VAT
	 * Required. Decimal value between 0 and 99999999999999
	 * Ex: sale_price=51.64
	 */
	@Column(name="sale_price")
	private BigDecimal salePrice;
	
	/**
	 * Vendor offer sale price before discount without VAT
	 */
	@Column(name="original_sale_price")
	private BigDecimal originalSalePrice;
	
	/**
	 * Vendor offer VAT rate
	 * Optional. Default value 0.24. Decimal value between 0 and 1.
	 * Ex vat_rate=0.09
	 */
	@Column(name="vat_rate")
	private BigDecimal vatRate;
	
	/**
	 * Vendor offer currency
	 * DEFAULT_CURRENCY. String of 1 to 4 characters currency=”RON”
	 */
	@Column
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
	@Column(name="availability_id")
	private Integer availabilityId; 
	
	/**
	 * Value represents the warranty in months.
	 * 0 – no warranty
	 * Integer between 0 and 255
	 * Optional. Default warranty=24
	 */
	@Column
	private Integer warranty;
	
	@Column
	private Integer popularity;
	
	@Column
	private Integer valid;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getDeliveryTimeId() {
		return deliveryTimeId;
	}

	public void setDeliveryTimeId(Integer deliveryTimeId) {
		this.deliveryTimeId = deliveryTimeId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getOriginalSalePrice() {
		return originalSalePrice;
	}

	public void setOriginalSalePrice(BigDecimal originalSalePrice) {
		this.originalSalePrice = originalSalePrice;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(Integer availabilityId) {
		this.availabilityId = availabilityId;
	}

	public Integer getWarranty() {
		return warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
}
