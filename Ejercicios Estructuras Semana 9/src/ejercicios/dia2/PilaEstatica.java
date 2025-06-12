/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.dia2;

/**
 *
 * @author utpl
 */
public class PilaEstatica {

    private int[] elementos;
    private int cima;

    public PilaEstatica(int capacidad) {
        elementos = new int[capacidad];
        cima = -1;
    }

    public void apilar(int valor) {
        if (!estaLlena()) {
            elementos[++cima] = valor;
        }
    }

    public int desapilar() {
        if (!estaVacia()) {
            return elementos[cima--];
        }
        return -1; // Valor de error
    }

    public boolean estaVacia() {
        return cima == -1;
    }

    public boolean estaLlena() {
        return cima == elementos.length - 1;
    }
}
