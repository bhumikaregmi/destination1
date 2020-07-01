package com.example.yourdestination.ui.destination;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourdestination.R;

public class DetailPageActivity extends AppCompatActivity {

    ImageView img;
    TextView txtDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        img = findViewById(R.id.imgView);
        txtDetail = findViewById(R.id.txtDesc);

        txtDetail.setText(getIntent().getExtras().getString("name"));
        img.setImageResource(getIntent().getExtras().getInt("img"));
    }
}
