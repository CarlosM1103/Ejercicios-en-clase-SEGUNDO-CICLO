/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.estructuras.semana.pkg6;

import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class EjerciciosEstructurasSemana61 {

    static Scanner leer = new Scanner(System.in);
    static Stack<String> elementos = new Stack<>();
    static Queue<String> cola = new LinkedList<>();
    
    public static void main(String[] args) {
        int opcion;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Trabajar con Pila");
            System.out.println("2. Trabajar con Cola");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    menuPilas();
                    break;
                case 2:
                    menuColas();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    public static void menuPilas() {
        int num;
        boolean bandera = true;

        while (bandera) {
            System.out.println("\n----------------------------------------------");
            System.out.println("| Seleccione una de las siguientes opciones: |");
            System.out.println("----------------------------------------------");
            System.out.println("(1) Insertar un elemento (push)");
            System.out.println("(2) Eliminar elemento (pop)");
            System.out.println("(3) Ver elemento superior (peek)");
            System.out.println("(4) Verificar si está vacía");
            System.out.println("(5) Mostrar contenido de la pila");
            System.out.println("(6) Volver al menú principal");
            System.out.print("\nOpción: ");

            num = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            switch (num) {
                case 1:
                    push(elementos);
                    break;
                case 2:
                    pop(elementos);
                    break;
                case 3:
                    peek(elementos);
                    break;
                case 4:
                    verificarVacio(elementos);
                    break;
                case 5:
                    mostrarContenido(elementos);
                    break;
                case 6:
                    bandera = false;
                    break;
                default:
                    System.out.println("Número no disponible");
            }
        }
    }

    public static Stack<String> push(Stack<String> elementos) {
        System.out.print("¿Cuántos elementos desea añadir?: ");
        int num = leer.nextInt();
        leer.nextLine(); // Limpiar buffer

        for (int i = 0; i < num; i++) {
            System.out.print("Elemento Nro. " + (i + 1) + ": ");
            String palabra = leer.nextLine();
            elementos.push(palabra);
        }

        return elementos;
    }

    public static Stack<String> pop(Stack<String> elementos) {
        System.out.print("¿Cuántos elementos desea eliminar?: ");
        int num = leer.nextInt();
        leer.nextLine(); // Limpiar buffer

        for (int i = 0; i < num; i++) {
            if (!elementos.isEmpty()) {
                System.out.println("Elemento eliminado: " + elementos.pop());
            } else {
                System.out.println("La pila está vacía.");
                break;
            }
        }

        return elementos;
    }

    public static void peek(Stack<String> elementos) {
        if (!elementos.isEmpty()) {
            System.out.println("Elemento superior: " + elementos.peek());
        } else {
            System.out.println("La pila está vacía.");
        }
    }

    public static void verificarVacio(Stack<String> elementos) {
        if (elementos.isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("La pila no está vacía.");
        }
    }

    public static void mostrarContenido(Stack<String> elementos) {
        if (elementos.isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Contenido de la pila: " + elementos);
        }
    }

    public static void menuColas() {
        
        boolean ciclo = true;
        int cont = 1;

        while (ciclo) {
            System.out.println("\n==--- Menú ---==\n");
            System.out.println("1. Agregar cliente a la cola");
            System.out.println("2. Atender siguiente cliente");
            System.out.println("3. Mostrar cola de espera");
            System.out.println("4. Volver al menú principal\n");
            System.out.print("Seleccione una opción: ");

            int op = leer.nextInt();
            leer.nextLine(); // Limpiar buffer

            switch (op) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    cola.add(leer.nextLine());
                    break;
                case 2:
                    if (cola.isEmpty()) {
                        System.out.println("La cola de espera está vacía.");
                    } else {
                        System.out.println("Pase el cliente " + cont + ". " + cola.poll() + " a la consulta.");
                        cont++;
                    }
                    break;
                case 3:
                    if (cola.isEmpty()) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("Cola de espera: " + cola);
                    }
                    break;
                case 4:
                    ciclo = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}



