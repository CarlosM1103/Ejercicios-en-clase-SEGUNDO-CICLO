/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg8;

/**
 *
 * @author utpl
 */
public class EjerciciosEstructurasSemana8 {

    /**
     * @param args the command line arguments
     */

    static Nodo cabeza = null;

     public static void main(String[] args) {
        insertar(10);
        insertar(20);
        insertar(30);
        insertar(40);
         insertar(100);
        imprimirLista(); 
    }
     
    public static void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    public static void imprimirLista() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

   
}
