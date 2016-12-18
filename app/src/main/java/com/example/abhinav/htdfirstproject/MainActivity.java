package com.example.abhinav.htdfirstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Button button = (Button) findViewById(R.id.btnOk);
        button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {


            }
        });


    }
}
