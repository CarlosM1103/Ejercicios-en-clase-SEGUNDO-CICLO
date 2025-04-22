/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estructuras.semana.pkg3;

/**
 *
 * @author utpl
 */
public class EjerciciosEstructurasSemana31 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int a = 1;
        parametroA(a);
    }
    public static void parametroA(int a) {
        // TODO code application logic here
        a = 1;
        parametroB(a);
    }
    
    public static void parametroB(int a) {
        a = 1;
        parametroA(a);
    }

}
