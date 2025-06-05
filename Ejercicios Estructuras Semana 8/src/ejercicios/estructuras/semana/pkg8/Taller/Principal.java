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
public class Principal {

   static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListaSimple listaSimple = new ListaSimple();
        ListaDoble listaDoble = new ListaDoble();
        ListaCircularSimple listaCircularSimple = new ListaCircularSimple();
        ListaCircularDoble listaCircularDoble = new ListaCircularDoble(); 

        while (true) {
            System.out.println("\nElija una opción con un número:");
            System.out.println("(1) Lista simple enlazada");
            System.out.println("(2) Lista doble enlazada");
            System.out.println("(3) Lista circular simple enlazada");
            System.out.println("(4) Lista circular doble enlazada");
            System.out.println("(5) Salir");
            System.out.print("Opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    listaSimple.menu(sc);
                    break;
                case "2":
                    listaDoble.menu(sc);
                    break;
                case "3":
                    listaCircularSimple.menu(sc);
                    break;
                case "4":
                    listaCircularDoble.menu(sc);
                 
                    break;
                case "5":
                    sc.close();
                    
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        }
    }
}





   

     
    
