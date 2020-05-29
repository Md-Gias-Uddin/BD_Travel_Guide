package com.example.bdtravelzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ZoneActivity extends AppCompatActivity {


    int[] zoneImages = {R.drawable.nilgiri2,R.drawable.nilacholpic1,R.drawable.dimpahar,
          R.drawable.meghla};
    //String[] zoneNames;

    ArrayList<String> zoneNames = new ArrayList<>((Arrays.asList("নীলগিরি","নীলাচল",
            "ডিমপাহাড়","মেঘলা")));
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);

       // zoneNames = getResources().getStringArray(R.array.zoneName);
        setTitle("বান্দরবানের পর্যটন এলাকাসমূহ");
        //adding back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView  = (RecyclerView) findViewById(R.id.ZoneRecycleViewId);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ZoneAdapter zoneAdapter = new ZoneAdapter(zoneImages,zoneNames, this);
        recyclerView.setAdapter(zoneAdapter);
    }
}

