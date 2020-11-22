package com.example.testhandler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class CustomHandler extends Handler {

    private MainActivity main;

    public CustomHandler(MainActivity main) {
        super();
        this.main = main;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        if (msg.what == 1) {
            main.showToast();
        }
    }
}
