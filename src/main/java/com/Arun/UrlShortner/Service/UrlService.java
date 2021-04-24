package com.Arun.UrlShortner.Service;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arun.UrlShortner.Entity.UrlShortnerEntity;
import com.Arun.UrlShortner.Repository.UrlRepo;
import com.Arun.UrlShortner.dto.UrlShortnerDto;

@Service
public class UrlService {

	@Autowired
	UrlRepo urlRepo;
	
	public Map<String, UrlShortnerDto> url = new HashMap<>();
	
	public String createRandomChars() {
		String randomStr = "";
		String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++)
			randomStr += possibleChars.charAt((int) Math.floor(Math.random() * possibleChars.length()));
		return randomStr;
	}
	
	public void shortenUrl(String randomChar, UrlShortnerDto dto) throws MalformedURLException {
		 dto.setShortUrl("http://localhost:8081/s/" + randomChar);
		 url.put(randomChar, dto);
	}
	
	public void SaveData(UrlShortnerDto dto) {
		UrlShortnerEntity entity = new UrlShortnerEntity();
		entity.setOriginalUrl(dto.getOriginalUrl());
		entity.setShortUrl(dto.getShortUrl());
		urlRepo.save(entity);
	}

	public List<UrlShortnerEntity> getAll() {
		return urlRepo.findAll();
	}

}
