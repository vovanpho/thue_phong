package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.RoomDto;

public interface IRoomService {
	RoomDto save(RoomDto roomDto);
	List<RoomDto> findAll();
}
