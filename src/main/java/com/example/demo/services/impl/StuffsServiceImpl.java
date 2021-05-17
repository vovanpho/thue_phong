package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.StuffsConvert;
import com.example.demo.dto.StuffsDto;
import com.example.demo.entity.StuffsEntity;
import com.example.demo.repository.StuffsRepository;
import com.example.demo.services.IStuffsService;

@Service
public class StuffsServiceImpl implements IStuffsService{

	@Autowired
	private StuffsRepository stuffsRepository;
	@Autowired
	private StuffsConvert stuffsConvert;
	@Autowired
	private RoomStuffServiceImpl roomStuffServiceImpl;
	
	@Override
	public StuffsEntity save(StuffsDto stuffsDto) {
		// TODO Auto-generated method stub
		return stuffsRepository.save(stuffsConvert.toEntity(stuffsDto)) ;
	}

	@Override
	public List<StuffsDto> findAll() {
		// TODO Auto-generated method stub
		List<StuffsDto> listDto= new ArrayList<StuffsDto>();
		stuffsRepository.findAll().forEach(t->
			listDto.add(stuffsConvert.toDto(t)));
		return listDto;
	}

	@Override
	public Boolean detele(StuffsDto stuffsDto) {
		// TODO Auto-generated method stub
		if(stuffsDto.getId()!=null) {
			roomStuffServiceImpl.findKeyByStuff(
					stuffsRepository.findOneById(stuffsDto.getId()))
					.forEach(t->{
						roomStuffServiceImpl.deleteByKey(t);
					});
			stuffsRepository.deleteById(stuffsDto.getId());
			return true;
		}
		return false;
	}

	public StuffsEntity findOneById(String id) {
		return stuffsRepository.findOneById(id);
	}

}
