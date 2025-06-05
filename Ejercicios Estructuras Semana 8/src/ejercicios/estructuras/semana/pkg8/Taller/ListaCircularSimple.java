/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.estructuras.semana.pkg8.Taller;

import java.util.Scanner;

/**
 *
 * @author utpl
 */
public class ListaCircularSimple {

    static class NodoCircularSimple {

        String dato;
        NodoCircularSimple siguiente;

        public NodoCircularSimple(String d) {
            dato = d;
            siguiente = null;
        }
    }
    NodoCircularSimple cabeza;

    public ListaCircularSimple() {
        cabeza = null;
    }

    boolean estaVacia() {
        return cabeza == null;
    }

    void insertar(String dato) {
        NodoCircularSimple nuevo = new NodoCircularSimple(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            NodoCircularSimple actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        System.out.println("Dato insertado: " + dato);
    }

    void eliminar(String dato) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoCircularSimple actual = cabeza;
        NodoCircularSimple anterior = null;
        boolean encontrado = false;

        do {
            if (actual.dato.equals(dato)) {
                encontrado = true;
                break;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (!encontrado) {
            System.out.println("Dato no encontrado.");
            return;
        }

        if (actual == cabeza) {
            if (cabeza.siguiente == cabeza) { 
                cabeza = null;
            } else {
                NodoCircularSimple ultimo = cabeza;
                while (ultimo.siguiente != cabeza) {
                    ultimo = ultimo.siguiente;
                }
                cabeza = cabeza.siguiente;
                ultimo.siguiente = cabeza;
            }
        } else {
            anterior.siguiente = actual.siguiente;
        }
        System.out.println("Dato eliminado: " + dato);
    }

    void buscar(String dato) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoCircularSimple actual = cabeza;
        int pos = 0;
        do {
            if (actual.dato.equals(dato)) {
                System.out.println("Dato encontrado en posición: " + pos);
                return;
            }
            actual = actual.siguiente;
            pos++;
        } while (actual != cabeza);
        System.out.println("Dato no encontrado.");
    }

    void recorrer() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoCircularSimple actual = cabeza;
        System.out.print("Lista circular simple: ");
        do {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(regresa a cabeza)");
    }

    void menu(Scanner sc) {
        while (true) {
            System.out.println("\nLista Circular Doble Enlazada");
            System.out.println("1) Insertar");
            System.out.println("2) Eliminar");
            System.out.println("3) Buscar");
            System.out.println("4) Recorrer");
            System.out.println("5) Verificar si está vacía");
            System.out.println("6) Regresar al menú principal");
            System.out.print("Elija opción: ");
            String op = sc.nextLine();
            switch (op) {
                case "1":
                    System.out.print("Ingrese dato a insertar: ");
                    String datoInsertar = sc.nextLine();
                    insertar(datoInsertar);
                    break;
                case "2":
                    System.out.print("Ingrese dato a eliminar: ");
                    String datoEliminar = sc.nextLine();
                    eliminar(datoEliminar);
                    break;
                case "3":
                    System.out.print("Ingrese dato a buscar: ");
                    String datoBuscar = sc.nextLine();
                    buscar(datoBuscar);
                    break;
                case "4":
                    recorrer();
                    break;
                case "5":
                    if (estaVacia()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        System.out.println("La lista NO está vacía.");
                    }
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Opcion no valida");
                break;
            }
        }
    }
}
