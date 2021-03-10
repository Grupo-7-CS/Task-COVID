package com.example.task_ovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
/*
Esta clase se encarga de cargar la pantalla de inicio y de iniciar la aplicación cuando se pulsa el
botón de "START"
 */
public class StartActivity extends AppCompatActivity {

    private ImageButton stbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        stbut= (ImageButton) findViewById(R.id.button_start);
        stbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Startup();
            }
        });
    }

    // Método usado para que el botón "START" abra la pantalla de carga (Load Screen)
    public void Startup(){
        Intent intent = new Intent(this,LoadScreenActivity.class);
        startActivity(intent);
    }


}