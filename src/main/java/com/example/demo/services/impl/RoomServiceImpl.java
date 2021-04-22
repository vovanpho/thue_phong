package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.RoomConvert;
import com.example.demo.convert.RoomImageConvert;
import com.example.demo.dto.RoomDto;
import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.RoomImagesEntity;
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
	private RoomImageSerivceImpl roomImageSerivceImpl;

	@Autowired
	private RoomImageConvert roomImageConvert;

	@Autowired
	private RoomConvert roomConvert;

	@Override
	public RoomDto save(RoomDto roomDto) {
		// TODO Auto-generated method stub
		RoomEntity roomEntity = new RoomEntity();
		if (roomDto.getId() != null) {
			RoomEntity oldRoomEntity = roomRepository.findOneById(roomDto.getId());
			roomEntity = roomConvert.convertEntity(roomDto, oldRoomEntity);
			//			
			roomDto.getPriceImgs().forEach(t -> {
				roomDto.getRoomImgs().add(t);
			});
			Set<RoomImagesEntity> roomImages = roomImageSerivceImpl.findAllByRoomId(roomDto.getId());
			roomDto.getRoomImgs().forEach(t -> {
				if (roomImages.add(roomImageConvert.toEntity(t))) {
					roomImageSerivceImpl.save(t);
				}
			});

		} else {
			roomEntity = roomConvert.convertEntity(roomDto);
			//			
			roomDto.getPriceImgs().forEach(t->{
				roomDto.getRoomImgs().add(t);
			});
			roomDto.getRoomImgs().forEach(t->{
				roomImageSerivceImpl.save(t);
			});
			
			
		}

		RoomTypeEntity roomTypeEntity = roomTypeRepository.findOneByName(roomDto.getRoomType().getName());
		roomEntity.setRoomType(roomTypeEntity);

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

}
