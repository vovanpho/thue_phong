package com.example.demo.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.demo.constant.EImage;

public class RoomImagesDto extends AbstractDto{

	private String name;
	
	@Enumerated(EnumType.STRING)
	private EImage cateOfImg;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EImage getCateOfImg() {
		return cateOfImg;
	}

	public void setCateOfImg(EImage cateOfImg) {
		this.cateOfImg = cateOfImg;
	}

	public RoomImagesDto(String name, EImage cateOfImg) {
		super();
		this.name = name;
		this.cateOfImg = cateOfImg;
	}

	public RoomImagesDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
