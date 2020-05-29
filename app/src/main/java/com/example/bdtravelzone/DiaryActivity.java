package com.example.bdtravelzone;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class DiaryActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText locationText,dateText,costText,tourNoText;
    private Button  btn_save,btn_show,btn_delete,btn_update;
    MyDatabaseHelper myDatabaseHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =myDatabaseHelper.getWritableDatabase();

        btn_show =(Button) findViewById(R.id.show_btn_Id);
        btn_save =(Button) findViewById(R.id.save_btn_Id);
        btn_delete =(Button) findViewById(R.id.delete_btn_Id);
        btn_update =(Button) findViewById(R.id.update_btn_Id);

        locationText =(EditText) findViewById(R.id.locationTextId);
        dateText =(EditText) findViewById(R.id.dateTextId);
        costText =(EditText) findViewById(R.id.costTextId);
        tourNoText = (EditText) findViewById(R.id.tourIdTextId);

        btn_save.setOnClickListener(this);
        btn_show.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String location = locationText.getText().toString();
        String date = dateText.getText().toString();
        String cost = costText.getText().toString();
        String tourNo = tourNoText.getText().toString();

        if(v.getId()==R.id.save_btn_Id){

            if(location.equals("") && date.equals("") && cost.equals("") && tourNo.equals(""))
            {
                Toast.makeText(getApplicationContext()," Please Enter Data",Toast.LENGTH_LONG).show();
            }
            else{
                long rowID = myDatabaseHelper.insertData(location,date,cost);
                if(rowID==-1){
                    Toast.makeText(getApplicationContext()," Data Store failed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext()," Data Stored successfully",Toast.LENGTH_SHORT).show();
                    locationText.setText("");
                    dateText.setText("");
                    costText.setText("");
                    tourNoText.setText("");

                }
            }

        }

        else if(v.getId() == R.id.show_btn_Id)
        {
            Intent intent = new Intent(DiaryActivity.this,listActivity.class);
            startActivity(intent);
        }

        else if(v.getId()==R.id.update_btn_Id)
        {
            Boolean isUpdated = myDatabaseHelper.updateData(tourNo,location,date,cost);

            if(isUpdated)
            {
                Toast.makeText(getApplicationContext()," Data is Updated ",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext()," Data is not updated ",Toast.LENGTH_SHORT).show();
            }
            tourNoText.setText("");
        }
        else if(v.getId() ==R.id.delete_btn_Id ){
            int value = myDatabaseHelper.deleteData(tourNo);
            if(value>0){
                Toast.makeText(getApplicationContext()," Data is deleted ",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext()," Data is not deleted ",Toast.LENGTH_SHORT).show();
            }
            tourNoText.setText("");
        }
    }


}
