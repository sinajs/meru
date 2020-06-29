package com.meru.ecommerce.promo.promotionservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meru.ecommerce.promo.promotionservice.entity.Promotion;
import com.meru.ecommerce.promo.promotionservice.service.PromotionServiceImpl;
import com.netflix.discovery.EurekaClient;

@RestController
public class PromotionController {

	@Autowired
	EurekaClient consumer;

	@Autowired
	RestTemplateBuilder builder;

	@Autowired
	PromotionServiceImpl service;
	
	public PromotionController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(value="/")
	public ResponseEntity<String> showInfo()
	{
		return ResponseEntity.badRequest().headers(new HttpHeaders()).body("Welcome to Promotion details service. This is not a valid service path");
	}
	@PostMapping(value="/add/{prodId}")
	public ResponseEntity<Promotion> createPromotionforProduct(@PathVariable int prodId)
	{
		Promotion iobj=service.createPromotions(prodId);
		return ResponseEntity.ok().body(iobj);
	}
	@GetMapping(value="/all")
	ResponseEntity<List<Promotion>> getAllPromo()
	{
		return new ResponseEntity<List<Promotion>>(service.getAllPromotions(),HttpStatus.OK);
	}
}
