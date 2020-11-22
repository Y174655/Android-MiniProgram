package com.example.testdialog;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPrompt = findViewById(R.id.buttonOfPrompt);
        buttonPrompt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("this is a normal dialog");
                builder.setTitle("Dialog");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface d, int which) {
                        Toast.makeText(MainActivity.this,
                                "you pressed OK", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", (DialogInterface d, int which) -> {
                    Toast.makeText(MainActivity.this,
                            "you pressed Cancel", Toast.LENGTH_SHORT).show();
                });

                builder.setNeutralButton("Ignore", (DialogInterface d, int which) -> {
                    Toast.makeText(MainActivity.this,
                            "you pressed Ignore", Toast.LENGTH_SHORT).show();
                });

                builder.show();

            }
        });



        Button buttonLogin = findViewById(R.id.buttonOfLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View layoutView = inflater.inflate(R.layout.login_dialog, null);
                builder.setView(layoutView);
                builder.setTitle("Login");
                builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText username = layoutView.findViewById(R.id.edittext_username);
                        EditText password = layoutView.findViewById(R.id.edittext_password);

                        if (username.getText().toString().equals("abc") &&
                                password.getText().toString().equals("123")) {
                            Toast.makeText(MainActivity.this,
                                    "login success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "username or password error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // to nothing
                    }
                });

                builder.show();
            }
        });

    }
}
