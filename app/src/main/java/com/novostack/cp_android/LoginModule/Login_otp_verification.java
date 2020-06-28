package com.novostack.cp_android.LoginModule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.novostack.cp_android.R;

public class Login_otp_verification extends AppCompatActivity {
    private Button mNextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_otp_verification);
        mNextButton = findViewById(R.id.button_next);
        mNextButton.setBackgroundResource(R.drawable.shape_button);
    }
}
