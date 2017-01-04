package ru.converter.project.web.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.google.common.net.MediaType;

import ru.converter.project.web.references.ConverterReference;

@Controller
public class ConverterController extends BaseController {

	@RequestMapping(value = ConverterReference.PATH, method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> doPost(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,
			ConverterReference ref) throws FileNotFoundException {
		File pdf = ref.doPost(Lists.newArrayList(file), name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.PDF.toString());
		return new ResponseEntity<InputStreamResource>(new InputStreamResource(new FileInputStream(pdf)), headers,
				HttpStatus.CREATED);
	}

	@RequestMapping(value = ConverterReference.PATH, method = RequestMethod.OPTIONS)
	@ResponseStatus(HttpStatus.OK)
	public void doOptions(HttpServletRequest request, HttpServletResponse response) {
		super.doOptions(request, response);
	}
}
