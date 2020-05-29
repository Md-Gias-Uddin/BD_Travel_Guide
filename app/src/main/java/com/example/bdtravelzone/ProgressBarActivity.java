package com.example.bdtravelzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarActivity extends AppCompatActivity {

    private int progress;
    private ProgressBar progressBar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.progress_bar_activity);

    progressBar = (ProgressBar) findViewById(R.id.progressBarId);

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            doWork();

        }

    });
        thread.start();

}
    public void doWork(){

        for(progress=25;progress<=100;progress = progress+25){
            try {
                Thread.sleep(1000);//fill up howar jonno koto sec somoy nibe
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(ProgressBarActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
