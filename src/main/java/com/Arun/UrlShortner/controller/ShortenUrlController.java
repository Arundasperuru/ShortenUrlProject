package com.Arun.UrlShortner.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Arun.UrlShortner.Entity.UrlShortnerEntity;
import com.Arun.UrlShortner.Repository.UrlRepo;
import com.Arun.UrlShortner.Service.UrlService;
import com.Arun.UrlShortner.dto.UrlShortnerDto;

@RestController
public class ShortenUrlController {
	@Autowired
	private UrlService urlService;
	
	@Autowired
	UrlRepo urlRepo;

	@GetMapping("/")
	public String Index() {
		return "index";
	}
	
	@PostMapping("/createShortUrl")
	public ResponseEntity<Object> getShortenUrl(@RequestBody UrlShortnerDto dto) throws MalformedURLException {
		String randomChar = urlService.createRandomChars();
		urlService.shortenUrl(randomChar, dto);
		urlService.SaveData(dto);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/s/{randomstring}")
	public void getFullUrl(HttpServletResponse response, @PathVariable("randomstring") String randomString) throws IOException {
		response.sendRedirect(urlService.url.get(randomString).getOriginalUrl());
	}

	@GetMapping("/getAllData")
	public List<UrlShortnerEntity> getDetails() {
		return urlService.getAll();
	}
	
}