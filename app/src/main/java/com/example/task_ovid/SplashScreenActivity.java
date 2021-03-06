package com.example.task_ovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
/*
Esta clase se encarga de cargar la primera pantalla que se ve al iniciar la app, el logo del equipo
desarrollador, y de iniciar la Start Activity a los 3 segundos.
 */
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Convertir a pantalla completa

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread thread=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);//abre la StartActivity tras 3 segundos
                    startActivity(new Intent(getApplicationContext(),StartActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        thread.start();
    }
}