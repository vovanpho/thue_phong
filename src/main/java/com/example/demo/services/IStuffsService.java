package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.StuffsDto;
import com.example.demo.entity.StuffsEntity;

public interface IStuffsService {
	List<StuffsDto> findAll();
	StuffsEntity save(StuffsDto stuffsDto);
	Boolean detele (StuffsDto stuffsDto);
 }
