/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.estructuras.semana.pkg5;

import java.util.Scanner;
import java.util.Random;
import java.util.random.RandomGenerator;

/**
 *
 * @author utpl
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el tamano que va a tener la matriz "
                + "cuadrada por lado:");
        int tamano = leer.nextInt();
        int[][] arreglo = new int[tamano][tamano];
        int[][] arreglo2 = new int[tamano][tamano];
        int[][] arregloF = new int [tamano][tamano];

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i; j < arreglo[i].length; j++) {
                arreglo[i][j] = (int)(Math.random()*10);
            }
        }
        
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i; j < arreglo[i].length; j++) {
                arreglo2[i][j] = (int)(Math.random()*10);
            }
        }
        System.out.println("\nMatriz Normal: \n");
        imprimir(arreglo);
        transpuesta(arreglo2);
        System.out.println("Matriz Transpuesta: \n");
        imprimir(arreglo2);
        multiplicacion(arreglo,arreglo2,arregloF);
        System.out.println("Matriz multiplicada: \n");
        imprimir(arregloF);
        
    }

    public static void transpuesta(int mat[][]) {
        int contador;
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j < mat[0].length; j++) {
                contador = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = contador;
            }
        }
    }
    
    public static void imprimir(int arreglo[][]) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.print(arreglo[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static int[][] multiplicacion(int arreglo1[][],int arreglo2[][], int arregloF[][]) {
        
        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = i; j < arreglo1[i].length; j++) {
                arregloF[i][j] = arreglo1[i][j] * arreglo2[i][j];
            }
        }
        return arregloF;
    }
}
