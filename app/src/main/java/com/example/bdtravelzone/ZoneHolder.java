package com.example.bdtravelzone;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ZoneHolder extends RecyclerView.ViewHolder{

    TextView textView;
    ImageView imageView;
    public ZoneHolder(@NonNull View itemView) {
        super(itemView);
        textView =(TextView) itemView.findViewById(R.id.ZoneTextViewId);
        imageView = (ImageView) itemView.findViewById(R.id.ZoneImageId);
    }
}