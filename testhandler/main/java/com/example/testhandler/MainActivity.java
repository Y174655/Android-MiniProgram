package com.example.testhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CustomHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.handler = new CustomHandler(this);

        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(3000);

                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    void showToast() {
        Toast.makeText(this, "received message from another thread.", Toast.LENGTH_SHORT).show();
    }
}
