package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    //declaring local variables
    TextView title, description;
    RadioButton qty1, qty2, qty3;
    Button back, addToCart;
    //initialize quantity to 1 for default radio button selection
    int qty = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //initializing local variables
        title = findViewById(R.id.txvProductName);
        description = findViewById(R.id.txvDescription);
        qty1 = findViewById(R.id.radioqty1);
        qty2 = findViewById(R.id.radioqty2);
        qty3 = findViewById(R.id.radioqty3);
        back = findViewById(R.id.btnBack);
        addToCart = findViewById(R.id.btnAdd);
        //setting name as title and description of selected product
        title.setText(MainActivity.productSelected.getName());
        description.setText(MainActivity.productSelected.getDescription());
        //setting radio button click events
        qty1.setOnClickListener(new RadioButtonEvents());
        qty2.setOnClickListener(new RadioButtonEvents());
        qty3.setOnClickListener(new RadioButtonEvents());

        //setting back button on click listener
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //moving back to main page
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        //setting add to cart on click listener
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //updating cart total by adding amount of selected product * qty
                //moving back to main page
                MainActivity.cartTotal += MainActivity.productSelected.getPrice() * qty;
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //class for the radio buttons events
    private class RadioButtonEvents implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //updating quantity based on specific radio button click event
            switch(v.getId()){
                case R.id.radioqty1:
                    qty = 1;
                    break;
                case R.id.radioqty2:
                    qty = 2;
                    break;
                case R.id.radioqty3:
                    qty = 3;
            }
        }
    }
}