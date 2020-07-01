package com.example.yourdestination;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginFormForUser extends AppCompatActivity{
    Button login_button;
    TextView navigateToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form_for_user);

        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginFormForUser.this, Addplaces.class));
            }
        });
    }
}
