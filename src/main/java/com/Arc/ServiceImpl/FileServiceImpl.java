package com.Arc.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Arc.service.FileService;

@Service
public class FileServiceImpl  implements FileService{

	
	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		//file name
		
		String name = file.getOriginalFilename();
		
		//file path
		String filePth = path+ File.separator+ file;
		
		

		//create folder if not created
		
		File file2 = new File(path);
		if (!file2.exists()) {
			
			file2.mkdir();
		}

				
		//file copy
		
		
		Files.copy(file.getInputStream(),Paths.get(filePth));
		
		return name;
	}

}
