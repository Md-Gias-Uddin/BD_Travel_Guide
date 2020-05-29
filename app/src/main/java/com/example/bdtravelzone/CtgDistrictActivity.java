package com.example.bdtravelzone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Handler;

public class CtgDistrictActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> districtNames = new ArrayList<>((Arrays.asList("চট্টগ্রাম","বান্দরবান",
            "ব্রাহ্মণবাড়িয়া","চাঁদপুর","কক্সবাজার","ফেনী","খাগড়াছড়ি","লক্ষ্মীপুর","নোয়াখালি","রাঙামাটি")));

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctgdistrict);

        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.districtAutotextSearchId);

        setTitle("জেলা নির্বাচন করুন");//adding back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,districtNames);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = autoCompleteTextView.getText().toString();

                if(value.equalsIgnoreCase("বান্দরবান"))
                {
                    Intent intent = new Intent(CtgDistrictActivity.this, ZoneActivity.class);
                    startActivity(intent);
                }
            }
        });

        RecyclerView recyclerView  = findViewById(R.id.district_recycleViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CtgDistrictAdapter ctgDistrictAdapter = new CtgDistrictAdapter(districtNames, this);
        recyclerView.setAdapter(ctgDistrictAdapter);}

}