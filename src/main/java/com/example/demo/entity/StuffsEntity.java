package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STUFFS")
public class StuffsEntity extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(max=120)
	private String name;
	
	private Integer quality;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="room_id", nullable = true)
	private RoomEntity room;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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


	
	
}
