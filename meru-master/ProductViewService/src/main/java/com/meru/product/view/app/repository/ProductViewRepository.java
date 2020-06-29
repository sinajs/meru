package com.meru.product.view.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meru.product.view.app.entiry.ProductViewModel;

@Repository("ProductViewRepository")
public interface ProductViewRepository extends JpaRepository<ProductViewModel, Integer> {
    @Query("select pv from ProductViewModel"
    		+ " pv where pv.productId=:productId")
    public ProductViewModel getByProductId(@Param("productId") int productId);
}

