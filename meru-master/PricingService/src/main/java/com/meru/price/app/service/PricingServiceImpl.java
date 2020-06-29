package com.meru.price.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.price.app.entity.Price;
import com.meru.price.app.repository.PriceRepository;

@Service("PriceService")
public class PricingServiceImpl implements PricingService {

    @Autowired
    PriceRepository pr;

    @Override
    public List<Price> getAllProductsPrice() {
        return pr.findAll();
    }

    @Override
    public Price getPriceById(int priceId) {
        return pr.findOne(priceId);
    }

    @Override
    public Price getPriceByProductId(int productId) {
        return pr.getByProductId(productId);
    }

    @Override
    public boolean createOrUpdatePrice(Price price) {
        Price updatedPrice = pr.save(price);
        boolean status = false;
        if (null != updatedPrice) {
            status = true;
        }
        return status;
    }

    @Override
    public boolean removePrice(int priceId) {
        Price deletedPrice = pr.findOne(priceId);
        pr.delete(priceId);
        boolean deleted = false;
        if (null != deletedPrice) {
            deleted = true;
        }
        return deleted;
    }

	public Price createPrice(int productId) {
		// TODO Auto-generated method stub
		Price price=new Price();
		price.setProductId(productId);
		price.setPrice(100);
		return price;
	}
}

