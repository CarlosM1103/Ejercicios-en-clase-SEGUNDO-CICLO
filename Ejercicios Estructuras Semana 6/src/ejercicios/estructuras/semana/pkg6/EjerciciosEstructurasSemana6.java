/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg6;

/**
 *
 * @author utpl
 */
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Queue;

public class EjerciciosEstructurasSemana6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("----------------- PILAS -----------------");
        Stack<String> pila = new Stack<>();
        pila.push("Objeto 1");
        pila.push("Objeto 2");
        pila.push("Objeto 3");
        pila.push("Objeto 4");
        pila.push("Objeto 5");

        System.out.println(pila);

        //Ver el ultimo elemento
        System.out.println("\nUltimo elemento: " + pila.peek());
        //Eliminar el ultimo elemento
        System.out.println("\nUltimo elemento eliminado: " + pila.pop());
        //ver luego de eliminar
        System.out.println("\nPila nueva: " + pila);
        //buscar elemento
        System.out.println("\nBuscar elemento: " + pila.search("Objeto 4"));

        System.out.println("----------------- COLAS -----------------");
        //Colas con la clase Dequeue
        Queue<String> colas = new ArrayDeque<>();
        colas.add("Amador");
        colas.add("Alex");
        colas.add("Pedro");

        System.out.println("Cola original: " + colas);
        //Eliminar el primer elemento
        System.out.println(colas.poll());

        System.out.println("Cola nueva :" + colas);
    }

}
