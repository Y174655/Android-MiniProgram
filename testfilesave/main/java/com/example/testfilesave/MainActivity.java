package com.example.testfilesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private static final String fileName = "dataStored";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.button);
        this.editText = findViewById(R.id.editText);

        this.loadStr();
        this.button.setOnClickListener((View v) -> this.saveStr());
    }

    private void loadStr() {
        FileInputStream input;
        BufferedReader reader;
        try {
            input = openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(input));
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append(reader.readLine());
            }
            this.editText.setText(sb.toString());
            reader.close();
            Toast.makeText(this, "loaded text.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "error occurred while loading text", Toast.LENGTH_LONG).show();
        }
    }

    private void saveStr() {
        FileOutputStream output;
        BufferedWriter writer;
        try {
            output = openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(output));
            writer.write(this.editText.getText().toString());
            writer.close();
            Toast.makeText(this, "saved text", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this, "error occurred while saving text", Toast.LENGTH_LONG).show();
        }
    }
}
