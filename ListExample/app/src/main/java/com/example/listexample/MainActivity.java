package com.example.listexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listview;
    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();
    ArrayList<String> arrLang = new ArrayList<>();
//    int[] arrNo = new int[]{1,2,3,4,5,6,7,8,9,10};
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listview = findViewById(R.id.listview);
        arrNames.add("Om");
        arrNames.add("Laddi");
        arrNames.add("Guddy");
        arrNames.add("Nandi");
        arrNames.add("Situ");
        arrNames.add("Ritu");
        arrNames.add("Liku");
        arrNames.add("Ditu");
        arrNames.add("Ezzy");
        arrNames.add("Liza");
        arrNames.add("Sita");
        arrNames.add("Nitu");
        arrNames.add("Rani");
        arrNames.add("Ritu");
        arrNames.add("Liku");
        arrNames.add("Ditu");
        arrNames.add("Ezzy");
        arrNames.add("Liza");
        arrNames.add("Sita");
        arrNames.add("Nitu");
        arrNames.add("Rani");

//        Listview
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrNames);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Toast.makeText(MainActivity.this, "Om is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Spinner
        spinner = findViewById(R.id.spinner);
        arrIds.add("Aadhar Card");
        arrIds.add("Pan Card");
        arrIds.add("Voter Id");
        arrIds.add("Driving License");
        arrIds.add("Passport");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrIds);
        spinner.setAdapter(spinnerAdapter);


        //AutoCompleteTextView
        autoCompleteTextView = findViewById(R.id.auto_complete_text_view);
        arrLang.add("C");
        arrLang.add("C++");
        arrLang.add("Java");
        arrLang.add("Python");
        arrLang.add("Kotlin");
        arrLang.add("Dart");
        arrLang.add("JavaScript");
        arrLang.add("PHP");
        arrLang.add("Ruby");
        arrLang.add("Swift");
        arrLang.add("Go");

        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrLang);
        autoCompleteTextView.setAdapter(autoCompleteAdapter);
//        autoCompleteAdapter.setThreshold(1);
    }
}