package com.example.demo.dto;

import com.example.demo.constant.EImage;
import com.example.demo.entity.RoomEntity;

public class FileDBDto extends AbstractDto{

	private String nameImage;

	private String type;

	private byte[] data;

	private EImage cateOfImg;

	private RoomEntity room;

	public String getNameImage() {
		return nameImage;
	}

	public void setNameImage(String name) {
		this.nameImage = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public EImage getCateOfImg() {
		return cateOfImg;
	}

	public void setCateOfImg(EImage cateOfImg) {
		this.cateOfImg = cateOfImg;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public FileDBDto(String name, String type, byte[] data, EImage cateOfImg, RoomEntity room) {
		super();
		this.nameImage = name;
		this.type = type;
		this.data = data;
		this.cateOfImg = cateOfImg;
		this.room = room;
	}

	public FileDBDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
