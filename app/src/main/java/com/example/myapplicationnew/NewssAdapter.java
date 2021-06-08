package com.example.myapplicationnew;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class NewssAdapter extends BaseAdapter {

    Activity context;
    ArrayList<NewsModel> newsModels;
    private static LayoutInflater inflater = null;
    MyDatabaseSource source;
    ArrayList<NewsModel> arrayList;

    public NewssAdapter(Activity context, ArrayList<NewsModel> newsModels) {
        this.context = context;
        this.newsModels = newsModels;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return newsModels.size();
    }

    @Override
    public Object getItem(int position) {
        return newsModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView==null)?inflater.inflate(R.layout.cell_news_recycler,null):itemView;

        TextView titeltoview =itemView.findViewById(R.id.titeltoview);
        ImageView imageView = itemView.findViewById(R.id.image);
        RelativeLayout re_layout = itemView.findViewById(R.id.re_layout);



        final NewsModel newsModel = newsModels.get(position);

        //   final SendOfflineModel.DataHolder dataHolder = new SendOfflineAdapter.DataHolder();

        imageView.setImageDrawable(ContextCompat.getDrawable(context, newsModel.getImage()));
        titeltoview.setText(newsModel.getTitle());
        re_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "Position: "+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,NewsDetails.class);
                intent.putExtra("image",newsModel.getImage());
                intent.putExtra("title",newsModel.getTitle());
                intent.putExtra("maintext",newsModel.getText());
                context.startActivity(intent);
            }
        });

        return itemView;
    }


    public void filterlist(ArrayList<NewsModel> filteredList) {
        newsModels = filteredList;
        notifyDataSetChanged();
    }
}
