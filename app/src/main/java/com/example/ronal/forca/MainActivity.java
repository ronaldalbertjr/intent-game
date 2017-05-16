package com.example.ronal.forca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    TextView M;
    TextView O;
    TextView T;
    TextView U;
    TextView M2;
    TextView B;
    TextView O2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        M = (TextView) findViewById(R.id.M);
        O = (TextView) findViewById(R.id.O);
        T = (TextView) findViewById(R.id.T);
        U = (TextView) findViewById(R.id.U);
        M2 = (TextView) findViewById(R.id.M2);
        B = (TextView) findViewById(R.id.B);
        O2 = (TextView) findViewById(R.id.O2);

        Intent i = getIntent();

        if(i != null)
        {
            Bundle params = i.getExtras();
            if(params != null)
            {
                String gameType = params.getString("game");
                GenerateLetters(gameType);
            }
        }
    }


    protected void GenerateLetters(String bundleMsg)
    {
        switch(bundleMsg)
        {
            case "Jogo1":
                M.setVisibility(View.VISIBLE);
                break;
            case "Jogo2":
                O.setVisibility(View.VISIBLE);
                break;
            case "Jogo3":
                T.setVisibility(View.VISIBLE);
                break;
            case "Jogo4":
                U.setVisibility(View.VISIBLE);
                break;
            case "Jogo5":
                M.setVisibility(View.VISIBLE);
                break;
            case "Jogo6":
                B.setVisibility(View.VISIBLE);
                break;
            case "Jogo7":
                O.setVisibility(View.VISIBLE);
                break;
        }
    }
}
