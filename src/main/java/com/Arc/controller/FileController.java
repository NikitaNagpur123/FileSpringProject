package com.Arc.controller;

import java.io.IOException;

import org.hibernate.dialect.TiDBSqlAstTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Arc.playload.FileResponse;
import com.Arc.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

	@Value("${project.image}")
	private String path;
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) throws IOException 
	{
	String fileName =	this.fileService.uploadImage(path , image);
	
	return new ResponseEntity<>(new FileResponse(fileName, "Image is successfully uploaded"),HttpStatus.OK);
	}
	
	
}
