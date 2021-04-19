package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ROOM")
public class RoomEntity {
	
	@NotNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name="", nullable = false)
	private RoomTypeEntity CategoryRoom;
	
	@OneToMany(mappedBy = "room")
	private Set<ImagesEntity> images;
	
	@Column(length = 20000)
	private String description;
	
	@OneToMany(mappedBy = "room")
	private Set<StuffsEntity> stuffs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoomTypeEntity getCategoryRoom() {
		return CategoryRoom;
	}

	public void setCategoryRoom(RoomTypeEntity categoryRoom) {
		CategoryRoom = categoryRoom;
	}

	public Set<ImagesEntity> getImages() {
		return images;
	}

	public void setImages(Set<ImagesEntity> images) {
		this.images = images;
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



	public RoomEntity( String name, com.example.demo.entity.RoomTypeEntity categoryRoom, Set<ImagesEntity> images,
			String description, Set<StuffsEntity> stuffs) {
		super();
		this.name = name;
		CategoryRoom = categoryRoom;
		this.images = images;
		this.description = description;
		this.stuffs = stuffs;
	}
	
	
}
