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
public class ListaDoble {

   static class NodoDoble {
        String dato;
        NodoDoble siguiente;
        NodoDoble anterior;

        public NodoDoble(String d) {
            dato = d;
            siguiente = null;
            anterior = null;
        }
    }

        NodoDoble cabeza;

        public ListaDoble() {
            cabeza = null;
        }

        boolean estaVacia() {
            return cabeza == null;
        }

        void insertar(String dato) {
            NodoDoble nuevo = new NodoDoble(dato);
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                NodoDoble actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
                nuevo.anterior = actual;
            }
            System.out.println("Dato insertado: " + dato);
        }

        void eliminar(String dato) {
            if (estaVacia()) {
                System.out.println("La lista está vacía.");
                return;
            }
            NodoDoble actual = cabeza;
            while (actual != null && !actual.dato.equals(dato)) {
                actual = actual.siguiente;
            }
            if (actual == null) {
                System.out.println("Dato no encontrado.");
                return;
            }
            if (actual.anterior == null) { // Es cabeza
                cabeza = actual.siguiente;
                if (cabeza != null) {
                    cabeza.anterior = null;
                }
            } else {
                actual.anterior.siguiente = actual.siguiente;
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                }
            }
            System.out.println("Dato eliminado: " + dato);
        }

        void buscar(String dato) {
            NodoDoble actual = cabeza;
            int pos = 0;
            while (actual != null) {
                if (actual.dato.equals(dato)) {
                    System.out.println("Dato encontrado en posición: " + pos);
                    return;
                }
                actual = actual.siguiente;
                pos++;
            }
            System.out.println("Dato no encontrado.");
        }

        void recorrer() {
            if (estaVacia()) {
                System.out.println("La lista está vacía.");
                return;
            }
            NodoDoble actual = cabeza;
            System.out.print("Lista: ");
            while (actual != null) {
                System.out.print(actual.dato + " <-> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }

        void menu(Scanner sc) {
            while (true) {
                System.out.println("\nLista Doble Enlazada");
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
                        System.out.println("Opción inválida.");
                }
            }
        }
    }
    

