package com.meru.price.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meru.price.app.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
	@Query("select price from Price price where price.productId=:productId")
	public Price getByProductId(@Param("productId") int productId);
}
