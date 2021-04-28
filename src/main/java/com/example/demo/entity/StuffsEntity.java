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
	private String nameStuff;
	
	private Integer quality;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="room_id", nullable = false)
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

	public StuffsEntity(@NotBlank @Size(max = 120) String nameStuff, Integer quality, String description,
			RoomEntity room) {
		super();
		this.nameStuff = nameStuff;
		this.quality = quality;
		this.description = description;
		this.room = room;
	}

	public StuffsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
