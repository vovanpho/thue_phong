package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.FileDBEntity;
import com.example.demo.message.ResponseFile;
import com.example.demo.message.ResponseMessage;
import com.example.demo.services.impl.FileStorageServiceImpl;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/")
public class FileDBController {

  @Autowired
  private FileStorageServiceImpl storageService;

  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(
		  @RequestParam("file") List<MultipartFile> files, 
		  @RequestParam("cateOfImg") String cateOfImg,
		  @RequestParam("id") String id){
    String message = "";
    try {
      storageService.store(files, cateOfImg, id);

      message = "Uploaded the file successfully ";
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file " ;
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    FileDBEntity fileDB = storageService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
}
