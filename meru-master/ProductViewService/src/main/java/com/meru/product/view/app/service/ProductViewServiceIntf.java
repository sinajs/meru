package com.meru.product.view.app.service;

import java.util.List;

import com.meru.product.view.app.entiry.Inventory;
import com.meru.product.view.app.entiry.Price;
import com.meru.product.view.app.entiry.Product;
import com.meru.product.view.app.entiry.ProductViewModel;
import com.meru.product.view.app.entiry.Promotion;

public interface ProductViewServiceIntf {

	public boolean removeProductView(int productViewId);

    public List<ProductViewModel> getAllProductViews();

    public ProductViewModel getProductViewById(int productViewId);

    public boolean createOrUpdateProductView(ProductViewModel productView);

    public boolean createOrUpdateProductInProductView(int productId, Product product);

    public boolean createOrUpdateInventoryInProductView(int productId, Inventory inventory);

    public boolean createOrUpdatePriceInProductView(int productId, Price price);

    public boolean createOrUpdatePromotionInProductView(int productId, Promotion promotion);


}
