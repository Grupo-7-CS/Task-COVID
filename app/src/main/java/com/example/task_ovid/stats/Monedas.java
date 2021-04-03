package com.example.task_ovid.stats;

import android.widget.TextView;
import com.example.task_ovid.MainActivity;

public class Monedas {
    private static int monedasUsuario;
    private static MainActivity main;

    private Monedas(){
        throw new IllegalStateException("Utility class");
    }

    public static void init(MainActivity main){
        Monedas.main=main;
    }

    //Incrementa las monedas, se usa al subir de nivel
    public static void incrementarMonedas(int cantidad){
        TextView monedas = main.getVistaMonedas();
        monedasUsuario+=cantidad;
        monedas.setText(""+ monedasUsuario);
    }

    public static void setMonedasUsuario(int m) {
        TextView monedas = main.getVistaMonedas();
        if(m < 0)
            monedasUsuario=0;
        else
            monedasUsuario = m;
        monedas.setText(""+ monedasUsuario);
    }

    public static int getMonedasUsuario() {
        return monedasUsuario;
    }
}
