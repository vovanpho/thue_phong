package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.file.FileHandle;

@RestController
@RequestMapping(path = "/api/file")
public class FileController {
	
	@Autowired
	private FileHandle fileHandle;
	@PostMapping
	public ResponseEntity<?> postMethodName(@RequestBody MultipartFile file) {
		//TODO: process POST request
		
		return ResponseEntity.ok().body(fileHandle.save(file));
	}

}
