package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoomTypeEntity;
import com.example.demo.repository.RoomTypeRepository;
import com.example.demo.services.IRoomTypeSerivce;

@Service
public class RoomTypeServiceImpl  implements IRoomTypeSerivce{
	
	@Autowired
	private RoomTypeRepository roomTypeRepository;

	@Override
	public RoomTypeEntity save(RoomTypeEntity roomTypeEntity) {
		// TODO Auto-generated method stub
		return roomTypeRepository.save(roomTypeEntity);
	}

	@Override
	public List<RoomTypeEntity> listAllData() {
		// TODO Auto-generated method stub
		return roomTypeRepository.findAll();
	}
	
	
}
