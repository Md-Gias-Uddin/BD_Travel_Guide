package com.example.bdtravelzone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CtgDistrictAdapter extends RecyclerView.Adapter<MyCtgHolder>{

    private ArrayList<String> districtNames;
    private Context context2;

    public CtgDistrictAdapter(ArrayList<String> districtNames, Context context) {
        this.districtNames = districtNames;
        this.context2 = context;
    }

    @NonNull
    @Override
    public MyCtgHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context2).inflate(R.layout.ctg_district_reviewcycle,parent,false);
        return new MyCtgHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCtgHolder holder, final int position) {
        holder.textView1.setText(districtNames.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context2,"pole",Toast.LENGTH_SHORT).show();
                context2 = v.getContext();
                if(districtNames.get(position).equalsIgnoreCase("বান্দরবান"))
                {

                        Intent intent = new Intent(context2, ZoneActivity.class);
                        context2.startActivity(intent);

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return districtNames.size();
    }



}
