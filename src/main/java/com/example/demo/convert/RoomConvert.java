package com.example.demo.convert;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.constant.EImage;
import com.example.demo.dto.RoomDto;
import com.example.demo.entity.RoomEntity;

@Component
public class RoomConvert {
	public RoomDto convertToDto(RoomEntity entity) {
		RoomDto roomDto =new RoomDto();
		if(entity.getId()!=null) {
			roomDto.setId(entity.getId());
		}
		roomDto.setCreatedBy(entity.getCreatedBy());
		roomDto.setCreatedDate(entity.getCreatedDate());
		roomDto.setLastModifiedBy(entity.getLastModifiedBy());
		roomDto.setLastModifiedDate(entity.getLastModifiedDate());
		roomDto.setId(entity.getId());
		roomDto.setName(entity.getName());
		roomDto.setDescription(entity.getDescription());
		roomDto.setPrice(entity.getPrice());
		Set<RoomDto> setNomalImg;
		Set<RoomDto> setPriceImg;
		entity.getImages().forEach((t)->{
			if(t.getCateOfImg().equals(EImage.Nomal)) {
				setNomalImg.add(t);
			}else if(t.getCateOfImg().equals(EImage.Price)){
				
			}
		});
		roomDto.setRoomImgs(null);
		roomDto.setStuffs(entity.getStuffs());
		return roomDto;
	}
	public RoomEntity convertEntity(RoomDto dto) {
		RoomEntity roomEntity = new RoomEntity();
		roomEntity.setName(dto.getName());
		roomEntity.setDescription(dto.getDescription());
		roomEntity.setRoomType(dto.getRoomType());
		roomEntity.setPrice(dto.getPrice());
		if(dto.getRoomImgs().getCateOfImg().equals(EImage.Nomal)) {
			roomEntity.setImages(dto.getRoomImgs());;
		}
		if(dto.getPriceImgs().getCateOfImg().equals(EImage.Price)) {
			roomEntity.setImages(dto.getPriceImgs());
		}
		roomEntity.setStuffs(dto.getStuffs());
		return roomEntity;	
	}
	
	public RoomEntity convertEntity(RoomDto dto, RoomEntity roomEntity) {
		roomEntity.setName(dto.getName());
		roomEntity.setDescription(dto.getDescription());
		roomEntity.setRoomType(dto.getRoomType());
		roomEntity.setPrice(dto.getPrice());
		if(dto.getRoomImgs().getCateOfImg().equals(EImage.Nomal)) {
			roomEntity.setImages(dto.getRoomImgs());;
		}
		if(dto.getPriceImgs().getCateOfImg().equals(EImage.Price)) {
			roomEntity.setImages(dto.getPriceImgs());
		}
		roomEntity.setStuffs(dto.getStuffs());
		return roomEntity;
				
	}
}
