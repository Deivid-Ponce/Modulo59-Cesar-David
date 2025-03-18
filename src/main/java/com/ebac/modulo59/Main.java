package com.ebac.modulo59;

public class Main {
    public static void main(String[] args) {
        Contexto contexto = new Contexto();

        System.out.println("\nObteniendo direcciones...");
        contexto.obtenerDirecciones();

        DireccionModel nuevaDireccion = new DireccionModel(0, 1, "Calle 123", "Guadalajara", "Jalisco", "12345");
        contexto.guardarDireccion(nuevaDireccion);
        System.out.println("\nDirección agregada.");

        System.out.println("\nObteniendo direcciones actualizadas...");
        contexto.obtenerDirecciones();
    }
}