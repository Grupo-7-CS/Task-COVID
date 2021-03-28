package com.example.task_ovid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
/*
Esta clase se encarga de mostrar una pantalla con una barra de carga
 */
public class LoadScreenActivity extends AppCompatActivity {

    ProgressBar pb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);

        pb=(ProgressBar)findViewById(R.id.progress_bar);
        tv=(TextView) findViewById(R.id.text_view);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        pb.setMax(100);
        pb.setScaleY(3f);

        progressAnimation();
    }

    //Método usado para crear un objeto de la clase encargada de realizar la animación de la barra
    //de progreso, establecer los parámetros para configurar esta animación e iniciarla
    public void progressAnimation(){
        PBAnimation anim= new PBAnimation(this, pb, tv, 0f, 100f);
        anim.setDuration(8000);
        pb.setAnimation(anim);
    }

}