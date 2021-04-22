package com.example.demo.services;

import java.util.Set;

import com.example.demo.dto.RoomImagesDto;
import com.example.demo.entity.RoomImagesEntity;

public interface IRoomImagesService {
		RoomImagesDto save(RoomImagesDto roomImagesDto);
		Set<RoomImagesEntity> findAllByRoomId(Long id);
}
