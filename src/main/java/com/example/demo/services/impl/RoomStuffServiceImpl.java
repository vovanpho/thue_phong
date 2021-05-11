package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.RoomStuffEntity;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.RoomStuffRepository;

@Service
public class RoomStuffServiceImpl {
	@Autowired private RoomStuffRepository roomStuffRepository;
	@Autowired private RoomRepository roomRepository;
	
	public List<String> findAllStuffIdByRoomId(RoomEntity entity) {
		List<String> listId= new ArrayList<String>();
		roomStuffRepository.findAllByRoom(entity).forEach(t->{
//			listId.add()));
		});
		return listId ;
		
	}
}