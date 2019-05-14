package com.example.masto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set UI
        final EditText userText = (EditText) findViewById(R.id.userNameText);
        final EditText domainText = (EditText) findViewById(R.id.domainNameText);
        final EditText pwdText = (EditText) findViewById(R.id.pwdEditText);
        Button userLogin = (Button) findViewById(R.id.userLogInButton);
        Button insLogin = (Button) findViewById(R.id.instanceButton);

        insLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insName = domainText.getText().toString();
                if (insName == null || insName == "") {
                    Toast.makeText(MainActivity.this, "Please enter an instance.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), ContentActivity.class);
                    intent.putExtra("InsName", insName);
                    startActivity(intent);
                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String insName = domainText.getText().toString();
                if (insName == null || insName == "") {
                    Toast.makeText(MainActivity.this, "Please enter an instance.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), TimelineActivity.class);
                    intent.putExtra("InsName", insName);
                    startActivity(intent);
                }
            }
        });

    }

}