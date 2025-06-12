/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.dia2;

/**
 *
 * @author utpl
 */
public class Ejercicio1 {
     

    static final int N = 1_000_000;

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        probarPilaEstatica(runtime);
        probarPilaDinamica(runtime);
        probarColaEstatica(runtime);
        probarColaDinamica(runtime);
    }

    static void probarPilaEstatica(Runtime runtime) {
        PilaEstatica pila = new PilaEstatica(N);
        System.gc();
        long startMem = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < N; i++) {
            pila.apilar(i);
        }
        for (int i = 0; i < N; i++) {
            pila.desapilar();
        }

        long endTime = System.nanoTime();
        long endMem = runtime.totalMemory() - runtime.freeMemory();
        imprimir("Pila estática", startTime, endTime, startMem, endMem);
    }

    static void probarPilaDinamica(Runtime runtime) {
        PilaDinamica pila = new PilaDinamica();
        System.gc();
        long startMem = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < N; i++) {
            pila.apilar(i);
        }
        for (int i = 0; i < N; i++) {
            pila.desapilar();
        }

        long endTime = System.nanoTime();
        long endMem = runtime.totalMemory() - runtime.freeMemory();
        imprimir("Pila dinámica", startTime, endTime, startMem, endMem);
    }

    static void probarColaEstatica(Runtime runtime) {
        ColaEstatica cola = new ColaEstatica(N);
        System.gc();
        long startMem = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < N; i++) {
            cola.encolar(i);
        }
        for (int i = 0; i < N; i++) {
            cola.desencolar();
        }

        long endTime = System.nanoTime();
        long endMem = runtime.totalMemory() - runtime.freeMemory();
        imprimir("Cola estática", startTime, endTime, startMem, endMem);
    }

    static void probarColaDinamica(Runtime runtime) {
        ColaDinamica cola = new ColaDinamica();
        System.gc();
        long startMem = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        for (int i = 0; i < N; i++) {
            cola.encolar(i);
        }
        for (int i = 0; i < N; i++) {
            cola.desencolar();
        }

        long endTime = System.nanoTime();
        long endMem = runtime.totalMemory() - runtime.freeMemory();
        imprimir("Cola dinámica", startTime, endTime, startMem, endMem);
    }

    static void imprimir(String nombre, long startTime, long endTime, long startMem, long endMem) {
        System.out.printf("%-15s | Tiempo: %6d ms | Memoria: %6.2f MB\n", nombre,
                (endTime - startTime) / 1_000_000,
                (endMem - startMem) / (1024.0 * 1024.0));
    }
}
