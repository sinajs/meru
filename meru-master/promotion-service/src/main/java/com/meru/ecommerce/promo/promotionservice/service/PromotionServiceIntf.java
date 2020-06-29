package com.meru.ecommerce.promo.promotionservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meru.ecommerce.promo.promotionservice.entity.Promotion;
@Service
public interface PromotionServiceIntf {

	List<Promotion> getAllPromotions();

	Promotion createPromotions(int productId);

	Promotion updatePromotions(int id, Promotion promo);

}
