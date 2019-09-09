package net.javaguides.springboot.fileuploaddownload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.fileuploaddownload.service.FileStorageService;

@RestController
public class FileNameController {

	@Autowired
	private FileStorageService fileStorageService;

	@GetMapping("/viewFiles")
	public ResponseEntity uploadFile() {
		return new ResponseEntity(new CustomResponseEntity().getResponseObject(fileStorageService.listFilesAndFolders()),
				HttpStatus.OK);
	}

}
