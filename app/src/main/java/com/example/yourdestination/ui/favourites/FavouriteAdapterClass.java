package com.example.yourdestination.ui.favourites;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yourdestination.R;
import com.example.yourdestination.ui.destination.DestinationModel;
import com.example.yourdestination.ui.destination.DetailPageActivity;

import java.util.List;

public class FavouriteAdapterClass extends RecyclerView.Adapter<FavouriteAdapterClass.MyViewHolder> {

    Context context;
    List<DestinationModel> destinationModelClassList;

    public FavouriteAdapterClass(Context context, List<DestinationModel> destinationModelClassList) {
        this.context = context;
        this.destinationModelClassList = destinationModelClassList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final DestinationModel destinationModelClass = destinationModelClassList.get(position);

        holder.txtVew.setText(position+1+". "+destinationModelClass.getName());
        holder.img.setImageResource(destinationModelClass.getImage());
        holder.heartImg.setVisibility(View.VISIBLE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context,DetailPageActivity.class);
                i.putExtra("name",destinationModelClass.getName());
                i.putExtra("img",destinationModelClass.getImage());
                context.startActivity(i);

//                Toast.makeText(context, "Selected : "+destinationModelClass.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return destinationModelClassList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtVew;
        ImageView img,heartImg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVew = itemView.findViewById(R.id.txtName);
            img = itemView.findViewById(R.id.img);
            heartImg = itemView.findViewById(R.id.heartImg);
        }
    }

}
