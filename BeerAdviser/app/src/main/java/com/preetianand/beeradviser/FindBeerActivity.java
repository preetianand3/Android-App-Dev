package com.preetianand.beeradviser;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class FindBeerActivity extends AppCompatActivity {

    final private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view){
        TextView brands = findViewById(R.id.brands);
        Spinner color = findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());

        List<String> brandsList = expert.getBrands(beerType);

        StringBuilder brandsFormatted = new StringBuilder();

        for(String brand: brandsList){
            brandsFormatted.append(brand).append('\n');
        }

        brands.setText(brandsFormatted);
    }
}