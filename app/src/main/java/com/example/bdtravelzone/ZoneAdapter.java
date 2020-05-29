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

public class ZoneAdapter extends RecyclerView.Adapter<ZoneHolder> {
    private final ArrayList<String> zoneNames;
    int[] zoneImages;
    //String[] zoneNames;//
    // ArrayList<String> zoneNames;//for Array<String>
    Context context;

    public ZoneAdapter(int[] zoneImages, ArrayList<String> zoneNames, Context context) {
        this.zoneImages = zoneImages;
        this.zoneNames = zoneNames;
        this.context = context;
    }

    @NonNull
    @Override
    public ZoneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zone_review_cycle,parent,false);
        ZoneHolder zoneHolder = new ZoneHolder(view);
        return zoneHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ZoneHolder holder, final int position) {
        holder.textView.setText(zoneNames.get(position));//for Array<String>
       //holder.textView.setText(zoneNames[position]);
       holder.imageView.setImageResource(zoneImages[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position==0)//zoneNames.get(position).equalsIgnoreCase("Dim"))
                {   Toast.makeText(context,"Nilgiri",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(v.getContext(), NilgiriActivity.class);
//                    v.getContext().startActivity(intent);

                }
                else if(position==1)//zoneNames.get(position).equalsIgnoreCase("Dim"))
                {   //Toast.makeText(context,"Nilgiri",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), NilacholActivity.class);
                    v.getContext().startActivity(intent);

                }else if(position==2)//zoneNames.get(position).equalsIgnoreCase("Dim"))
                {   Toast.makeText(context,"Dimpahar",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(v.getContext(), DimPaharDescriptionActivity.class);
//                    v.getContext().startActivity(intent);

                }else if(position==3)//zoneNames.get(position).equalsIgnoreCase("Dim"))
                {
                    Toast.makeText(context,"Megla",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return zoneNames.size(); //for Array<String>
    //return zoneNames.length;
    }
}

//    public ZoneAdapter(ArrayList<String> zoneNames, Context context) {
//        this.zoneNames = zoneNames;
//        this.context = context;
//        this.zoneImages = zoneImages;
//    }
//
//    public ZoneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View v = LayoutInflater.from(context).inflate(R.layout.zone_review_cycle,parent,false);
//        ZoneHolder zoneHolder = new ZoneHolder(v);
//        return v;
//    }
//
//
//    public void onBindViewHolder(@NonNull ZoneHolder holder, final int position) {
//        holder.textView.setText(zoneNames.get(position));
//        holder.imageView.setImageResource(zoneImages[position]);
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"ole",Toast.LENGTH_SHORT).show();
//                if(zoneNames.get(position).equalsIgnoreCase("Dhaka Division"))
//                {
//                    Intent intent = new Intent(context, CtgDistrictActivity.class);
//                    context.startActivity(intent);
//
//                }
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return zoneNames.size();
//    }
//}

