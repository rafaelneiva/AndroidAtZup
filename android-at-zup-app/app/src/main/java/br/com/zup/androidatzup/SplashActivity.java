package br.com.zup.androidatzup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rafaelneiva on 07/08/18.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(new Intent(SplashActivity.this, MainActivity.class));
               SplashActivity.this.finish();
            }
        }, 2000);
    }
}
