package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.KeyRoomStuff;
import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.RoomStuffEntity;
import com.example.demo.entity.StuffsEntity;
import com.example.demo.repository.RoomStuffRepository;

@Service
public class RoomStuffServiceImpl {
	
	@Autowired 
	private RoomStuffRepository roomStuffRepository;

	public List<StuffsEntity> findStuffsByRoom(RoomEntity roomEntity) {
		// TODO Auto-generated method stub
		List<StuffsEntity>listStuff = new ArrayList<StuffsEntity>();
		roomStuffRepository.findAllByRoom(roomEntity).forEach(t->{
			listStuff.add(t.getStuff());
		});
		return listStuff;
	}
	
	public List<KeyRoomStuff> findKeyByRoom(RoomEntity roomEntity) {
		// TODO Auto-generated method stub
		List<KeyRoomStuff>listKey = new ArrayList<KeyRoomStuff>();
		roomStuffRepository.findAllByRoom(roomEntity).forEach(t->{
			listKey.add(t.getId());
		});
		return listKey;
	}
	
	public List<KeyRoomStuff> findKeyByStuff(StuffsEntity stuffsEntity) {
		// TODO Auto-generated method stub
		List<KeyRoomStuff>listKey = new ArrayList<KeyRoomStuff>();
		roomStuffRepository.findAllByStuff(stuffsEntity).forEach(t->{
			listKey.add(t.getId());
		});
		return listKey;
	}
	
	
	public RoomStuffEntity save(RoomEntity roomEntity, StuffsEntity stuffsEntity) {
		KeyRoomStuff keyRoomStuff =  new KeyRoomStuff(roomEntity.getId(), stuffsEntity.getId());
		RoomStuffEntity roomStuffEntity = new RoomStuffEntity(keyRoomStuff, roomEntity, stuffsEntity);
		return roomStuffRepository.save(roomStuffEntity);
	}

	public boolean delete(RoomEntity roomEntity, StuffsEntity stuffsEntity) {
		// TODO Auto-generated method stub
		KeyRoomStuff keyRoomStuff =  new KeyRoomStuff(roomEntity.getId(), stuffsEntity.getId());
		if(roomStuffRepository.existsById(keyRoomStuff)) {
			roomStuffRepository.deleteById(keyRoomStuff);
			return true;
		}
		return false;
	}
	
	public boolean deleteByKey(KeyRoomStuff keyRoomStuff) {
		if(roomStuffRepository.existsById(keyRoomStuff)) {
			roomStuffRepository.deleteById(keyRoomStuff);
			return true;
		}
		return false;
	}
}