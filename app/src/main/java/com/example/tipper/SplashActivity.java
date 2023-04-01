package com.example.tipper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        // Tworzy obiekt Handler, który opóźnia uruchomienie nowej aktywności
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Uruchom nową aktywność po zakończeniu czasu opóźnienia
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

                // Zamknij obecną aktywność
                finish();
            }
        }, 3000);
    }
}