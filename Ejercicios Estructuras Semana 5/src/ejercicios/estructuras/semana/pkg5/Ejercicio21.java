/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.estructuras.semana.pkg5;

import java.util.Scanner;



/**
 *
 * @author utpl
 */
public class Ejercicio21 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese el tamano que va a tener la matriz en filas y columnas");

        int tamano = leer.nextInt();
        int[][] arreglo1 = new int[tamano][tamano];
        int[][] arreglo2 = new int[tamano][tamano];
        int[][] arregloF = new int[tamano][tamano];

        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = i; j < arreglo1[i].length; j++) {
                arreglo1[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int i = 0; i < arreglo2.length; i++) {
            for (int j = i; j < arreglo2[i].length; j++) {
                arreglo2[i][j] = (int) (Math.random() * 10);
            }
        }

        System.out.println("""
                           \n-------------------------------------------------------
                           Ingrese un numerofamero segun las opciones puestas:\n
                           (1)Suma de matrices
                           (2)Resta de matrices
                           (3)Multiplicacion de matrices
                           (4)Transposicion de una matriz
                           (5)Determinante (para matrices cuadradas 2x2 o 3x3)
                           (6)Inversa (solo para matrices cuadradas 2x2)
                           (7)Salir del programa\n""");

        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                sumaM(arreglo1, arreglo2, arregloF);
                imprimir(arreglo1, arreglo2, arregloF);
                break;
            case 2:
                restaM(arreglo1, arreglo2, arregloF);
                imprimir(arreglo1, arreglo2, arregloF);
                break;
            case 3:
                System.out.println("\nIngrese número de filas de la primera matriz:");
                int filas1 = leer.nextInt();
                System.out.println("Ingrese número de columnas de la primera matriz (y filas de la segunda):");
                int columnas1 = leer.nextInt();
                System.out.println("Ingrese número de columnas de la segunda matriz:");
                int columnas2 = leer.nextInt();

                arreglo1 = new int[filas1][columnas1];
                arreglo2 = new int[columnas1][columnas2]; // importante: columnas1 == filas2
                arregloF = new int[columnas1][columnas1];

                for (int i = 0; i < filas1; i++) {
                    for (int j = 0; j < columnas1; j++) {
                        arreglo1[i][j] = (int) (Math.random() * 10);
                    }
                }

                for (int i = 0; i < columnas1; i++) {
                    for (int j = 0; j < columnas2; j++) {
                        arreglo2[i][j] = (int) (Math.random() * 10);
                    }
                }

                arregloF = multiplicacionM(arreglo1, arreglo2);
                imprimir(arreglo1, arreglo2, arregloF);
                break;

            case 4:
                transposicionM(arreglo1);
                break;
            case 5:
                determinanteM(arreglo1);
                break;
            case 6:
                inversaM(arreglo1);
                break;

            default:
                break;
        }

    }

    public static int[][] sumaM(int[][] arreglo1, int[][] arreglo2, int[][] arregloF) {

        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = i; j < arreglo1[i].length; j++) {
                arregloF[i][j] = arreglo1[i][j] + arreglo2[i][j];
            }
        }

        return arregloF;

    }

    public static int[][] restaM(int[][] arreglo1, int[][] arreglo2, int[][] arregloF) {
        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = i; j < arreglo1[i].length; j++) {
                arregloF[i][j] = arreglo1[i][j] - arreglo2[i][j];
            }
        }
        return arregloF;
    }

    public static int[][] multiplicacionM(int[][] arreglo1, int[][] arreglo2) {
        int filas1 = arreglo1.length;
        int columnas1 = arreglo1[0].length;
        int filas2 = arreglo2.length;
        int columnas2 = arreglo2[0].length;

        if (columnas1 != filas2) {
            throw new IllegalArgumentException("No se pueden multiplicar: columnas de la primera matriz deben ser iguales a filas de la segunda.");
        }

        int[][] arregloF = new int[filas1][columnas2];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                 arregloF[i][j] = 0;
                for (int k = 0; k < columnas1; k++) {
                    arregloF[i][j] += arreglo1[i][k] * arreglo2[k][j];
                }
            }
        }
        return arregloF;
    }

    public static void transposicionM(int[][] arreglo) {
        
        System.out.println("Arreglo 1: \n");
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.print(arreglo[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
        
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i + 1; j < arreglo[i].length; j++) {
                int temp = arreglo[i][j];
                arreglo[i][j] = arreglo[j][i];
                arreglo[j][i] = temp;
            }
        }
        
        
        System.out.println("Arreglo 1: \n");
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.print(arreglo[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void determinanteM(int[][] arreglo) {
        int n = arreglo.length;
        
        System.out.println("Arreglo 1: \n");
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.print(arreglo[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
        
        if (n == 2) {
            int det = arreglo[0][0] * arreglo[1][1] - arreglo[0][1] * arreglo[1][0];
            System.out.println("Determinante: " + det);
        } else if (n == 3) {
            int det = arreglo[0][0] * (arreglo[1][1] * arreglo[2][2] - arreglo[1][2] * arreglo[2][1])
                    - arreglo[0][1] * (arreglo[1][0] * arreglo[2][2] - arreglo[1][2] * arreglo[2][0])
                    + arreglo[0][2] * (arreglo[1][0] * arreglo[2][1] - arreglo[1][1] * arreglo[2][0]);
            System.out.println("Determinante: " + det);
        } else {
            System.out.println("Determinante no implementado para matrices mayores a 3x3.");
        }
    }

    public static void inversaM(int[][] arreglo) {
        System.out.println("Arreglo 1: \n");
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.print(arreglo[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
        
        int n = arreglo.length;
        if (n != 2) {
            System.out.println("Solo se puede calcular la inversa de matrices 2x2.");
            return;
        }

        int det = arreglo[0][0] * arreglo[1][1] - arreglo[0][1] * arreglo[1][0];
        if (det == 0) {
            System.out.println("La matriz no tiene inversa (determinante es 0).");
            return;
        }

        int[][] inversa = new int[2][2];
        inversa[0][0] = arreglo[1][1];
        inversa[0][1] = -arreglo[0][1];
        inversa[1][0] = -arreglo[1][0];
        inversa[1][1] = arreglo[0][0];
        
        

        System.out.println("Matriz inversa:");
        for (int i = 0; i < inversa.length; i++) {
            for (int j = 0; j < inversa[i].length; j++) {
                System.out.print(inversa[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void imprimir(int[][] arreglo1, int[][] arreglo2, int[][] arregloF) {

        System.out.println("Arreglo 1: \n");
        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = 0; j < arreglo1[i].length; j++) {
                System.out.print(arreglo1[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");

        System.out.println("Arreglo 2; \n");
        for (int i = 0; i < arreglo2.length; i++) {
            for (int j = 0; j < arreglo2[i].length; j++) {
                System.out.print(arreglo2[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");

        System.out.println("Arreglo resultante: \n");
        for (int i = 0; i < arregloF.length; i++) {
            for (int j = 0; j < arregloF[i].length; j++) {
                System.out.print(arregloF[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
