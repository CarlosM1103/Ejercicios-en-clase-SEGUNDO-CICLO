/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg3;

/**
 *
 * @author utpl
 */
public class EjerciciosEstructurasSemana3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrintNum(4);
        System.out.println("Fin");
    }

    public static void PrintNum(int n) {
        //System.out.println(n);
        if (n > 1) {
            PrintNum(n - 1);
        }
        System.out.println(n);
    }
    
}
