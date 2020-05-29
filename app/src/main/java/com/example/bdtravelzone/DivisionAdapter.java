package com.example.bdtravelzone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bdtravelzone.MyViewHolder;

import java.util.ArrayList;

public class DivisionAdapter extends RecyclerView.Adapter<MyViewHolder>{

    ArrayList<String> divisionNames;
    Context context;

    public DivisionAdapter(ArrayList<String> divisionNames, Context context) {
        this.divisionNames = divisionNames;
        this.context = context;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.division_recycle_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textView.setText(divisionNames.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"ole",Toast.LENGTH_SHORT).show();
                if(divisionNames.get(position).equalsIgnoreCase("চট্টগ্রাম বিভাগ"))
                {
                    Intent intent = new Intent(context, CtgDistrictActivity.class);
                    context.startActivity(intent);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return divisionNames.size();
    }
}

//    private static ClickListener clickListener;
//    Context context;
//    //int[] images;
//    String[] names;
//
//    public DivisionAdapter(Context context,String[] names) {
//        this.context = context;
//       // this.images = images;
//        this.names = names;
//    }
//
//
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        LayoutInflater layoutInflater=LayoutInflater.from(context);
//        View view = layoutInflater.inflate(R.layout.division_recycle_view,parent,false);
//
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//        //holder.imageView.setImageResource(images[position]);
//        holder.txtName.setText(names[position]);
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return names.length;
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
//
//
//        TextView txtName;
//        ImageView imageView;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            txtName = itemView.findViewById(R.id.divisionTextId);
//            //imageView = itemView.findViewById(R.id.DivisionImageId);
//
//            itemView.setOnClickListener(this);
//            itemView.setOnLongClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            clickListener.onItemClick(getAdapterPosition(),v);
//        }
//
//        @Override
//        public boolean onLongClick(View v) {
//            clickListener.onItemLongClick(getAdapterPosition(),v);
//            return false;
//        }
//    }
//
//    public interface ClickListener{
//
//        void onItemClick(int position, View v);
//        void onItemLongClick(int position, View v);
//    }
//
//    public void setOnItemClickListener(ClickListener clickListener)
//    {
//        DivisionAdapter.clickListener=clickListener;
//    }
//
//}
