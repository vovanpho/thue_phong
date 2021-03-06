package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoomDto;
import com.example.demo.dto.StuffsDto;
import com.example.demo.entity.KeyRoomStuff;
import com.example.demo.entity.RoomEntity;
import com.example.demo.entity.RoomTypeEntity;
import com.example.demo.entity.StuffsEntity;
import com.example.demo.services.impl.RoomServiceImpl;
import com.example.demo.services.impl.RoomStuffServiceImpl;
import com.example.demo.services.impl.StuffsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/room")
public class RoomController {
	
	@Autowired 
	private	RoomServiceImpl roomServiceImpl;
	
	@Autowired
	private RoomStuffServiceImpl roomStuffServiceImpl;
	
	@Autowired
	private StuffsServiceImpl stuffsServiceImpl;
	
	
	@GetMapping("/getdata")
	public List<RoomDto> getAlldata(){
		return roomServiceImpl.findAll();
	}
	
	@PostMapping("/set-data-room")
	public ResponseEntity<String> setData(@RequestBody RoomDto roomDto) {
		if(roomServiceImpl.save(roomDto) != null) {
			return new ResponseEntity<>("susas", HttpStatus.OK);
		}
		return new ResponseEntity<>("not", HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> detele(@RequestBody RoomDto roomDto) {
		if(roomServiceImpl.delete(roomDto)) {
			return new ResponseEntity<>("su", HttpStatus.OK);
		}
		return new ResponseEntity<>("not", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/set-data-room_stuff/{id}/{e}")
	public ResponseEntity<String> setDatarRoomStuff(@PathVariable String e, @PathVariable String id) {
		RoomEntity roomEntity =  roomServiceImpl.findOneById(id);
		StuffsEntity stuffsEntity = stuffsServiceImpl.findOneById(e);
		if(roomStuffServiceImpl.save(roomEntity, stuffsEntity) != null) {
			return new ResponseEntity<>("susas", HttpStatus.OK);
		}
		return new ResponseEntity<>("not", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/delete-stuff/{id}/{e}")
	public ResponseEntity<String> detele(@PathVariable String e, @PathVariable String id) {
		RoomEntity roomEntity = roomServiceImpl.findOneById(id);
		StuffsEntity stuffsEntity = stuffsServiceImpl.findOneById(e);
		System.out.println(roomEntity);
		if(roomStuffServiceImpl.delete(roomEntity,stuffsEntity)) {
			return new ResponseEntity<>("su", HttpStatus.OK);
		}
		return new ResponseEntity<>("not", HttpStatus.BAD_REQUEST);
	}
	
	
}
