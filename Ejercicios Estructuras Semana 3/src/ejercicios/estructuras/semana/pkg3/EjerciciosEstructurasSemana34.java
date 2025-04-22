/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg3;

/**
 *
 * @author utpl
 */
public class EjerciciosEstructurasSemana34 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int num = 1;
        Factorial(6,num);
        System.out.println("Fin");
    }

    public static void Factorial(int n, int num) {
        num = num*n;
        if (n > 1) {
            Factorial(n - 1,num);
        }
        
        if (n == 1){
         System.out.println(num);
        }
       
    }
    
}
