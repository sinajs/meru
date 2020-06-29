package com.meru.ecommerce.promo.promotionservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meru.ecommerce.promo.promotionservice.entity.Promotion;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion, Integer>{
	
//	@Modifying
//	@Query("UPDATE Promotion p set productId =:productId, promoCode =:promoCode, promoDescription =:promoDescription, promoStartDate =:promoStartDate, promoEndDate =:promoEndDate, promoValue =:promoValue where promoId = :promoId")
//	int updatePromotions(@Param("promoId")int promoId, @Param("productId")int productId, @Param("promoCode")String promoCode, @Param("promoDescription")String promoDescription, @Param("promoStartDate")Date promoStartDate,
//			@Param("promoEndDate")Date promoEndDate, @Param("promoValue")int promoValue);

}
