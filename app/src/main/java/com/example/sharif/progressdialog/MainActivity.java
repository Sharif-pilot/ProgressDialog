package com.example.sharif.progressdialog;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setIndeterminate(false);
        dialog.setTitle("Progress Dialog");
        dialog.setMessage("Please wait...");

        dialog.setProgress(i);
        dialog.setMax(100);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                i = i + 5;
                dialog.setProgress(i);
                if(i <= 100){
                    dialog.setProgress(i);
                }else {
                    dialog.cancel();
                    i = 0;
                }
            }
        };

        timer    = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 0,500);
    }

    public void showDialog(View view) {
        dialog.show();
    }
}
