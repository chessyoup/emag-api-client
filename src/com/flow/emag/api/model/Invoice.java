package com.flow.emag.api.model;

import java.math.BigDecimal;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Invoice {
	
	@SerializedName("id")
	private Integer id;
	
	@SerializedName("series")
	private String series;
	
	@SerializedName("number")
	private String number;
	
	/**
	 * Ex: '2011-05-23 00:00:00
	 */
	@SerializedName("date")
	private String date; 
	
	/**
	 * Ex: '2011-05-23 00:00:00
	 */
	@SerializedName("due_date")
	private String dueDate;
			
	/**
	 * Ex: value 173.9900
	 */
	@SerializedName("value")
	private BigDecimal value;
	
	/**
	 * Ex: value 173.9900
	 */
	@SerializedName("total_value")
	private BigDecimal totalValue;
	
	/**
	 *  0 - false ?
	 *  1 - true ?
	 */
	@SerializedName("is_cancellation")
	private Integer isCancellation;
	
	@SerializedName("products")
	private List<InvoiceItem> products;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public Integer getIsCancellation() {
		return isCancellation;
	}

	public void setIsCancellation(Integer isCancellation) {
		this.isCancellation = isCancellation;
	}

	public List<InvoiceItem> getProducts() {
		return products;
	}

	public void setProducts(List<InvoiceItem> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", series=" + series + ", number="
				+ number + ", date=" + date + ", dueDate=" + dueDate
				+ ", value=" + value + ", totalValue=" + totalValue
				+ ", isCancellation=" + isCancellation + ", products="
				+ products + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((isCancellation == null) ? 0 : isCancellation.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		result = prime * result
				+ ((totalValue == null) ? 0 : totalValue.hashCode());
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
		Invoice other = (Invoice) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isCancellation == null) {
			if (other.isCancellation != null)
				return false;
		} else if (!isCancellation.equals(other.isCancellation))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (series == null) {
			if (other.series != null)
				return false;
		} else if (!series.equals(other.series))
			return false;
		if (totalValue == null) {
			if (other.totalValue != null)
				return false;
		} else if (!totalValue.equals(other.totalValue))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
