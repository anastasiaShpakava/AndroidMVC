package com.company.androidmvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.company.androidmvc.R;
import com.company.androidmvc.controller.Controller;
import com.company.androidmvc.model.Product;

public class FirstActivity extends AppCompatActivity {
    private Controller controller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        final LinearLayout linearLayout = findViewById(R.id.firstActivityLayout);
        final Button toSecondButton = findViewById(R.id.toSecond);

        controller = (Controller) getApplicationContext();
        createDummyProductsData();
        int productSize = controller.getProductArrayListSize();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        createViewElements(productSize, params, linearLayout);

        toSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(i);
            }
        });

    }

    public void createDummyProductsData() {
        Product addedProduct = null;
        for (int i = 1; i <= 4; i++) {
            int price = 10 + i;
            addedProduct = new Product("Product " + i, "Description " + i, price);
            controller.setProduct(addedProduct);
        }
    }

    public void createViewElements(int productSize, LinearLayout.LayoutParams params, LinearLayout lm) {
        for (int j = 0; j < productSize; j++) {
            String productName = controller.getProduct(j).getProductName();
            int productPrice = controller.getProduct(j).getProductPrice();

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView product = new TextView(this);
            product.setText(" " + productName + "    ");

            ll.addView(product);

            TextView price = new TextView(this);
            price.setText("  $" + productPrice + "     ");

            ll.addView(price);

            final Button addtoCartButton = new Button(this);
            addtoCartButton.setId(j + 1);
            addtoCartButton.setText("Add To Cart");

            addtoCartButton.setLayoutParams(params);

            final int index = j;

            addtoCartButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Log.i("TAG", "index :" + index);
                    Product tempAddedProduct = controller.getProduct(index);
                    if (!controller.getCart().isProductInCart(tempAddedProduct)) {
                        addtoCartButton.setText("Added");
                        controller.getCart().setProductList(tempAddedProduct);

                        Toast.makeText(getApplicationContext(),
                                "Now Cart size: " + controller.getCart().getCartSize(),
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Product " + (index + 1) + " already added in the cart.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });
            ll.addView(addtoCartButton);
            lm.addView(ll);
        }
    }
}
