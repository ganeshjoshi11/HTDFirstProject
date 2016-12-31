package com.example.abhinav.htdfirstproject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    // Email, password edittext
    EditText txtUsername, txtPassword;

    // login button
    Button btnLogin;
    // Session Manager Class
    SharedPreferenceManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Session Manager
        session = new SharedPreferenceManager(LoginActivity.this);

        // Email, Password input text
        txtUsername = (EditText) findViewById(R.id.txt_userName);
        txtPassword = (EditText) findViewById(R.id.txt_password);

        Toast.makeText(LoginActivity.this, "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        // Login button
        btnLogin = (Button) findViewById(R.id.btnLogin);

        // Login button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Get username, password from EditText
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                // Check if username, password is filled
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    // For testing purpose username, password is checked with sample data
                    // username = test
                    // password = test
                    if (username.equals("test") && password.equals("test")) {

//                        Bundle loginBundle= getIntent().getExtras();
//                        String firstName = loginBundle.getString("firstName");
//                        String secondName = loginBundle.getString("secondName");
//                        String email = loginBundle.getString("email");
//                        String phNo = loginBundle.getString("phNo");
//                        String address = loginBundle.getString("address");
                        session.createLoginSession("Abhinav","Joshi","abhinavjoshi11@gmail.com","9840017477","Kathmandu");

                        // Starting MainActivity
                        Intent startMainActivity = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(startMainActivity);
                        finish();
                    } else {
                        // username / password doesn't match
                        Toast.makeText(LoginActivity.this,  "Username/Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
                    Toast.makeText(LoginActivity.this, "Please enter Username And Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
