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
	@NotBlank
	@Size(max=120)
	@Column(unique = true)
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoomTypeEntity(@NotBlank @Size(max = 120) String name) {
		super();
		this.name = name;
	}
	public RoomTypeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
