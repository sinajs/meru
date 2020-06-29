package com.meru.productdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.meru.productdetails.entity.ProductDetails;
import com.meru.productdetails.service.ProductDetailService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/productdetails")
public class ProductDetailsController {
	
	static String UPDATE_MSG = "Update details for ProductID: %s %s";
    static String SUCCESS = "Success";
    static String ERROR = "Failed";
    
    @Autowired
	EurekaClient consumer;

	@Autowired
	RestTemplateBuilder builder;

	@Autowired
	private ProductDetailService obj;
    
	
	
	//default constructor
	public ProductDetailsController() {
		// TODO Auto-generated constructor stub
	}
	

	
	@GetMapping(value="/")
	public ResponseEntity<String> showInfo()
	{
		return ResponseEntity.badRequest().headers(new HttpHeaders()).body("Welcome to product details service. This is not a valid service path");
	}
	
	@PostMapping(value = "/add/")
	public ResponseEntity<ProductDetails> addProduct(@RequestBody ProductDetails pro) {
		ProductDetails pobj=obj.addProduct(pro);
		int proId= pobj.getProductId();
		System.out.println("---------------------"+pobj);
		RestTemplate template = builder.build();
		
		InstanceInfo inventoryInfo = consumer.getNextServerFromEureka("PRODUCT-INVENTORY-SERVICE", false);
		String inventoryBaseUrl = inventoryInfo.getHomePageUrl();
		inventoryBaseUrl = inventoryBaseUrl + "inventory/invent/add/"+proId;
		template.postForEntity(inventoryBaseUrl, null, String.class);

		InstanceInfo pricingInfo = consumer.getNextServerFromEureka("PRICING-SERVICE", false);
		String pricingBaseUrl = pricingInfo.getHomePageUrl();
		pricingBaseUrl = pricingBaseUrl +proId;
		template.postForEntity(pricingBaseUrl, null, String.class);

		InstanceInfo promoInfo = consumer.getNextServerFromEureka("promotion-service", false);
		String promoBaseUrl = promoInfo.getHomePageUrl();
		promoBaseUrl = promoBaseUrl + "add/"+proId;
		template.postForEntity(promoBaseUrl, null,String.class);
		
		InstanceInfo pvsInfo = consumer.getNextServerFromEureka("product-details-service", false);
		String pvsBaseUrl = pvsInfo.getHomePageUrl();
		pvsBaseUrl = pvsBaseUrl + "product";
		template.postForEntity(pvsBaseUrl, pro,String.class);
				
		return ResponseEntity.ok().body(pobj);
	}

	@GetMapping(value="/all")
	public ResponseEntity<List<ProductDetails>> getAllProducts() {
		List<ProductDetails> list = obj.getAllProducts();
		if (list == null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<List<ProductDetails>>(obj.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<ProductDetails> getProductById(@PathVariable int id) {
		ProductDetails pro = obj.getProductById(id);
		HttpStatus status= HttpStatus.OK;
		if (null==pro) {
			status=HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<>(pro,new HttpHeaders(),status);
	}

	@GetMapping(value="/searchbyname/{name}")
	public ResponseEntity<List<ProductDetails>> getMatchingProducts(@PathVariable String name) {
		List<ProductDetails> proList = obj.getProductbyName(name);
		if (proList == null|| proList.size()==0) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(proList);
		}


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProductDetails> deleteProduct(@PathVariable int id) {
		int pro=obj.deleteProduct(id);
		HttpStatus status= HttpStatus.OK;
		if(pro==0)
		{
			status=HttpStatus.NOT_FOUND;
		}
		
		return new ResponseEntity<>(status);
	}

}