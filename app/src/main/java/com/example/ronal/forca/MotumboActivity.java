package com.example.ronal.forca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MotumboActivity extends AppCompatActivity
{
    Button backToForca;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motubo);
        backToForca = (Button) findViewById(R.id.voltarParaAForcaBtn);


        backToForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartActivity(MainActivity.class);
            }
        });
    }

    void StartActivity(Class activity)
    {
        Intent i = new Intent(this, activity);
        startActivity(i);
    }
}
