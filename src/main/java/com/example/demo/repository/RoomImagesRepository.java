package com.example.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RoomImagesEntity;
@Repository
public interface RoomImagesRepository extends JpaRepository<RoomImagesEntity, Long> {
	Set<RoomImagesEntity> findAllByRoomId(Long roomId);
} 