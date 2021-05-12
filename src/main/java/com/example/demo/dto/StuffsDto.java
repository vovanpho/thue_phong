package com.example.demo.dto;

public class StuffsDto extends AbstractDto{
	
	private String nameStuff;
	
	private Integer quality;
	
	private String description;
	

	public String getNameStuff() {
		return nameStuff;
	}

	public void setNameStuff(String nameStuff) {
		this.nameStuff = nameStuff;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public StuffsDto(String nameStuff, Integer quality, String description) {
		super();
		this.nameStuff = nameStuff;
		this.quality = quality;
		this.description = description;
	}

	public StuffsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
