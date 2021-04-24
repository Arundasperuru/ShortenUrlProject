package com.Arun.UrlShortner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Arun.UrlShortner.Entity.UrlShortnerEntity;

@Repository
public interface UrlRepo extends JpaRepository<UrlShortnerEntity, Integer>{
	
}
