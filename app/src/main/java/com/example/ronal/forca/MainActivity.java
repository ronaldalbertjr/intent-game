package com.example.ronal.forca;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    Button goToGameChoose;
    Intent frogActivity = new Intent("Frog");
    public static final String PREFS_NAME = "MyPrefsFile";

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
        goToGameChoose = (Button) findViewById(R.id.chooseGameBtn);

        M.setVisibility(recuperar("Jogo1")?View.VISIBLE:View.INVISIBLE);
        O.setVisibility(recuperar("Jogo2")?View.VISIBLE:View.INVISIBLE);
        T.setVisibility(recuperar("Jogo3")?View.VISIBLE:View.INVISIBLE);
        U.setVisibility(recuperar("Jogo4")?View.VISIBLE:View.INVISIBLE);
        M2.setVisibility(recuperar("Jogo5")?View.VISIBLE:View.INVISIBLE);
        B.setVisibility(recuperar("Jogo6")?View.VISIBLE:View.INVISIBLE);
        O2.setVisibility(recuperar("Jogo7")?View.VISIBLE:View.INVISIBLE);

        goToGameChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartActivity(GameChoose.class);
            }
        });

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

    void StartActivity(Class activity)
    {
        Intent i = new Intent(this, activity);
        startActivity(i);
    }
    private void armazenar(String key,boolean value)
    {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);

        // Commit as edições
        editor.apply();
    }
    private boolean recuperar(String key){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        return settings.getBoolean(key, false);
    }
    private void SendMotumboNotification()
    {
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this).setSmallIcon(R.mipmap.half_motumbo).setContentTitle("Você encontrou todas as letras").setContentText("Cuidado com o motumbo").setAutoCancel(true);
        PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, MotumboActivity.class), 0);
        mBuilder.setContentIntent(pi);
        mBuilder.setVibrate(new long[] {100, 250, 100, 500});
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(R.string.app_name, mBuilder.build());
    }
    protected void GenerateLetters(String bundleMsg)
    {
        switch(bundleMsg)
        {
            case "Jogo1":
                M.setVisibility(View.VISIBLE);
                armazenar("Jogo1",true);
                Toast.makeText(this,"Ainda restam 2 letras para serem encontradas no FROG",Toast.LENGTH_LONG).show();
                startActivity(frogActivity);
                break;
            case "Jogo2":
                O.setVisibility(View.VISIBLE);
                armazenar("Jogo2",true);
                Toast.makeText(this,"Você encontrou a letra O no Aplicativo do Lucas",Toast.LENGTH_LONG).show();
                break;
            case "Jogo3":
                T.setVisibility(View.VISIBLE);
                armazenar("Jogo3",true);
                Toast.makeText(this,"Você encontrou a letra T no Dado",Toast.LENGTH_LONG).show();
                break;
            case "Jogo4":
                U.setVisibility(View.VISIBLE);
                armazenar("Jogo4",true);
                Toast.makeText(this,"Você encontrou a letra U no Pong",Toast.LENGTH_LONG).show();
                break;
            case "Jogo5":
                M.setVisibility(View.VISIBLE);
                armazenar("Jogo5",true);
                break;
            case "Jogo6":
                B.setVisibility(View.VISIBLE);
                armazenar("Jogo6",true);
                Toast.makeText(this,"Ainda resta 1 letra para ser encontrada no FROG",Toast.LENGTH_LONG).show();
                startActivity(frogActivity);
                break;
            case "Jogo7":
                O.setVisibility(View.VISIBLE);
                armazenar("Jogo7",true);
                Toast.makeText(this,"VOCE OBTEVE TODAS AS LETRAS DO FROG PARABENS, Encontre o resto das letras em outros jogos",Toast.LENGTH_LONG).show();
                break;
        }
        if(recuperar("Jogo1") && recuperar("Jogo2") && recuperar("Jogo3") && recuperar("Jogo4") && recuperar("Jogo5") && recuperar("Jogo6") && recuperar("Jogo7"))
        {
            SendMotumboNotification();
        }
    }
}