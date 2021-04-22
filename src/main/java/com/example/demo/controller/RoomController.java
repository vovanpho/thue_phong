package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDto;
import com.example.demo.entity.RoomEntity;
import com.example.demo.repository.RoomRepository;
import com.example.demo.services.impl.RoomServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/room")
public class RoomController {
	
	@Autowired 
	private	RoomServiceImpl roomServiceImpl;
	
	@GetMapping("/getdata")
	public List<RoomDto> getAlldata(){
		return roomServiceImpl.findAll();
	}
	
}
