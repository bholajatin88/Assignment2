package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //declaring local variables
    TextView price, total, totalLbl;
    ImageView productImg;
    Spinner sp;
    Button more, order;
    //initializing product names for setting up spinner
    String[] productNames = {"Samsung Galaxy S20 FE 5G",
            "Samsung Galaxy S21+ 5G", "Samsung Galaxy Buds Pro (black)",
            "iPHONE 12 PRO MAX", "iPHONE 11"};
    //storing list of products
    ArrayList<Product> productList = new ArrayList<>();
    //public shared variable to store the selected product details
    public static Product productSelected;
    //public shared variable to store the cart total amount
    public static double cartTotal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize product data array list
        fillData();
        price = findViewById(R.id.txvPrice);
        total = findViewById(R.id.txvTotal);
        totalLbl = findViewById(R.id.txvTotalLbl);
        productImg = findViewById(R.id.imvProduct);
        sp = findViewById(R.id.spProduct);
        more = findViewById(R.id.btnMore);
        order = findViewById(R.id.btnOrder);

        //setting up spinner
        ArrayAdapter aa = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, productNames);
        sp.setAdapter(aa);

        //spinner on click listener
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //set selected product attributes and public variable with complete selected product object
                price.setText(String.valueOf(productList.get(position).getPrice()));
                productImg.setImageResource(productList.get(position).getProdImg());
                productSelected = productList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //no implementation
            }
        });

        //setting more button click listener
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //moving to next screen to view details
                Intent intent = new Intent(getBaseContext(), DetailsActivity.class);
                startActivity(intent);
            }
        });

        //order button click listener
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate that cart total is empty or not
                if(cartTotal == 0.0) {
                    Toast.makeText(getBaseContext(), "Please add atleast one item in cart to place the order.", Toast.LENGTH_LONG).show();
                } else {
                    //change visibility to view order total
                    order.setVisibility(View.INVISIBLE);
                    total.setText(String.valueOf(cartTotal));
                    total.setVisibility(View.VISIBLE);
                    totalLbl.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void fillData(){
        //setting list of products
        productList.add(new Product("Samsung Galaxy S20 FE 5G","Display 6.50-inch (1080x2400)\n" +
                "Processor Samsung Exynos 990.\n" +
                "Front Camera 32MP.\n" +
                "Rear Camera 12MP + 12MP + 8MP.\n" +
                "RAM 8GB.\n" +
                "Storage 128GB.\n" +
                "Battery Capacity 4500mAh.\n" +
                "OS Android 10.", 1200.0 , R.mipmap.samsung_galaxy_s20_fe_blue_5g_lrg1));
        productList.add(new Product("Samsung Galaxy S21+ 5G","All the new Samsung Galaxy S21 5G, S21+ 5G,\n" +
                "S21 Ultra 5G are equipped with an eSIM\n. Thanks to the eSIM, users will be able to use dual SIM cards.",
                1700.0, R.mipmap.samsung_galaxy_s21_plus_black_5g_lrg1));
        productList.add(new Product("Samsung Galaxy Buds Pro (black)","Truly wireless earbuds, with " +
                "pro-grade technology for \nimmersive sound like never before from Galaxy.\n" +
                "Enjoy studio-quality sound thanks to larger drivers,\nand ultra-clear calling thanks to the wind shield solution.",
                264.99, R.mipmap.samsung_galaxy_buds_pro_black_lrg));
        productList.add(new Product("iPHONE 12 PRO MAX","6.7-inch Super Retina XDR display*\n" +
                "Ceramic Shield, tougher than any smartphone glass\n" +
                "A14 Bionic chip, the fastest chip ever in a smartphone",1596, R.mipmap.iphone12_pro_max));
        productList.add(new Product("iPHONE 11","6.1-inch Liquid Retina HD LCD display.*\n" +
                "Water and dust resistant (2 meters for up to 30 minutes, IP68).**\n" +
                "Dual-camera system with 12 MP Ultra Wide and Wide cameras; Night mode, Portrait mode, and 4K video up to 60fps.\n" +
                "12 MP TrueDepth front camera with Portrait mode, 4K video, and Slo-Mo.\n", 875.0, R.mipmap.iphone11));
    }
}