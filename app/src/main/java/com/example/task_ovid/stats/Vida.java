package com.example.task_ovid.stats;

import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.task_ovid.MainActivity;

public class Vida {

    private static final int MAX_VIDA = 100;
    private static int vidaActual;
    private static MainActivity main;

    private Vida() {
        throw new IllegalStateException("Utility class");
    }

    public static void init(MainActivity main) {
        vidaActual = 100;
        Vida.main = main;
    }

    public static void decrementarVida() {
        int restaAux = (int) (25 * Resistencia.getResistenciaActual());
        int vidaAux = vidaActual - restaAux;
        setVidaActual(vidaAux);
        if (main != null && vidaAux <= 0) {
            Toast.makeText(main.getApplicationContext(), "Con estos habitos te vas a contagiar ;(", Toast.LENGTH_LONG).show();
        }
    }

    //Establece la vida del jugador al salir de la tienda
    public static void setVidaActual(int v) {
        //Si el usuario no tiene vida (ha perdido) o el valor de v es negativo la vida debe ser 0
        if (vidaActual >= 0 && v >= 0) {
            vidaActual = v;
        } else {
            vidaActual = 0;
        }
        //Protege de errores en caso de que main sea null
        if (main != null) {
            ProgressBar bv = main.getBarraVida();
            bv.setMax(MAX_VIDA);
            bv.setProgress(vidaActual, true);
        }
    }

    public static int getVidaActual() {
        return vidaActual;
    }

    public static int getMaxVida() {
        return MAX_VIDA;
    }

}
