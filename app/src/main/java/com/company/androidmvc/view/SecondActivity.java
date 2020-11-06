package com.company.androidmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.company.androidmvc.R;
import com.company.androidmvc.controller.Controller;


public class SecondActivity extends AppCompatActivity {
    private Controller controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView showCart = findViewById(R.id.showCart);
        Button toThirdButton = findViewById(R.id.toThird);

        controller = (Controller) getApplicationContext();
        final int cartSize = controller.getCart().getCartSize();

        showCartProducts(cartSize, showCart);

        toThirdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cartSize > 0) {
                    Intent i = new Intent(getBaseContext(), ThirdActivity.class);
                    startActivity(i);
                } else
                    Toast.makeText(getApplicationContext(),
                            "Shopping cart is empty.",
                            Toast.LENGTH_LONG).show();
            }
        });

    }

    public void showCartProducts(int cartSize, TextView showCart) {
        String productInformation = "";
        if (cartSize > 0) {
            for (int i = 0; i < cartSize; i++) {
                String productName = controller.getCart().getProducts(i).getProductName();
                int productPrice = controller.getCart().getProducts(i).getProductPrice();
                String productDescription = controller.getCart().getProducts(i).getProductDescription();
                productInformation = productInformation + " Product Name : " + productName + "Price : " + productPrice + "Description : " + productDescription;
            }
        } else
            productInformation = " Shopping cart is empty. ";
        showCart.setText(productInformation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

