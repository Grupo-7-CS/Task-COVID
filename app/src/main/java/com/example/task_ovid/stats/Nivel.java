package com.example.task_ovid.stats;

import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task_ovid.MainActivity;

public class Nivel {
    private static int maxExperiencia;
    private static int experiencia;
    private static int nivel;
    private static MainActivity main;

    public static void init(MainActivity main){
        maxExperiencia=100;
        experiencia=0;
        nivel=1;
        Nivel.main=main;
    }

    //Acción que se ejecuta cuando se realiza una buena acción
    public static boolean incrementarExperiencia(boolean isPCR){
        ProgressBar be = main.getBarraExperiencia();
        be.setMax(maxExperiencia);
        if(isPCR){
            experiencia += 50;
        }else{
            experiencia += 10;
        }
        boolean subidaNivel = subirNivel();
        be.setProgress(experiencia,true);
        return subidaNivel;
    }

    //Cuando sube de nivel el usuario se establece la barra de nivel y las monedas
    public static boolean subirNivel(){
        if (experiencia>=maxExperiencia){
            int extra = experiencia-maxExperiencia;
            nivel ++;
            experiencia = extra;
            maxExperiencia += 20;
            ProgressBar be = main.getBarraExperiencia();
            be.setMax(maxExperiencia);
            TextView nivelTexto = main.getVistaNivel();
            nivelTexto.setText("NIVEL "+nivel);
            Toast.makeText(main.getApplicationContext(), "Has subido de nivel. Enhorabuena", Toast.LENGTH_LONG).show();
            Toast.makeText(main.getApplicationContext(), "Has ganado 100 monedas", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

}
