package com.meru.ecommerce.promo.promotionservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.ecommerce.promo.promotionservice.entity.Promotion;
import com.meru.ecommerce.promo.promotionservice.repository.PromotionRepo;

@Service
public class PromotionServiceImpl implements PromotionServiceIntf {

	@Autowired
	PromotionRepo repo;

	@Override
	public List<Promotion> getAllPromotions() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Promotion createPromotions(int productId) {
		// TODO Auto-generated method stub
		Promotion promo= new Promotion();
		promo.setProductId(productId);
		promo.setPromoCode("somecode");
		promo.setPromoDescription("some description");
		promo.setPromoEndDate(new Date(2018, 11, 20));
		promo.setPromoStartDate(new Date(2018,9,27));
		promo.setPromoValue(10);
		return repo.save(promo);
	}

	@Override
	public Promotion updatePromotions(int id, Promotion promo) {
		// TODO Auto-generated method stub
		int productId = promo.getProductId();
		String promoCode=promo.getPromoCode();
		String promoDescription=promo.getPromoDescription();
		Date promoStartDate=promo.getPromoStartDate();
		Date promoEndDate=promo.getPromoEndDate();
		int promoValue=promo.getPromoValue();
		
		return repo.save(promo);
	}

}
