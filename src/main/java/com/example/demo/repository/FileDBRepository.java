package com.example.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FileDBEntity;



@Repository
public interface FileDBRepository extends JpaRepository<FileDBEntity, String> {
	Set<FileDBEntity> findAllByRoomId(String id);
}
