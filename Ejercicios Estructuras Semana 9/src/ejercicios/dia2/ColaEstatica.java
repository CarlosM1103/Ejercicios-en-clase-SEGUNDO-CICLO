/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.dia2;

/**
 *
 * @author utpl
 */
public class ColaEstatica {
    private int[] elementos;
    private int frente, fin, tamaño, capacidad;

    public ColaEstatica(int capacidad) {
        this.capacidad = capacidad;
        elementos = new int[capacidad];
        frente = tamaño = 0;
        fin = capacidad - 1;
    }

    public void encolar(int valor) {
        if (!estaLlena()) {
            fin = (fin + 1) % capacidad;
            elementos[fin] = valor;
            tamaño++;
        }
    }

    public int desencolar() {
        if (estaVacia()) return -1;

        int valor = elementos[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        return valor;
    }

    public boolean estaLlena() {
        return tamaño == capacidad;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }
}
