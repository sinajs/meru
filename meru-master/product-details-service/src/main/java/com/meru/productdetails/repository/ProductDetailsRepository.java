package com.meru.productdetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meru.productdetails.entity.ProductDetails;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{
	
	@Query("select p from ProductDetails p where p.productName like %:name%")
	List<ProductDetails> findbyName(@Param("name") String name);
	
	@Transactional
	@Modifying
	@Query("update ProductDetails p set p.productStatus= 'Discontinued' where p.id=:id")
	int removeProduct(@Param("id")int id);
	
	
	
	
}
