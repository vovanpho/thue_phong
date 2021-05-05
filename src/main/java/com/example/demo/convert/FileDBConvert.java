package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.FileDBDto;
import com.example.demo.entity.FileDBEntity;

@Component
public class FileDBConvert implements BaseConverter<FileDBEntity, FileDBDto> {
	

	@Override
	public FileDBEntity toEntity(FileDBDto dto) {
		// TODO Auto-generated method stub
		FileDBEntity entity = new FileDBEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getNameImage());
		entity.setCateOfImg(dto.getCateOfImg());
		return entity;
	}

	@Override
	public FileDBDto toDto(FileDBEntity entity) {
		// TODO Auto-generated method stub
		FileDBDto dto = new FileDBDto();
		dto.setId(entity.getId());
		dto.setNameImage(entity.getName());
		dto.setCateOfImg(entity.getCateOfImg());
		dto.setType(entity.getType());
		dto.setData(entity.getData());
		dto.setRoom(entity.getRoom());
		return dto;
	}
}
