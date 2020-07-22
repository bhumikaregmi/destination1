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
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFormForUser extends AppCompatActivity{
    Toolbar toolbar;
    EditText mEmail, mPassword;
    Button mButton;
    TextView mCreate;
    FirebaseAuth mAuth;
    ProgressBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form_for_user);
        


        mEmail = findViewById(R.id.user_email_login);
        mPassword = findViewById(R.id.user_password_login);
        mButton = findViewById(R.id.login_button);
        mCreate = findViewById(R.id.navigate_to_login);
        mProgress = findViewById(R.id.bar);
        mAuth = FirebaseAuth.getInstance();


        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(LoginFormForUser.this, Addplaces.class));
            finish();
        }


        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Username is required.");
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
                      Toast.makeText(LoginFormForUser.this ,"Logged in Sucessfully.",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(LoginFormForUser.this, Addplaces.class));
                   }else {
                       Toast.makeText(LoginFormForUser.this ,"Error!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                       mProgress.setVisibility(View.GONE);
                   }
                  }
              });

                mCreate.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(LoginFormForUser.this, SignUpForm.class));
                    }
                });
            }

        });
    }
}
