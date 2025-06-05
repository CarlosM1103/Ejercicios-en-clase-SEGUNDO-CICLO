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
public class ListaSimple {

   
    static class NodoSimple {
        String dato;
        NodoSimple siguiente;

        public NodoSimple(String d) {
            dato = d;
            siguiente = null;
        }
    }
        NodoSimple cabeza;

        public ListaSimple() {
            cabeza = null;
        }

        boolean estaVacia() {
            return cabeza == null;
        }

        void insertar(String dato) {
            NodoSimple nuevo = new NodoSimple(dato);
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                NodoSimple actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
            System.out.println("Dato insertado: " + dato);
        }

        void eliminar(String dato) {
            if (estaVacia()) {
                System.out.println("La lista está vacía.");
                return;
            }
            NodoSimple actual = cabeza;
            NodoSimple anterior = null;
            while (actual != null && !actual.dato.equals(dato)) {
                anterior = actual;
                actual = actual.siguiente;
            }
            if (actual == null) {
                System.out.println("Dato no encontrado.");
                return;
            }
            if (anterior == null) {
                cabeza = actual.siguiente;
            } else {
                anterior.siguiente = actual.siguiente;
            }
            System.out.println("Dato eliminado: " + dato);
        }

        void buscar(String dato) {
            NodoSimple actual = cabeza;
            int posicion = 0;
            while (actual != null) {
                if (actual.dato.equals(dato)) {
                    System.out.println("Dato encontrado en posición: " + posicion);
                    return;
                }
                actual = actual.siguiente;
                posicion++;
            }
            System.out.println("Dato no encontrado.");
        }

        void recorrer() {
            if (estaVacia()) {
                System.out.println("La lista está vacía.");
                return;
            }
            NodoSimple actual = cabeza;
            System.out.print("Lista: ");
            while (actual != null) {
                System.out.print(actual.dato + " -> ");
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
