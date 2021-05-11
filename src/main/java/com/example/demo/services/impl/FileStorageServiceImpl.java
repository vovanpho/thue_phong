package com.example.demo.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.constant.EImage;
import com.example.demo.entity.FileDBEntity;
import com.example.demo.repository.FileDBRepository;
import com.example.demo.services.IFileDBService;

@Service
public class FileStorageServiceImpl implements IFileDBService {

	  @Autowired
	  private FileDBRepository fileDBRepository;
	  @Autowired
	  private RoomServiceImpl roomServiceImpl;

	
	  public FileDBEntity store(List<MultipartFile> files, String cateOfImg, String id) throws IOException {
		  for(MultipartFile file : files) {
			  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			    EImage cateImg;
			    switch (cateOfImg) {
				case "Price":
					cateImg = EImage.Price;
					break;
				default:
					cateImg = EImage.Nomal;
					break;
				}
			   
			   FileDBEntity FileDB = new FileDBEntity(
					   fileName, 
					   file.getContentType(), 
					   file.getBytes(), 
					   cateImg,  
					   roomServiceImpl.findOneById(id));
			  fileDBRepository.save(FileDB);
		  }
		return null;
	    
	  }

	  public FileDBEntity getFile(String id) {
	    return fileDBRepository.findById(id).get();
	  }
	  
//	  public Stream<FileDBEntity> getAllFiles() {
//	    return fileDBRepository.findAll().stream();
//	  }
	  public List<FileDBEntity> getAllFiles() {
		    return fileDBRepository.findAll();
		  }
	  
	  public Set<FileDBEntity> findAllByRoomId(String id) {
		  return fileDBRepository.findAllByRoomId(id);
	  }
	  
	  public void deteleById(String id) {
		  fileDBRepository.deleteById(id);
	  }
}
