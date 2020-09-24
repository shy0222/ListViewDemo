package com.example.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public interface  OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);

    }
    private  OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;

    }
    private List<Goods> goods;

    public MyAdapter(List<Goods> goods) {
        this.goods = goods;
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {
        Goods good = goods.get(position);
        holder.tvTitle.setText(good.getTitle());
        holder.tvPrice.setText(good.getPrice());
        holder.ivPic.setBackgroundResource(good.getIcon());

        if (onItemClickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(view,position);
                }
            });

        }




    }

    @Override
    public int getItemCount() {
        return goods.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvPrice;
        ImageView ivPic;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPrice = itemView.findViewById(R.id.tv_price);
            ivPic = itemView.findViewById(R.id.iv_pic);
        }
    }
}
