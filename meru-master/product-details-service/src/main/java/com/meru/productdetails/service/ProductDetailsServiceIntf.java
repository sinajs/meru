package com.meru.productdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meru.productdetails.entity.ProductDetails;

@Service
public interface ProductDetailsServiceIntf {
	
	List<ProductDetails> getAllProducts();
	
	ProductDetails getProductById(int id);
	
	List<ProductDetails> getProductbyName(String name);
	
	ProductDetails addProduct(ProductDetails pro);
	
	int deleteProduct(int id);

}
