package com.example.exam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AuthUser currentUser = Amplify.Auth.getCurrentUser();

        if(currentUser == null){

        }else{

        }
        setContentView(R.layout.activity_main);
    }
}