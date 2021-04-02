package com.example.task_ovid.stats;

public class Resistencia {
    private static double resistencia;

    public static void init(){
        resistencia=1;
    }

    public static double getResistencia() {
        return resistencia;
    }

    public static void setResistencia(double resistencia) {
        Resistencia.resistencia = resistencia;
    }
}
