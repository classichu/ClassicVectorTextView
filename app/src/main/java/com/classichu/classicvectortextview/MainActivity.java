package com.classichu.classicvectortextview;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.classichu.vectortextview.ClassicVectorTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView) findViewById(R.id.id_iv);
        imageView.setColorFilter(ContextCompat.getColor(this,R.color.colorPrimary));

        ClassicVectorTextView classicVectorTextView= (ClassicVectorTextView) findViewById(R.id.id_cvtv);
        classicVectorTextView.setColorFilterLikeImage(ContextCompat.getColor(this,R.color.colorPrimary));
    }
}
