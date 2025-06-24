/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg11;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author utpl
 */
public class ArbolExpresionPostfija {

    /**
     * @param args the command line arguments
     */
    private boolean esOperador(String simbolo) {
        return simbolo.equals("+") || simbolo.equals("-") || simbolo.equals("*") || simbolo.equals("/");
    }

    public Nodo construirArbol(String[] expresionPostfija) {
        Stack<Nodo> pila = new Stack<>();

        for (String simbolo : expresionPostfija) {
            if (!esOperador(simbolo)) {

                Nodo nodo = new Nodo(simbolo);
                pila.push(nodo);
            } else {

                Nodo derecho = pila.pop();
                Nodo izquierdo = pila.pop();
                Nodo operador = new Nodo(simbolo);
                operador.izquierdo = izquierdo;
                operador.derecho = derecho;
                pila.push(operador);
            }
        }

        return pila.peek();
    }

    public void mostrarEnOrden(Nodo nodo) {
        if (nodo != null) {
            if (nodo.izquierdo != null || nodo.derecho != null) {
                System.out.print("(");
            }
            mostrarEnOrden(nodo.izquierdo);
            System.out.print(nodo.valor);
            mostrarEnOrden(nodo.derecho);
            if (nodo.izquierdo != null || nodo.derecho != null) {
                System.out.print(")");
            }
        }
    }

    public void mostrarPorNiveles(Nodo raiz) {
        if (raiz == null) {
            return;
        }

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        int nivel = 0;
        while (!cola.isEmpty()) {
            int cantidad = cola.size();
            System.out.print("Nivel " + nivel + ": ");
            for (int i = 0; i < cantidad; i++) {
                Nodo actual = cola.poll();
                System.out.print(actual.valor + " ");
                if (actual.izquierdo != null) {
                    cola.add(actual.izquierdo);
                }
                if (actual.derecho != null) {
                    cola.add(actual.derecho);
                }
            }
            System.out.println();
            nivel++;
        }
    }

    public static void main(String[] args) {
        ArbolExpresionPostfija arbol = new ArbolExpresionPostfija();

  
        String[] expresion = {"9", "2", "8", "1", "-", "*", "/"};

        Nodo raiz = arbol.construirArbol(expresion);

        System.out.print("Expresión infija equivalente: ");
        arbol.mostrarEnOrden(raiz); 
        System.out.println();

        System.out.println("\nÁrbol mostrado por niveles:");
        arbol.mostrarPorNiveles(raiz);
    }
}

