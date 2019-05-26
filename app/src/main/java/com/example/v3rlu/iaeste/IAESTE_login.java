package com.example.v3rlu.iaeste;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IAESTE_login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText password , Email ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iaeste_login);
        setTheme(R.style.FullScreen);
        mAuth = FirebaseAuth.getInstance();
        password =(EditText) findViewById(R.id.editText2) ;
        Email=(EditText) findViewById(R.id.editText) ;
        Button Connect=(Button)findViewById(R.id.button) ;



    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser!=null){
            Intent i = new Intent(IAESTE_login.this,Welcom.class);
            startActivity(i);
        }
    }



    public void onconnect(View v) {
        String emails=Email.getText().toString() ;
        String passwords = password.getText().toString() ;
        mAuth.signInWithEmailAndPassword(emails,passwords).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser() ;
                    Log.d("user",String.valueOf(user)) ;
                    Toast.makeText(IAESTE_login.this, "Authentication done."+user.getEmail() ,
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(IAESTE_login.this,Welcom.class);
                    startActivity(i);
                }
                else {

                    Toast.makeText(IAESTE_login.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }

            }
        }) ;
    }





}
