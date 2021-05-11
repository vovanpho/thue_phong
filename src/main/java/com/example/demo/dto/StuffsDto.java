package com.example.demo.dto;

import com.example.demo.entity.RoomEntity;

public class StuffsDto extends AbstractDto{
	
	private String nameStuff;
	
	private Integer quality;
	
	private String description;
	
	private RoomEntity room;

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

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public StuffsDto(String nameStuff, Integer quality, String description, RoomEntity room) {
		super();
		this.nameStuff = nameStuff;
		this.quality = quality;
		this.description = description;
		this.room = room;
	}

	public StuffsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
