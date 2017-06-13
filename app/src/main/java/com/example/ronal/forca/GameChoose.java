package com.example.ronal.forca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GameChoose extends AppCompatActivity
{
    Button btnFrog;
    Button btnDado;
    Button btnPong;
    Button btnAppDoSoares;
    Button btnVoltarParaForca;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_choose);
        btnFrog = (Button) findViewById(R.id.frogBtn);
        btnDado = (Button) findViewById(R.id.dadoBtn);
        btnPong = (Button) findViewById(R.id.pongBtn);
        btnVoltarParaForca = (Button) findViewById(R.id.backToForcaBtn);
        btnAppDoSoares = (Button) findViewById(R.id.appDoSoaresBtn);
        btnFrog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent("Frog");
                startActivity(i);
            }
        });
        btnDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent("Dado");
                startActivity(i);
            }
        });
        btnPong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("Pong");
                startActivity(i);
            }
        });
        btnAppDoSoares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("AplicativoDoSoares");
                startActivity(i);
            }
        });
        btnVoltarParaForca.setOnClickListener(new View.OnClickListener() {
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
