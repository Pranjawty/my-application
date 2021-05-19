package com.example.myapplicationnew;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<NewsModel> arrayList;
   // private final View.OnClickListener mOnClickListener = new MyOnClickListener();

    public NewsAdapter(Context context, ArrayList<NewsModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View v=layoutInflater.inflate(R.layout.cell_news_recycler,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        Log.d("check",arrayList.get(position).getTitle());

        holder.titeltoview.setText(arrayList.get(position).getTitle());
        holder.image.setImageDrawable(ContextCompat.getDrawable(context, arrayList.get(position).getImage()));
        holder.re_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titeltoview,tvName;
        ImageView image;
        RelativeLayout re_layout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            titeltoview=itemView.findViewById(R.id.titeltoview);
            re_layout=itemView.findViewById(R.id.re_layout);
            /* tvPrice=itemView.findViewById(R.id.tvprice);*/
//            foodimage=itemView.findViewById(R.id.image1);
        }
    }

    public interface onNewsListener{
      void onNewsClick(int position);
    }
}
