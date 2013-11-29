package com.flow.emag.api.model;

import com.google.gson.annotations.SerializedName;

@EmagResource(name="image")
public class Image {

	@SerializedName("id")
	private Integer id;
	
	@SerializedName("display_type")
	private Integer displayType;
		
	@SerializedName("status")
	private Integer status;
		
	@SerializedName("url")
	private String url;

	public Integer getDisplayType() {
		return displayType;
	}

	public void setDisplayType(Integer displayType) {
		this.displayType = displayType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
