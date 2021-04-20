package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String name;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
	private RoomTypeEntity roomType;
	
	@OneToMany(mappedBy = "room")
	private Set<RoomImagesEntity> images;
	
	@Column(length = 20000)
	private String description;
	
	private Integer price;
	
	@OneToMany(mappedBy = "room")
	private Set<StuffsEntity> stuffs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoomTypeEntity getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeEntity roomType) {
		this.roomType = roomType;
	}

	public Set<RoomImagesEntity> getImages() {
		return images;
	}

	public void setImages(RoomImagesEntity roomImagesEntity) {
		this.images = (Set<RoomImagesEntity>) roomImagesEntity;
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

	
	
}
