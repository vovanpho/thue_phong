package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StuffsEntity;
import com.example.demo.services.impl.StuffsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/room")
public class StuffsController {
	
	@Autowired
	private StuffsServiceImpl stuffsServiceImpl;
	
	@PostMapping("/set-data-stuff")
	public ResponseEntity<String> setData(@RequestBody StuffsEntity stuffsEntity){
		if(stuffsServiceImpl.save(stuffsEntity)!=null) {
			return new ResponseEntity<>("ok duoc", HttpStatus.OK);
		}
		return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
	}
}
