package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	

	public StuffsEntity(@NotBlank @Size(max = 120) String nameStuff, Integer quality, String description) {
		super();
		this.nameStuff = nameStuff;
		this.quality = quality;
		this.description = description;
	}

	public StuffsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
