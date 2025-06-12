/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.dia2;

/**
 *
 * @author utpl
 */
public class PilaDinamica {
     private Nodo cima;

    private class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    public void apilar(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public int desapilar() {
        if (estaVacia()) return -1;

        int valor = cima.valor;
        cima = cima.siguiente;
        return valor;
    }

    public boolean estaVacia() {
        return cima == null;
    }
}
