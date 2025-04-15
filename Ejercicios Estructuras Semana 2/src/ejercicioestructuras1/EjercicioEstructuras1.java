/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioestructuras1;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
        
        
/**
 *
 * @author utpl
 */
public class EjercicioEstructuras1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada = new Scanner(System.in);
        
        File archivo = new File("usuarios.txt");
        
        FileWriter escribir = null;
        PrintWriter linea = null;
        int contador = 1;
        boolean bandera = true;
        String cadena = "";
        
        while (bandera == true){
        try {
            if (!archivo.exists()){
            archivo.createNewFile();
            }
            
            System.out.print("Ingrese nombre: ");
            String nombre = entrada.nextLine();
            
            System.out.print("Ingrese correo: ");
            String correo = entrada.nextLine();
            
            System.out.print("Ingrese direccion: ");
            String direccion = entrada.nextLine();
            
            escribir = new FileWriter(archivo, true);
            
          
            linea = new PrintWriter(escribir);
            
            linea.println("Usuario " + contador);
            linea.println(nombre);
            linea.println(correo);
            linea.println(direccion);
            linea.println("-----------------");
           
            
            System.out.println("Datos guardados correctamente");
        
        } catch(Exception e) {
            System.out.println("Ocurrio un error al escribir el archivo.");
        } finally {
            try{
                if (linea != null) linea.close();
                if (escribir != null) escribir.close();
            } catch (Exception e){
                System.out.println("Error al cerrar el archivo.");
            }
            contador = contador+1;
        }
        
            System.out.println("/nDesea seguir ingresando usuarios? Escriba no para salir");
            cadena = entrada.nextLine();
            
            if (cadena.equals("no") ){
                bandera = false;
            }
            
            
        }
    }
    
}
