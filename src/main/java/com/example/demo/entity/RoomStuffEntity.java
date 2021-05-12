package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room_stuff")
public class RoomStuffEntity {
	@EmbeddedId
	private KeyRoomStuff id;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	@MapsId(value = "roomId")
	private RoomEntity room;
	
	@ManyToOne
	@JoinColumn(name = "stuff_id")
	@MapsId(value = "stuffId")
	private StuffsEntity stuff;
}
