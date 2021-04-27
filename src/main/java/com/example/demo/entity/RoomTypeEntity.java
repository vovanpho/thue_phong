package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicUpdate
@Table(name="ROOM_TYPE")
public class RoomTypeEntity extends BaseEntity {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(max=120)
	@Column(unique = true)
	private String nameTypeRoom;
	public String getNameTypeRoom() {
		return nameTypeRoom;
	}
	public void setNameTypeRoom(String nameTypeRoom) {
		this.nameTypeRoom = nameTypeRoom;
	}
	public RoomTypeEntity( @Size(max = 120) String nameTypeRoom) {
		super();
		this.nameTypeRoom = nameTypeRoom;
	}
	public RoomTypeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
