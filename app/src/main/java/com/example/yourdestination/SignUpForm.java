package com.example.yourdestination;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpForm extends AppCompatActivity {
    EditText mName , mEmail, mPassword;
    Button mLogin;
    TextView  mSignButton;
    FirebaseAuth mAuth;
    ProgressBar mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        mLogin = findViewById(R.id.signUpBtn);
        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mSignButton = findViewById(R.id.loginBtn);
        mProgress = findViewById(R.id.bar2);

        mAuth = FirebaseAuth.getInstance();

        mLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                        if(TextUtils.isEmpty(email)){
                            mEmail.setError("Email is required.");
                            return;
                        }

                        if(TextUtils.isEmpty(password)){
                            mPassword.setError("Password is required.");
                            return;
                        }
                        if (password.length()<6){
                            mPassword.setError("Password must be >=6 Characters.");
                            return;
                        }
                        mProgress.setVisibility(View.VISIBLE);

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener
                        (new OnCompleteListener<AuthResult>(){
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(SignUpForm.this ,"User created",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignUpForm.this, Addplaces.class));
                                }else {
                                    Toast.makeText(SignUpForm.this ,"Error!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    mProgress.setVisibility(View.GONE);
                                }
                            }

                        });
                mSignButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(SignUpForm.this, LoginFormForUser.class));
                    }
                });
            }

        });

    }
}


