package com.example.abhinav.htdfirstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnOk, btnCancel;
    EditText edt_firstName, edt_secondName, edt_email, edt_phNo, edt_address;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void showMessage(View v) {
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        edt_firstName = (EditText) findViewById(R.id.edt_firstName);
        edt_secondName = (EditText) findViewById(R.id.edt_secondName);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_phNo = (EditText) findViewById(R.id.edt_phNo);
        edt_address = (EditText) findViewById(R.id.edt_address);
        String secondName = edt_secondName.getText().toString();
        String firstName = edt_firstName.getText().toString();
        String email = edt_email.getText().toString();
        String phNo = edt_phNo.getText().toString();
        String address = edt_address.getText().toString();

        if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(secondName) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(phNo) && !TextUtils.isEmpty(address)){

            Intent infoIntent = new Intent(MainActivity.this,FormActivity.class);
            infoIntent.putExtra("firstName",firstName);
            infoIntent.putExtra("secondName",secondName);
            infoIntent.putExtra("email",email);
            infoIntent.putExtra("phNo",phNo);
            infoIntent.putExtra("address",address);


            startActivity(infoIntent);

        }else{
            Toast.makeText(MainActivity.this, "Please Provide All Information", Toast.LENGTH_SHORT).show();
        }

    }

    public void resetMessage(View v) {
        Toast.makeText(this, "Clicked on Cancel Button", Toast.LENGTH_LONG).show();
    }
}
