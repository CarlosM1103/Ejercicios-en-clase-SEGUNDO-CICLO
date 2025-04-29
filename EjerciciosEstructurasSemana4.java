/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg4;

import java.util.Scanner;

/**
 *
 * @author utpl
 */
public class EjerciciosEstructurasSemana4 {

    /**
     * @param args the command line arguments
     */
    
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int arreglo1[] = new int [10];
        datosArreglo(arreglo1);
        
        
        for (int i = 0; i <= 10; i++) {
                System.out.println("\nValor numero "+ (i+1)+ " : " + arreglo1[i]);
        }

    }
    
    public static int[] datosArreglo(int arreglo1[]) {
        
       arreglo1 = new int [10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el valor numero " + (i + 1) + " : ");
            arreglo1[i] = leer.nextInt();

            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (arreglo1[i] == arreglo1[j]) {
                        System.out.println("\nNuumero repetido, ingreselo nuevamente\n");
                        i = i - 1;
                    }
                }
            }
        }
        
        return arreglo1;
    }

}
