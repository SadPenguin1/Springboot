package com.example.SpringJPA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

@GetMapping(value ="/upload-file")
public String upLoadFile() {
	return "uploadFile.html";
}
@PostMapping(value ="/upload-file")
public String upLoadFile(@RequestParam(name="file")MultipartFile file) {
	System.out.println("####" + file.getOriginalFilename());
	return "uploadFile.html";
}
}
