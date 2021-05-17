package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.RoomConvert;
import com.example.demo.dto.RoomDto;
import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.RoomTypeEntity;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.RoomTypeRepository;
import com.example.demo.services.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomTypeRepository roomTypeRepository;
	
	@Autowired
	private RoomStuffServiceImpl roomStuffServiceImpl;
	
	@Autowired
	private FileStorageServiceImpl fileStorageServiceImpl;

	@Autowired
	private RoomConvert roomConvert;
	

	@Override
	public RoomDto save(RoomDto roomDto) {
		// TODO Auto-generated method stub
		RoomEntity roomEntity = new RoomEntity();
		if (roomDto.getId() != null) {
			RoomEntity oldRoomEntity = roomRepository.findOneById(roomDto.getId());
			roomEntity = roomConvert.convertEntity(roomDto, oldRoomEntity);

			RoomTypeEntity roomTypeEntity = roomDto.getRoomType();
			roomTypeRepository.save(roomTypeEntity);
			roomTypeEntity = roomTypeRepository.findOneByNameTypeRoom(roomDto.getRoomType().getNameTypeRoom());
			roomEntity.setRoomType(roomTypeEntity);

		} else {
			roomEntity = roomConvert.convertEntity(roomDto);
			roomTypeRepository.save(roomDto.getRoomType());
			RoomTypeEntity roomTypeEntity = roomTypeRepository.findOneByNameTypeRoom(roomDto.getRoomType().getNameTypeRoom());
			roomEntity.setRoomType(roomTypeEntity);
		}
		roomEntity = roomRepository.save(roomEntity);
		return roomConvert.convertToDto(roomEntity);
	}
	
	

	@Override
	public List<RoomDto> findAll() {
		// TODO Auto-generated method stub
		List<RoomDto> listDto = new ArrayList<RoomDto>();
		roomRepository.findAll().forEach(t->{
			listDto.add(roomConvert.convertToDto(t));
		});
		return listDto;
	}

	@Override
	public RoomEntity findOneById(String id) {
		// TODO Auto-generated method stub
		return roomRepository.findOneById(id);
	}
	
	public Boolean delete(RoomDto roomDto){
		if(roomDto.getId()!=null) {
			roomStuffServiceImpl.findKeyByRoom(
					roomRepository.findOneById(roomDto.getId()))
					.forEach(t->{
						roomStuffServiceImpl.deleteByKey(t);
					});
			fileStorageServiceImpl.findAllByRoomId(roomDto.getId())
					.forEach(r->{
						fileStorageServiceImpl.deteleById(r.getId());
					});
			roomRepository.deleteById(roomDto.getId());
			return true;
		}
		return false;
	}

}
