package com.meru.product.view.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.product.view.app.entiry.Inventory;
import com.meru.product.view.app.entiry.Price;
import com.meru.product.view.app.entiry.Product;
import com.meru.product.view.app.entiry.ProductViewModel;
import com.meru.product.view.app.entiry.Promotion;
import com.meru.product.view.app.repository.ProductViewRepository;

@Service("ProductViewService")
public class ProductViewServiceImpl implements ProductViewServiceIntf {

	@Autowired
    ProductViewRepository productViewRepository;

	@Override
	public boolean removeProductView(int productViewId) {
		// TODO Auto-generated method stub
		productViewRepository.delete(productViewId);
        return true;

	}

	@Override
	public List<ProductViewModel> getAllProductViews() {
		// TODO Auto-generated method stub
		return productViewRepository.findAll();
	}

	@Override
	public ProductViewModel getProductViewById(int productViewId) {
		// TODO Auto-generated method stub
		return productViewRepository.findOne(productViewId);
	}

	@Override
	public boolean createOrUpdateProductView(ProductViewModel productView) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.save(productView);
        boolean status = false;
        if (null != pv) {
            status = true;
        }
        return status;

	}

	@Override
	public boolean createOrUpdateProductInProductView(int productId, Product product) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.getByProductId(productId);
        if (null != pv) {
            pv.setProduct(product);
        } else {
            pv = new ProductViewModel(productId, product, new Inventory(), new Price(), new Promotion());
        }
        return createOrUpdateProductView(pv);

	}

	@Override
	public boolean createOrUpdateInventoryInProductView(int productId, Inventory inventory) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.getByProductId(productId);
        if (null != pv) {
            pv.setInventory(inventory);
        } else {
            pv = new ProductViewModel(productId, new Product(), inventory, new Price(), new Promotion());
        }
        return createOrUpdateProductView(pv);

	}

	@Override
	public boolean createOrUpdatePriceInProductView(int productId, Price price) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.getByProductId(productId);
        if (null != pv) {
            pv.setPrice(price);
        } else {
            pv = new ProductViewModel(productId, new Product(), new Inventory(), price, new Promotion());
        }
        return createOrUpdateProductView(pv);

	}

	@Override
	public boolean createOrUpdatePromotionInProductView(int productId, Promotion promotion) {
		// TODO Auto-generated method stub
		ProductViewModel pv = productViewRepository.getByProductId(productId);
        if (null != pv) {
            pv.setPromotion(promotion);
        } else {
            pv = new ProductViewModel(productId, new Product(), new Inventory(), new Price(), promotion);
        }
        return createOrUpdateProductView(pv);

	}

    
}
