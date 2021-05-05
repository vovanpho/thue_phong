package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.RoomDto;
import com.example.demo.entity.RoomEntity;

public interface IRoomService {
	RoomDto save(RoomDto roomDto);
	List<RoomDto> findAll();
	RoomEntity findOneById(String id);
}
