package com.example.demo.services;

import java.util.Set;

import com.example.demo.entity.StuffsEntity;

public interface IStuffsService {
	StuffsEntity save(StuffsEntity entity);
	Set<StuffsEntity> findAllByRoomId(Long id);
}
