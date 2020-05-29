package com.example.bdtravelzone;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    int[] images = {R.drawable.place,R.drawable.note,R.drawable.instructions};
    String[] name;
    MyAdapter myAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.ic_home_black_24dp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        recyclerView = findViewById(R.id.recycleViewId);

        name = getResources().getStringArray(R.array.select_option);

        myAdapter = new MyAdapter(this,images,name);
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                //Toast.makeText(MainActivity.this, "onItem Clicked ",Toast.LENGTH_SHORT).show();
                if(position==0)
                {
                    Intent intent = new Intent(MainActivity.this, DivisionActivity.class);
                    startActivity(intent);
                }
                else if(position==1){
                    Intent intent = new Intent(MainActivity.this, DiaryActivity.class);
                    startActivity(intent);
                    //Toast.makeText(MainActivity.this,"Yes",Toast.LENGTH_SHORT).show();
                }
                else if (position==2)
                {
                    Intent intent = new Intent(MainActivity.this, InstructionsActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(MainActivity.this, "onLongItem Clicked ",Toast.LENGTH_SHORT).show();
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_share, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void onBackPressed(){
        isFinish("Do you want to exit?");}
        public void isFinish(String alertmessage){
            DialogInterface.OnClickListener dialoglistener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch(which)
                    {
                        case DialogInterface.BUTTON_POSITIVE:
                        {
                           Intent intent = new Intent(Intent.ACTION_MAIN);
                           intent.addCategory(Intent.CATEGORY_HOME);
                           startActivity(intent);
                        }
                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                }
            }
        };

        AlertDialog.Builder alertDialog =  new AlertDialog.Builder(this);
        //alertDialog.setTitle("Warning!");
        alertDialog.setMessage(alertmessage).setPositiveButton("Yes", dialoglistener)
                .setNegativeButton("No", dialoglistener).show();
//        AlertDialog alert = alertDialog.create();
//        alertDialog.show();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.shareId) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject = "BD Travel App";
            String body = "Download this";

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);

            startActivity(Intent.createChooser(intent, "Share With"));

        }
        else if (item.getItemId() == R.id.feedbackId) {
            Intent intent = new Intent(MainActivity.this, feedBackActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.rateUsId) {
            Intent intent = new Intent(MainActivity.this, rateUsActivity.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.aboutUsId) {
            Intent intent = new Intent(MainActivity.this, aboutUsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    }
