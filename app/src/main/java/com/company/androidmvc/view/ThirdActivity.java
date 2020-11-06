package com.company.androidmvc.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.company.androidmvc.R;
import com.company.androidmvc.controller.Controller;

public class ThirdActivity extends AppCompatActivity {
    private Controller controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        TextView showProductCart = findViewById(R.id.showProductCart);
        controller = (Controller) getApplicationContext();
        int cartSize = controller.getCart().getCartSize();
        showProductCart.setText(showProduct(cartSize));
    }

    public String showProduct(int cartSize) {
        String showCart = "";
        for (int i = 0; i < cartSize; i++) {
            String productName = controller.getCart().getProducts(i).getProductName();
            int productPrice = controller.getCart().getProducts(i).getProductPrice();
            String productDescription = controller.getCart().getProducts(i).getProductDescription();
            showCart = showCart + " Product Name : " + productName + "Price : " + productPrice + "Description : " + productDescription;
        }
        return showCart;
    }
}

