package com.example.demo.convert;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.constant.EImage;
import com.example.demo.dto.RoomDto;
import com.example.demo.dto.RoomImagesDto;
import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.RoomImagesEntity;
import com.example.demo.entity.StuffsEntity;
import com.example.demo.services.impl.RoomImageSerivceImpl;
//import com.example.demo.services.impl.StuffsService;
import com.example.demo.services.impl.StuffsServiceImpl;

@Component
public class RoomConvert {
	
	@Autowired
	private RoomImageConvert roomImageConvert;
	
	@Autowired
	private RoomImageSerivceImpl roomImagesServiceImpl;
	
	@Autowired
	private StuffsServiceImpl stuffsServiceImpl;
	
	public RoomDto convertToDto(RoomEntity entity) {
		RoomDto roomDto = new RoomDto();
		if(entity.getId()!=null) {
			roomDto.setId(entity.getId());
		}
		roomDto.setCreatedBy(entity.getCreatedBy());
		roomDto.setCreatedDate(entity.getCreatedDate());
		roomDto.setLastModifiedBy(entity.getLastModifiedBy());
		roomDto.setLastModifiedDate(entity.getLastModifiedDate());
		roomDto.setName(entity.getName());
		roomDto.setDescription(entity.getDescription());
		roomDto.setPrice(entity.getPrice());
		roomDto.setRoomType(entity.getRoomType());
		//stuffs
		Set<StuffsEntity> stuffs = stuffsServiceImpl.findAllByRoomId(entity.getId());
		roomDto.setStuffs(stuffs);
		
		// images		
		Set<RoomImagesDto> roomImgs = new HashSet<RoomImagesDto>();
		Set<RoomImagesDto> priceImgs = new HashSet<RoomImagesDto>();
		Set<RoomImagesEntity> roomImages = roomImagesServiceImpl.findAllByRoomId(entity.getId());
		roomImages.forEach(t -> {
			if(t.getCateOfImg().equals(EImage.Nomal)) {
				roomImgs.add(roomImageConvert.toDto(t));
			}else if(t.getCateOfImg().equals(EImage.Price)){
				priceImgs.add(roomImageConvert.toDto(t));
			}
			
		});

		roomDto.setRoomImgs(roomImgs);
		roomDto.setPriceImgs(priceImgs);
		
		return roomDto;
	}
	public RoomEntity convertEntity(RoomDto dto) {
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setId(dto.getId());
		roomEntity.setName(dto.getName());
		roomEntity.setDescription(dto.getDescription());
		roomEntity.setRoomType(dto.getRoomType());
		roomEntity.setPrice(dto.getPrice());
	
//		// images		
//		dto.getPriceImgs().forEach(t -> {
//			dto.getRoomImgs().add(t);
//		});
//		if(dto.getId()!=null) {
//			Set<RoomImagesEntity> roomImages = roomImagesServiceImpl.findAllByRoomId(dto.getId());
//			dto.getRoomImgs().forEach(t -> {
//				roomImages.add(roomImageConvert.toEntity(t));
//			});
//		}
		return roomEntity;	
	}
	public RoomEntity convertEntity(RoomDto dto, RoomEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setRoomType(dto.getRoomType());
		entity.setPrice(dto.getPrice());
		return entity;	
	}
	
}
