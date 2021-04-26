package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.RoomImagesDto;
import com.example.demo.entity.RoomImagesEntity;

@Component
public class RoomImageConvert implements BaseConverter<RoomImagesEntity, RoomImagesDto> {
	

	@Override
	public RoomImagesEntity toEntity(RoomImagesDto dto) {
		// TODO Auto-generated method stub
		RoomImagesEntity roomImagesEntity = new RoomImagesEntity();
		roomImagesEntity.setId(dto.getId());
		roomImagesEntity.setNameImage(dto.getName());
		roomImagesEntity.setCateOfImg(dto.getCateOfImg());
		return roomImagesEntity;
	}

	@Override
	public RoomImagesDto toDto(RoomImagesEntity entity) {
		// TODO Auto-generated method stub
		RoomImagesDto roomImagesDto = new RoomImagesDto();
		roomImagesDto.setId(entity.getId());
		roomImagesDto.setName(entity.getNameImage());
		roomImagesDto.setCateOfImg(entity.getCateOfImg());
		return roomImagesDto;
	}
}
