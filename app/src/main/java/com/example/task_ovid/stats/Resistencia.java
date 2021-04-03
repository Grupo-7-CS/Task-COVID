package com.example.task_ovid.stats;

public class Resistencia {
    private static double resistenciaActual;

    private Resistencia(){
        throw new IllegalStateException("Utility class");
    }

    public static void init(){
        resistenciaActual =1;
    }

    public static double getResistenciaActual() {
        return resistenciaActual;
    }

    public static void setResistenciaActual(double resistenciaActual) {
        Resistencia.resistenciaActual = resistenciaActual;
    }
}
