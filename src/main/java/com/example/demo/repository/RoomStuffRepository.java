package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.RoomStuffEntity;
import com.example.demo.entity.StuffsEntity;
import com.example.demo.entity.KeyRoomStuff;

@Repository
public interface RoomStuffRepository extends JpaRepository<RoomStuffEntity, KeyRoomStuff> {
	List<RoomStuffEntity> findAllByRoom(RoomEntity roomEntity);
	List<RoomStuffEntity> findAllByStuff(StuffsEntity stuff);
}
