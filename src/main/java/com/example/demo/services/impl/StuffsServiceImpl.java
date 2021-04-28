package com.example.demo.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StuffsEntity;
import com.example.demo.repository.StuffsRepository;
import com.example.demo.services.IStuffsService;

@Service
public class StuffsServiceImpl implements IStuffsService{

	@Autowired
	private StuffsRepository stuffsRepository;
	
	@Override
	public StuffsEntity save(StuffsEntity entity) {
		// TODO Auto-generated method stub
		return stuffsRepository.save(entity) ;
	}

	@Override
	public Set<StuffsEntity> findAllByRoomId(Long id) {
		// TODO Auto-generated method stub
		return stuffsRepository.findAllByRoomId(id);
	}

	@Override
	public List<StuffsEntity> findAll() {
		// TODO Auto-generated method stub
		return stuffsRepository.findAll();
	}

}
