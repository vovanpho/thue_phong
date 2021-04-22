package com.example.demo.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.RoomImageConvert;
import com.example.demo.dto.RoomImagesDto;
import com.example.demo.entity.RoomImagesEntity;
import com.example.demo.repository.RoomImagesRepository;
import com.example.demo.services.IRoomImagesService;

@Service
public class RoomImageSerivceImpl implements IRoomImagesService{

	@Autowired
	private RoomImagesRepository roomImagesRepository;
	
	@Autowired
	private RoomImageConvert roomImageConvert;
	
	@Override
	public RoomImagesDto save(RoomImagesDto roomImagesDto) {
		// TODO Auto-generated method stub
		RoomImagesEntity roomImagesEntity = new RoomImagesEntity();
		roomImagesEntity = roomImageConvert.toEntity(roomImagesDto);
		roomImagesEntity = roomImagesRepository.save(roomImagesEntity);
		return roomImageConvert.toDto(roomImagesEntity);
	}

	@Override
	public Set<RoomImagesEntity> findAllByRoomId(Long id) {
		// TODO Auto-generated method stub
		return roomImagesRepository.findAllByRoomId(id);
	}

}
