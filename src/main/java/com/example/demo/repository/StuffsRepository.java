package com.example.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StuffsEntity;
@Repository
public interface StuffsRepository extends JpaRepository<StuffsEntity, Long> {
	Set<StuffsEntity> findAllByRoomId(Long id);
}
