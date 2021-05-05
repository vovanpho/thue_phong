package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.constant.EImage;

@Entity
@Table(name = "files")
public class FileDBEntity extends BaseEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String type;

	@Lob
	private byte[] data;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EImage cateOfImg;

	@ManyToOne
	@JoinColumn(name = "room_id", nullable = true)
	private RoomEntity room;

	public FileDBEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileDBEntity(String name, String type, byte[] data, EImage cateOfImg, RoomEntity room) {
		super();

		this.name = name;
		this.type = type;
		this.data = data;
		this.cateOfImg = cateOfImg;
		this.room = room;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
