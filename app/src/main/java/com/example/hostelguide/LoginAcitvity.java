package com.example.hostelguide;

// LOGIN ACTIVITY JAVA FILE


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.hostelguide.Util.CurrentUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAcitvity extends AppCompatActivity {
    private long backPressTime;
    EditText edtEmail,editPassword;
    Button login, gotosignup;
    FirebaseAuth fAuth;

    EditText namer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitvity);

        edtEmail = (EditText)findViewById(R.id.Email);
        editPassword = (EditText)findViewById(R.id.Password);
        login = (Button)findViewById(R.id.button);
        gotosignup = (Button)findViewById(R.id.button2);
        fAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String password = editPassword.getText().toString().trim();
            final String email = edtEmail.getText().toString().trim();

            if(TextUtils.isEmpty(email)) {
                edtEmail.setError("Email is required");
                return;
            }
            if(TextUtils.isEmpty(password)) {
                editPassword.setError("Phone is required");
                return;
            }
            if(password.length()<5) {
                editPassword.setError("Password must be >5 characters");
                return;
            }

            //authenticate the user

            fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        CurrentUser cuser = new CurrentUser(email);
                        Toast.makeText(LoginAcitvity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginAcitvity.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
        });

        // Sign Up
        gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),signup.class));
            }
        });
    }

    //LOGIN METHOD
    /*
    public void doLogin(View view){
        User user = null;
        user = Reader.getUserList(getApplicationContext());
        namer = findViewById(R.id.username);
        String name = namer.getText().toString();
        if(user.getUsers().contains(name))
        {
            CurrentUser cuser = new CurrentUser(name);
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(),"Sorry",Toast.LENGTH_LONG).show();
    }
    */

    @Override
    public void onBackPressed() {
        if (backPressTime+2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        } else{
            Toast.makeText(this, "Press Back again to Exit", Toast.LENGTH_SHORT).show();
        }

        backPressTime = System.currentTimeMillis();
        //finish();
        //android.os.Process.killProcess(android.os.Process.myPid());
        //System.exit(1);
    }
}
