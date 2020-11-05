package com.company.androidmvc.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> productList = new ArrayList<Product>();

    public Product getProducts(int position) {
        return productList.get(position);
    }

    public void setProductList(Product products) {
        productList.add(products);
    }

    public int getCartSize() {
        return productList.size();
    }

    public boolean isProductInCart(Product productInCart) {
        return productList.contains(productInCart);
    }
}
