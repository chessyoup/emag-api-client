package com.flow.emag.api.model;

import com.google.gson.annotations.SerializedName;

public class Shipment {
	
	@SerializedName("id")
	private Integer id;
	
	@SerializedName("awb_number")
	private String awb_number;
	
	@SerializedName("date")
	private String date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAwb_number() {
		return awb_number;
	}

	public void setAwb_number(String awb_number) {
		this.awb_number = awb_number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Shipment [id=" + id + ", awb_number=" + awb_number + ", date="
				+ date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((awb_number == null) ? 0 : awb_number.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Shipment other = (Shipment) obj;
		if (awb_number == null) {
			if (other.awb_number != null)
				return false;
		} else if (!awb_number.equals(other.awb_number))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
