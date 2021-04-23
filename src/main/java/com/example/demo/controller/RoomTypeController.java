package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RoomTypeEntity;
import com.example.demo.services.impl.RoomTypeServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/room")
public class RoomTypeController {
	
	@Autowired RoomTypeServiceImpl roomTypeServiceImpl;
	
	@PostMapping("/set-data-type")
	public ResponseEntity<String> setdata(@RequestBody RoomTypeEntity roomTypeEntity){
		if(roomTypeServiceImpl.save(roomTypeEntity) != null) {
			return new ResponseEntity<>("su", HttpStatus.OK);
		}
		return new ResponseEntity<>("not", HttpStatus.BAD_REQUEST);
	}
}
