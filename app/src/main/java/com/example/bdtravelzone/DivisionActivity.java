package com.example.bdtravelzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DivisionActivity extends AppCompatActivity {


//    int[] DivisionImages = {R.drawable.aa,R.drawable.bb,R.drawable.cc,
//            R.drawable.dd,R.drawable.ff,R.drawable.gg,R.drawable.hh,
//            R.drawable.icon};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> Adapter;
    Context context;
    ArrayList<String> divisionNames = new ArrayList<>((Arrays.asList("ঢাকা বিভাগ","চট্টগ্রাম বিভাগ",
        "রাজশাহী বিভাগ","কুমিল্লা বিভাগ","খুলনা বিভাগ","বরিশাল বিভাগ","সিলেট বিভাগ","ময়মনসিংহ বিভাগ")));

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);


        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.divisionAutotextSearchId);
        Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,divisionNames);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(Adapter);




        setTitle("বিভাগ নির্বাচন করুন");//adding back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView  = (RecyclerView) findViewById(R.id.DivisionRecycleViewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DivisionAdapter divisionAdapter = new DivisionAdapter(divisionNames, this);
        recyclerView.setAdapter(divisionAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String division = autoCompleteTextView.getText().toString();
                context = view.getContext();
                if(division.equalsIgnoreCase("চট্টগ্রাম বিভাগ"))
                {
                    Intent intent = new Intent(context, CtgDistrictActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }}

//        DivisionName = getResources().getStringArray(R.array.select_division);
//
//        divisionAdapter = new DivisionAdapter(DivisionActivity.this,DivisionName);
//        recyclerView.setAdapter(divisionAdapter);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//
//        divisionAdapter.setOnItemClickListener(new DivisionAdapter.ClickListener() {
//            @Override
//            public void onItemClick(int position, View v) {
//                Toast.makeText(DivisionActivity.this, "onItem Clicked"+position,Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onItemLongClick(int position, View v) {
//                Toast.makeText(DivisionActivity.this, "onItem Clicked"+position,Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    //adding back button listener first method
//
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if(item.getItemId()==android.R.id.home)
//        {
//            this.finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}

