package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.StuffsDto;
import com.example.demo.entity.StuffsEntity;

@Component
public class StuffsConvert implements BaseConverter<StuffsEntity, StuffsDto>{

	@Override
	public StuffsEntity toEntity(StuffsDto dto) {
		// TODO Auto-generated method stub
		StuffsEntity entity = new StuffsEntity();
		entity.setId(dto.getId());
		entity.setNameStuff(dto.getNameStuff());
		entity.setQuality(dto.getQuality());
		entity.setDescription(dto.getDescription());

		return entity;
	}

	@Override
	public StuffsDto toDto(StuffsEntity entity) {
		// TODO Auto-generated method stub
		StuffsDto dto = new StuffsDto();
		dto.setId(entity.getId());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setLastModifiedBy(entity.getLastModifiedBy());
		dto.setLastModifiedDate(entity.getLastModifiedDate());
		dto.setNameStuff(entity.getNameStuff());
		dto.setDescription(entity.getDescription());
		dto.setQuality(entity.getQuality());

		return dto;
	}

}
