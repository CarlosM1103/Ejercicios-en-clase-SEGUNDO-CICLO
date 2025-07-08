/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.estructuras.semana.pkg14;

/**
 *
 * @author utpl
 */
import java.util.LinkedList;
import java.util.Queue;

class NodoAVL {
    int valor;
    int altura;
    NodoAVL izquierdo, derecho;

    NodoAVL(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}

public class ArbolAVL {

    int altura(NodoAVL nodo) {
        if (nodo == null) return 0;
        return nodo.altura;
    }

    int obtenerBalance(NodoAVL nodo) {
        if (nodo == null) return 0;
        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    NodoAVL insertar(NodoAVL nodo, int valor) {
        if (nodo == null) return new NodoAVL(valor);

        if (valor < nodo.valor)
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = insertar(nodo.derecho, valor);
        else
            return nodo; // no duplicados

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        int balance = obtenerBalance(nodo);

        if (balance > 1 && valor < nodo.izquierdo.valor)
            return rotarDerecha(nodo);

        if (balance < -1 && valor > nodo.derecho.valor)
            return rotarIzquierda(nodo);

        if (balance > 1 && valor > nodo.izquierdo.valor) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && valor < nodo.derecho.valor) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    void inOrden(NodoAVL nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrden(nodo.derecho);
        }
    }

    
    void recorridoPorNiveles(NodoAVL raiz) {
        if (raiz == null) return;

        Queue<NodoAVL> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size();

            for (int i = 0; i < nivelSize; i++) {
                NodoAVL nodo = cola.poll();
                System.out.print(nodo.valor + " ");

                if (nodo.izquierdo != null)
                    cola.add(nodo.izquierdo);
                if (nodo.derecho != null)
                    cola.add(nodo.derecho);
            }
            System.out.println();  
        }
    }

    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        NodoAVL raiz = null;

        int[] valores = {20, 30, 10, 25, 40, 50};

        for (int v : valores) {
            raiz = arbol.insertar(raiz, v);
        }

        System.out.println("Recorrido en inorden:");
        arbol.inOrden(raiz);
        System.out.println("\n\nRecorrido por niveles:");
        arbol.recorridoPorNiveles(raiz);
    }
}

