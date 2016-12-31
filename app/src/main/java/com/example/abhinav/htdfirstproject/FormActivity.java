package com.example.abhinav.htdfirstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    TextView txt_firstName, txt_secondName, txt_email, txt_phNo, txt_address;
    Button btnLogout;
    SharedPreferenceManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        txt_firstName = (TextView) findViewById(R.id.txt_firstName);
        txt_secondName = (TextView) findViewById(R.id.txt_secondName);
        txt_email = (TextView) findViewById(R.id.txt_email);
        txt_phNo = (TextView) findViewById(R.id.txt_phNo);
        txt_address = (TextView) findViewById(R.id.txt_address);

        Bundle bundle = getIntent().getExtras();

        txt_firstName.setText(bundle.getString("firstName"));

        txt_secondName.setText(bundle.getString("secondName"));
        txt_email.setText(bundle.getString("email"));
        txt_phNo.setText(bundle.getString("phNo"));
        txt_address.setText(bundle.getString("address"));

        btnLogout =(Button)findViewById(R.id.btnLogout);

        session =new SharedPreferenceManager(getApplicationContext());

        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                session.logoutUser();
            }
        });


    }
}
