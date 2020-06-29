package com.meru.productdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.productdetails.entity.ProductDetails;
import com.meru.productdetails.repository.ProductDetailsRepository;

@Service
public class ProductDetailService implements ProductDetailsServiceIntf{

	@Autowired
	ProductDetailsRepository repo;
	
	public ProductDetailService() {
		// TODO Auto-generated constructor stub
	}
	
	//add product
	public ProductDetails addProduct(ProductDetails p)
	{
		return repo.save(p);
	}
	
	//get all product details-- list of all products
	public List<ProductDetails> getAllProducts()
	{
		return repo.findAll();
	}
	
	//get product details by id---product
	public ProductDetails getProductById(int id)
	{
		return repo.findOne(id);
	}
	
	//get productdetails by name--list of products containing name
	@Override
	public List<ProductDetails> getProductbyName(String search)
	{
		return repo.findbyName(search);
	}
		
	//delete
	public int deleteProduct(int id)
	{
		return repo.removeProduct(id);
	}





}