package com.example.myapplicationnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewsDetails extends AppCompatActivity {

    ImageView articleimage;
    TextView articletitel,maintext;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


        articleimage = findViewById(R.id.articleimage);
        articletitel = findViewById(R.id.articletitel);
        maintext = findViewById(R.id.maintext);

     //   Toast.makeText(this, "In", Toast.LENGTH_SHORT).show();

   /*     images = Integer.parseInt(getIntent().getStringExtra("image"));*/

        articleimage.setImageDrawable(ContextCompat.getDrawable(this,getIntent().getIntExtra("image",0)));
        articletitel.setText(getIntent().getStringExtra("title"));
        maintext.setText(getIntent().getStringExtra("maintext"));


    }
}
