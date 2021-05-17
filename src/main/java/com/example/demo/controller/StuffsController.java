package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StuffsDto;
import com.example.demo.entity.RoomTypeEntity;
import com.example.demo.services.impl.StuffsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/stuffs")
public class StuffsController {
	
	@Autowired
	private StuffsServiceImpl stuffsServiceImpl;
	
	@PostMapping("/set-data-stuff")
	public ResponseEntity<String> setData(@RequestBody StuffsDto stuffsDto){
		if(stuffsServiceImpl.save(stuffsDto)!=null) {
			return new ResponseEntity<>("ok duoc", HttpStatus.OK);
		}
		return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/get-list-data")
	public List<StuffsDto> getAllData(){
		return stuffsServiceImpl.findAll();
	}
	
	
	@PostMapping("/delete")
	public ResponseEntity<String> detele(@RequestBody StuffsDto stuffsDto) {
		if(stuffsServiceImpl.detele(stuffsDto)) {
			return new ResponseEntity<>("su", HttpStatus.OK);
		}
		return new ResponseEntity<>("not", HttpStatus.BAD_REQUEST);
	}
}
