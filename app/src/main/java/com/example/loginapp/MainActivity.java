package com.example.loginapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginButton;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        errorMessage = findViewById(R.id.error_message);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndLogin();
            }
        });
    }

    private void validateAndLogin() {
        String usernameInput = username.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();

        if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
            errorMessage.setText("Username and Password cannot be empty.");
            errorMessage.setVisibility(View.VISIBLE);
        } else {
            errorMessage.setVisibility(View.GONE);
            Intent intent = new Intent(MainActivity.this, Welcome.class);
            startActivity(intent);
        }
    }
}
