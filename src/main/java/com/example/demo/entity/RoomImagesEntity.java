package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.constant.EImage;

@Entity
@Table(name="ROOM_IMAGES")
public class RoomImagesEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(max=120)
	private String nameImage;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EImage cateOfImg;
	
	@ManyToOne
	@JoinColumn(name="room_id", nullable = true)
	private RoomEntity room;

	public String getNameImage() {
		return nameImage;
	}

	public void setNameImage(String nameImage) {
		this.nameImage = nameImage;
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

	public RoomImagesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomImagesEntity(@NotBlank @Size(max = 120) String nameImage, EImage cateOfImg, RoomEntity room) {
		super();
		this.nameImage = nameImage;
		this.cateOfImg = cateOfImg;
		this.room = room;
	}

	
}
