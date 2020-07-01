package com.example.yourdestination;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ExploreMoreFloat extends AppCompatActivity {
FloatingActionButton floatingActionButton;
    Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_more_float);

        FloatingActionButton floatingActionButton = findViewById(R.id.flot_btn);

//        toolbar = findViewById(R.id.tool);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExploreMoreFloat.this,"Go",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ExploreMoreFloat.this, LoginFormForUser.class));

            }
        });
    }

    private void setSupportActionBar(Toolbar tool) {
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
               // return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
