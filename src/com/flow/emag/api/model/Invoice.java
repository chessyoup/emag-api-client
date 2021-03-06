package com.flow.emag.api.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table( name = "invoices" )
public class Invoice {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@SerializedName("id")
	private Long id;		
	
	@Column
	@SerializedName("series")
	@Expose
	private String series;
	
	@Column
	@SerializedName("number")
	@Expose
	private String number;
	
	/**
	 * Ex: '2011-05-23 00:00:00
	 */
	@Column
	@SerializedName("date")
	@Expose
	private String date; 
	
	/**
	 * Ex: '2011-05-23 00:00:00
	 */
	@Column(name="due_date")
	@SerializedName("due_date")
	@Expose
	private String dueDate;
			
	/**
	 * Ex: value 173.9900
	 */
	@Column
	@SerializedName("value")
	@Expose
	private BigDecimal value;
	
	/**
	 * Ex: value 173.9900
	 */
	@Column(name="total_value")
	@SerializedName("total_value")
	@Expose
	private BigDecimal totalValue;
	
	/**
	 *  0 - false ?
	 *  1 - true ?
	 */
	@Column(name="is_cancellation")
	@SerializedName("is_cancellation")
	@Expose
	private Integer isCancellation;
	
	@OneToMany(mappedBy="invoice")
	@SerializedName("products")
	@Expose
	private List<InvoiceItem> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return items;
	}

	public void setProducts(List<InvoiceItem> products) {
		this.items = products;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", series=" + series + ", number="
				+ number + ", date=" + date + ", dueDate=" + dueDate
				+ ", value=" + value + ", totalValue=" + totalValue
				+ ", isCancellation=" + isCancellation + ", products="
				+ items + "]";
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
				+ ((items == null) ? 0 : items.hashCode());
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
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
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
