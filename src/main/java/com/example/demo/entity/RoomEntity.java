package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="ROOM")
public class RoomEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String nameRoom;
	
    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
	private RoomTypeEntity roomType;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	private Integer price;

	public String getNameRoom() {
		return nameRoom;
	}

	public void setNameRoom(String nameRoom) {
		this.nameRoom = nameRoom;
	}

	public RoomTypeEntity getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeEntity roomType) {
		this.roomType = roomType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public RoomEntity(@NotNull String nameRoom, RoomTypeEntity roomType, String description, Integer price) {
		super();
		this.nameRoom = nameRoom;
		this.roomType = roomType;
		this.description = description;
		this.price = price;
	}

	public RoomEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
