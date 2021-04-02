package com.example.task_ovid.stats;

import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.task_ovid.MainActivity;

public class Vida {

    private static final int maxVida=100;
    private static int vida;
    private static MainActivity main;

    public static void init(MainActivity main){
        vida=100;
        Vida.main=main;
    }

    public static void decrementarVida(){
        int restaAux = (int)(25 * Resistencia.getResistencia());
        int vidaAux = vida - restaAux;
        setVida(vidaAux);
        if (vidaAux<=0){
            Toast.makeText(main.getApplicationContext(), "Con estos habitos te vas a contagiar ;(", Toast.LENGTH_LONG).show();
        }
    }

    //Establece la vida del jugador al salir de la tienda
    public static void setVida(int v) {
        if (vida>=0) {
            vida = v;
        }else{
            vida = 0;
        }
        ProgressBar bv =main.getBarraVida();
        bv.setMax(maxVida);
        bv.setProgress(vida,true);
    }

    public static int getVida(){
        return vida;
    }

    public static int getMaxVida() {
        return maxVida;
    }

}
