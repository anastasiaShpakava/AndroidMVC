package com.company.androidmvc.controller;


import android.app.Application;

import com.company.androidmvc.model.Cart;
import com.company.androidmvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Controller extends Application { //для глобальн. доступа
    private List<Product> myProduct = new ArrayList<>();
    private Cart cart = new Cart();

    public Controller() {
    }

    public Product getProduct(int position) {
        return myProduct.get(position);
    }

    public void setProduct(Product product) {
        myProduct.add(product);
    }

    public Cart getCart() {
        return cart;
    }

    public int getProductArrayListSize() {
        return myProduct.size();
    }
}