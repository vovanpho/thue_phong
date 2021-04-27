package com.example.demo.dto;

import java.util.Set;

import com.example.demo.entity.RoomTypeEntity;
import com.example.demo.entity.StuffsEntity;

public class RoomDto extends AbstractDto{
	
	private String nameRoom;
	private Set<RoomImagesDto> roomImgs;
	private String description;
	private Set<StuffsEntity> stuffs;
	private Integer price;
	private Set<RoomImagesDto> priceImgs;
	private RoomTypeEntity roomType;
	public String getNameRoom() {
		return nameRoom;
	}
	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}
	public Set<RoomImagesDto> getRoomImgs() {
		return roomImgs;
	}
	public void setRoomImgs(Set<RoomImagesDto> roomImgs) {
		this.roomImgs = roomImgs;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<StuffsEntity> getStuffs() {
		return stuffs;
	}
	public void setStuffs(Set<StuffsEntity> stuffs) {
		this.stuffs = stuffs;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Set<RoomImagesDto> getPriceImgs() {
		return priceImgs;
	}
	public void setPriceImgs(Set<RoomImagesDto> priceImgs) {
		this.priceImgs = priceImgs;
	}
	public RoomTypeEntity getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomTypeEntity roomType) {
		this.roomType = roomType;
	}
	public RoomDto(String nameRoom, Set<RoomImagesDto> roomImgs, String description, Set<StuffsEntity> stuffs,
			Integer price, Set<RoomImagesDto> priceImgs, RoomTypeEntity roomType) {
		super();
		this.nameRoom = nameRoom;
		this.roomImgs = roomImgs;
		this.description = description;
		this.stuffs = stuffs;
		this.price = price;
		this.priceImgs = priceImgs;
		this.roomType = roomType;
	}
	public RoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
