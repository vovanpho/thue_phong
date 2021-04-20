package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.convert.RoomConvert;
import com.example.demo.dto.RoomDto;
import com.example.demo.entity.RoomEntity;
import com.example.demo.repository.RoomRepository;
import com.example.demo.services.IRoomService;

public class RoomServiceImpl implements IRoomService{
	
	@Autowired 
	private RoomRepository roomRepository;
	@Autowired
	private RoomConvert roomConvert;
	
	@Override
	public RoomDto save(RoomDto roomDto) {
		// TODO Auto-generated method stub
		RoomEntity roomEntity = new RoomEntity();
		if(roomDto.getId() != null) {
			RoomEntity oldRoomEntity = roomRepository.findOne(roomDto.getId());
			roomEntity = roomConvert.convertEntity(roomDto, oldRoomEntity);
		}else {
			
		}
		return null;
	}

}
