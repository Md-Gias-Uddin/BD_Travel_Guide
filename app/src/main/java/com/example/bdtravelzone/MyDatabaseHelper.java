package com.example.bdtravelzone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME ="student.db";
    private static final String TABLE_NAME ="diary_dt";
    private static final int VERSION_NUMBER = 1;
    private static final String ID = "_id";
    private static final  String LOCATION = "Location";
    private static final  String DATE = "Date";
    private static final  String COST = "Cost";
    private Context context;
    private static final String CREATE_TABLE ="CREATE TABLE " + TABLE_NAME +"( " + ID + " INTEGER  PRIMARY KEY AUTOINCREMENT ," + DATE + " VARCHAR(20)," + LOCATION + " VARCHAR(20)," + COST + " VARCHAR(20));";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String SELCT_ALL = "SELECT * FROM " + TABLE_NAME;


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"Database Created",Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(context,"Exception "+e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL(DROP_TABLE);
            onCreate(db);
            Toast.makeText(context,"OnUpdate",Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(context,"Exception "+e,Toast.LENGTH_SHORT).show();
        }
    }

    public long insertData(String location,String date,String cost)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LOCATION,location);
        contentValues.put(DATE,date);
        contentValues.put(COST,cost);
        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;

    }
    public Cursor displayAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELCT_ALL,null);
        return cursor;
    }

    public boolean updateData(String tourNo, String location ,String date , String cost){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,tourNo);
        contentValues.put(LOCATION,location);
        contentValues.put(DATE,date);
        contentValues.put(COST,cost);

        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?",new String[] {tourNo});
        return true;
    }

    public int deleteData(String tourNo){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,ID+" = ? ",new String[] {tourNo} );
    }

}

