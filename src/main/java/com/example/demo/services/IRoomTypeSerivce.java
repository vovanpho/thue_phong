package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.RoomTypeEntity;

public interface IRoomTypeSerivce {
	RoomTypeEntity save(RoomTypeEntity roomTypeEntity);
	List<RoomTypeEntity> listAllData();
	boolean detete(RoomTypeEntity roomTypeEntity);
}
