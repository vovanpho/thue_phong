package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomStuffKey implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "room_id")
	private String roomId;
	
	@Column(name = "stuff_id")
	private String stuffId;

}
