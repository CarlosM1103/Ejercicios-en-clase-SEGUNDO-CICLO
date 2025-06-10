/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg9;

import java.util.Scanner;

/**
 *
 * @author utpl
 */
public class EjerciciosEstructurasSemana9 {

    /**
     * @param args the command line arguments
     */
    private static NodoPila topePila = null;
    private static NodoCola frenteCola = null;
    private static NodoCola finalCola = null;

    // Funciones de la pila
    public static void pushPila(int dato) {
        NodoPila nuevoNodo = new NodoPila(dato);
        nuevoNodo.siguiente = topePila;
        topePila = nuevoNodo;
        System.out.println("Elemento " + dato + " agregado a la pila.");
    }

    public static void popPila() {
        if (topePila == null) {
            System.out.println("Pila vacía, no se puede hacer pop.");
            return;
        }
        int dato = topePila.dato;
        topePila = topePila.siguiente;
        System.out.println("Elemento " + dato + " eliminado de la pila.");
    }

    public static void mostrarPila() {
        if (topePila == null) {
            System.out.println("La pila está vacía.");
            return;
        }
        NodoPila actual = topePila;
        System.out.print("Elementos en la pila: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Funciones de la cola
    public static void pushCola(int dato) {
        NodoCola nuevoNodo = new NodoCola(dato);
        if (finalCola == null) {
            frenteCola = finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
        System.out.println("Elemento " + dato + " agregado a la cola.");
    }

    public static void popCola() {
        if (frenteCola == null) {
            System.out.println("Cola vacía, no se puede hacer pop.");
            return;
        }
        int dato = frenteCola.dato;
        frenteCola = frenteCola.siguiente;
        if (frenteCola == null) {
            finalCola = null;
        }
        System.out.println("Elemento " + dato + " eliminado de la cola.");
    }

    public static void mostrarCola() {
        if (frenteCola == null) {
            System.out.println("La cola está vacía.");
            return;
        }
        NodoCola actual = frenteCola;
        System.out.print("Elementos en la cola: ");
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Función para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Pila Dinámica");
        System.out.println("2. Cola Dinámica");
        System.out.println("3. Salir");
    }

    public static void menuPila(Scanner scanner) {
        int opcion, dato;
        while (true) {
            System.out.println("\nPila Dinámica - Opciones:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Mostrar");
            System.out.println("4. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese un número para agregar a la pila: ");
                dato = scanner.nextInt();
                pushPila(dato);
            } else if (opcion == 2) {
                popPila();
            } else if (opcion == 3) {
                mostrarPila();
            } else if (opcion == 4) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static void menuCola(Scanner scanner) {
        int opcion, dato;
        while (true) {
            System.out.println("\nCola Dinámica - Opciones:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Mostrar");
            System.out.println("4. Volver");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese un número para agregar a la cola: ");
                dato = scanner.nextInt();
                pushCola(dato);
            } else if (opcion == 2) {
                popCola();
            } else if (opcion == 3) {
                mostrarCola();
            } else if (opcion == 4) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        while (true) {
            mostrarMenu();
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                menuPila(scanner);
            } else if (opcion == 2) {
                menuCola(scanner);
            } else if (opcion == 3) {
                System.out.println("¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}


