package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RoomTypeEntity;
@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Long> {
	RoomTypeEntity findOneByNameTypeRoom(String name);

	boolean existsById(String id);
}
