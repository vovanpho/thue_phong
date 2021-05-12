package com.example.demo.convert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.constant.EImage;
import com.example.demo.dto.FileDBDto;
import com.example.demo.dto.RoomDto;
import com.example.demo.entity.FileDBEntity;
import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.StuffsEntity;
import com.example.demo.services.impl.FileStorageServiceImpl;
import com.example.demo.services.impl.RoomStuffServiceImpl;

@Component
public class RoomConvert {
	
	@Autowired
	private FileDBConvert roomImageConvert;
	
	@Autowired
	private FileStorageServiceImpl fileStorageServiceImpl;
	
	@Autowired
	private RoomStuffServiceImpl roomStuffServiceImpl;
	
	public RoomDto convertToDto(RoomEntity entity) {
		RoomDto roomDto = new RoomDto();
		if(entity.getId()!=null) {
			roomDto.setId(entity.getId());
		}
		roomDto.setCreatedBy(entity.getCreatedBy());
		roomDto.setCreatedDate(entity.getCreatedDate());
		roomDto.setLastModifiedBy(entity.getLastModifiedBy());
		roomDto.setLastModifiedDate(entity.getLastModifiedDate());
		roomDto.setNameRoom(entity.getNameRoom());
		roomDto.setDescription(entity.getDescription());
		roomDto.setPrice(entity.getPrice());
 		roomDto.setRoomType(entity.getRoomType());
		
//		//stuffs
		List<StuffsEntity> stuffs = roomStuffServiceImpl.findStuffsByRoom(entity);
		roomDto.setStuffs(stuffs);
		
		// images		
		Set<FileDBDto> roomImgs = new HashSet<FileDBDto>();
		Set<FileDBDto> priceImgs = new HashSet<FileDBDto>();
		Set<FileDBEntity> roomImages = fileStorageServiceImpl.findAllByRoomId(entity.getId());
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
		roomEntity.setNameRoom(dto.getNameRoom());
		roomEntity.setDescription(dto.getDescription());
		roomEntity.setRoomType(dto.getRoomType());
		roomEntity.setPrice(dto.getPrice());
		return roomEntity;	
	}
	
	
	public RoomEntity convertEntity(RoomDto dto, RoomEntity entity) {
		entity.setId(dto.getId());
		entity.setNameRoom(dto.getNameRoom());
		entity.setDescription(dto.getDescription());
		entity.setRoomType(dto.getRoomType());
		entity.setPrice(dto.getPrice());
		return entity;	
	}
	
}
