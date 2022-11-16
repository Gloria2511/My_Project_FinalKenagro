package com.gloria.myprojectfinalkenagro.Activity.Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gloria.myprojectfinalkenagro.Activity.ShowDetailActivity;
import com.gloria.myprojectfinalkenagro.R;

import java.util.ArrayList;

import Domain.FoodDomain;


public class PopularAdaptor extends RecyclerView.Adapter<PopularAdaptor.ViewHolder>{
    private final ArrayList<FoodDomain> popularFood;



    public PopularAdaptor(ArrayList<FoodDomain> popularFood) {
        this.popularFood = popularFood;
    }

    ArrayList<FoodDomain>categoryDomains;


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ArrayList<ImageView> images = new ArrayList();

        images.add(holder.pic);

        holder.title.setText(categoryDomains.get(position).getTitle());
holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));
images.get(position).setImageResource(R.drawable.pop_1);


holder.mainPopLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.pop_1));

int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier("pop_1","drawable",holder.itemView.getContext().getPackageName());

//       int drawableResourceId =  holder.pic.setImageResource(R.drawable.pop_1);

  Glide.with(holder.itemView.getContext())
                .load(R.drawable.pop_1)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object",popularFood.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        return categoryDomains.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
      TextView title, fee;
      ImageView pic;
      TextView addBtn;
      ConstraintLayout mainPopLayout;



        public ViewHolder(@NonNull View itemView) {
          super(itemView);
         title=itemView.findViewById(R.id.title);
         fee=itemView.findViewById(R.id.feeTxt);
         pic=itemView.findViewById(R.id.pic);
         addBtn=itemView.findViewById(R.id.addBtn);
         mainPopLayout = itemView.findViewById(R.id.popularMainlayout);


        }

    }
}

