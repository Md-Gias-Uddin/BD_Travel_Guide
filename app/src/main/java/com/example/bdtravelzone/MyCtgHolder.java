package com.example.bdtravelzone;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyCtgHolder extends RecyclerView.ViewHolder{

    TextView textView1;
    public MyCtgHolder(@NonNull View itemView) {
        super(itemView);
        textView1 = itemView.findViewById(R.id.text_Ctg_district_RecycleId);
    }


}