/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg10;

import java.util.Scanner;

/**
 *
 * @author utpl
 */
public class EjerciciosEstructurasSemana10 {

    public static class Nodo {

        int valor;
        Nodo izquierda, derecha;

        public Nodo(int valor) {
            this.valor = valor;
            izquierda = derecha = null;
        }
    }

    public static class ArbolBinario {

        Nodo raiz;

        public void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }

        private Nodo insertarRec(Nodo raiz, int valor) {
            if (raiz == null) {
                raiz = new Nodo(valor);
                return raiz;
            }

            if (valor < raiz.valor) {
                raiz.izquierda = insertarRec(raiz.izquierda, valor);
            } else if (valor > raiz.valor) {
                raiz.derecha = insertarRec(raiz.derecha, valor);
            }

            return raiz;
        }

        public void preorden(Nodo nodo) {
            if (nodo != null) {
                System.out.print(nodo.valor + " ");
                preorden(nodo.izquierda);
                preorden(nodo.derecha);
            }
        }

        public void inorden(Nodo nodo) {
            if (nodo != null) {
                inorden(nodo.izquierda);
                System.out.print(nodo.valor + " ");
                inorden(nodo.derecha);
            }
        }

        public void posorden(Nodo nodo) {
            if (nodo != null) {
                posorden(nodo.izquierda);
                posorden(nodo.derecha);
                System.out.print(nodo.valor + " ");
            }
        }
    }

        public static void main(String[] args) {
            ArbolBinario arbol = new ArbolBinario();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese 10 números para el árbol binario:");
            for (int i = 0; i < 10; i++) {
                System.out.print("Número " + (i + 1) + ": ");
                int valor = scanner.nextInt();
                arbol.insertar(valor);
            }

            System.out.println("\nRecorrido Preorden:");
            arbol.preorden(arbol.raiz);

            System.out.println("\nRecorrido Inorden:");
            arbol.inorden(arbol.raiz);

            System.out.println("\nRecorrido Posorden:");
            arbol.posorden(arbol.raiz);
        }
    }
