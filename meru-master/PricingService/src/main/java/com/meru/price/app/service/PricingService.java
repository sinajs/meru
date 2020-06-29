package com.meru.price.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meru.price.app.entity.Price;

@Service
public interface PricingService {
    public List<Price> getAllProductsPrice();

    public Price getPriceById(int priceId);

    public Price getPriceByProductId(int productId);

    public boolean createOrUpdatePrice(Price price);

    public boolean removePrice(int priceId);
}
