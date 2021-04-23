package com.example.demo.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHandle {
	@Value("${thuephong.app.file-location}")
	private String pathDir;
	
	public String getDir() {
		List<String> pathStr = Arrays.asList(this.pathDir.split("[\\/]"));
		return String.join(File.separator, pathStr);
	}
	
	public String save(MultipartFile file) {
		File filePath = new File(getDir()+File.separator+file.getOriginalFilename());
		if(!filePath.canWrite()) {
			filePath.getParentFile().mkdir();
		}
		try {
			Files.copy(file.getInputStream(), filePath.toPath(), StandardCopyOption.REPLACE_EXISTING);
			return filePath.getName();
		} catch (IOException e) {
			return null;
		}
		
	}
}
