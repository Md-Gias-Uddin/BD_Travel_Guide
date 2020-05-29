package com.example.bdtravelzone;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listActivity extends AppCompatActivity {

    private ListView listView;
    private MyDatabaseHelper databaseHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView = (ListView) findViewById(R.id.listTextId);
        databaseHelper = new MyDatabaseHelper(this);

        loadData();
    }

    public void loadData(){
        ArrayList<String> arrayList = new ArrayList<>();

        Cursor cursor  = databaseHelper.displayAllData();

        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"No Data available",Toast.LENGTH_SHORT).show();

        }else{
            while(cursor.moveToNext()){
                arrayList.add("Tour ID: "+cursor.getString(0)+"\n"+"Date: "
                        + cursor.getString(1)+"\n"+"Location: "
                        + cursor.getString(2)+"\n"+"Cost: "
                        + cursor.getString(3)+" Taka");
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.listItemTextViewID,arrayList);
        listView.setAdapter(adapter);
    }

}
