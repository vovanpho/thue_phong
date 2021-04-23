package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomImagesDto;
import com.example.demo.services.impl.RoomImageSerivceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/room")
public class RoomImagesController {
	
	@Autowired
	private RoomImageSerivceImpl roomImageSerivceImpl;
	
	@PostMapping("/set-data-room-image")
	public ResponseEntity<String> setData(@RequestBody RoomImagesDto roomImagesDto){
		if(roomImageSerivceImpl.save(roomImagesDto) != null) {
			return new ResponseEntity<>("susas", HttpStatus.OK);
		}
		return new ResponseEntity<>("not", HttpStatus.BAD_REQUEST);
	}
}
