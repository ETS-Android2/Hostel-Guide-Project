package com.example.hostelguide;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.*;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;

public class SendOTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_o_t_p);

        final EditText inputMobile = findViewById(R.id.inputMobile);
        Button buttonGetOTP = findViewById(R.id.buttonGetOTP);

                buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(SendOTPActivity.this, "Enter Mobile", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    HttpResponse response = (HttpResponse) Unirest.get("https://www.fast2sms.com/dev/bulkV2?authorization=R0ylDZ6t2cXqkrKuxT8LwA91gJ74m3B5fsSiNUVehHoGpaWYdn2uUEJdiX9TgPC8rth60y7ZsvVRA4mq&variables_values=559966&route=otp&numbers="+inputMobile.getText().toString())
                            .header("cache-control", "no-cache")
                            .asString();
                } catch (UnirestException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(getApplicationContext(), VerifyOTPActivity.class);
                intent.putExtra("mobile", inputMobile.getText().toString());
                intent.putExtra("otpnumber",559966);
                startActivity(intent);
            }
        });
    }
}