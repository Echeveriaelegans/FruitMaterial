package com.example.zhangmeng.fruitmaterial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by zhangmeng on 2017/7/14.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context mContext;
    private List<Fruit> fruits;

    public FruitAdapter(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                Log.d(">>>>>>>>>>>",position+"");
                Fruit fruit=fruits.get(position);
                Intent intent=new Intent(mContext,FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getFruitName());
                intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getFruitImage());
                mContext.startActivity(intent);


            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit=fruits.get(position);
        holder.fruitname.setText(fruit.getFruitName());
        Glide.with(mContext).load(fruit.getFruitImage()).into(holder.fruitImage);
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView fruitname;
        ImageView fruitImage;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            fruitImage=itemView.findViewById(R.id.fruit_image);
            fruitname=itemView.findViewById(R.id.fruit_name);

        }
    }
}
