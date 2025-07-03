/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios.estrcuturas.semana.pkg12;
import java.util.*;
/**
 *
 * @author utpl
 */
public class EjerciciosEstructurasSemana12 {

    /**
     * @param args the command line arguments
     */
    
        

    public static void main(String[] args) {
    // TODO code application logic here
    
        //  Grafo No Dirigido 
        Map<String, List<String>> grafoNoDirigido = new HashMap<>();

        agregarConexionNoDirigida(grafoNoDirigido, "Casa", "Parque");
        agregarConexionNoDirigida(grafoNoDirigido, "Casa", "Escuela");
        agregarConexionNoDirigida(grafoNoDirigido, "Parque", "Tienda");

        System.out.println(" Grafo No Dirigido:");
        mostrarGrafo(grafoNoDirigido);


        //  Grafo Dirigido 
        Map<String, List<String>> grafoDirigido = new HashMap<>();

        agregarConexionDirigida(grafoDirigido, "Inicio", "Paso1");
        agregarConexionDirigida(grafoDirigido, "Paso1", "Paso2");
        agregarConexionDirigida(grafoDirigido, "Paso2", "Fin");

        System.out.println("\n Grafo Dirigido:");
        mostrarGrafo(grafoDirigido);


        //  Grafo Ponderado (simple con texto) 
        Map<String, List<String>> grafoPonderado = new HashMap<>();

        agregarConexionDirigida(grafoPonderado, "CiudadA", "CiudadB (costo 10)");
        agregarConexionDirigida(grafoPonderado, "CiudadA", "CiudadC (costo 5)");
        agregarConexionDirigida(grafoPonderado, "CiudadB", "CiudadD (costo 3)");
        agregarConexionDirigida(grafoPonderado, "CiudadC", "CiudadE (costo 6)");

        System.out.println("\n Grafo Ponderado:");
        mostrarGrafo(grafoPonderado);
    }



    // Agrega conexión para grafo no dirigido (en ambos sentidos)
    public static void agregarConexionNoDirigida(Map<String, List<String>> grafo, String nodo1, String nodo2) {
        grafo.computeIfAbsent(nodo1, clave -> new ArrayList<>()).add(nodo2);
        grafo.computeIfAbsent(nodo2, clave -> new ArrayList<>()).add(nodo1);
    }

    // Agrega conexión para grafo dirigido (una sola dirección)
    public static void agregarConexionDirigida(Map<String, List<String>> grafo, String desde, String hacia) {
        grafo.computeIfAbsent(desde, clave -> new ArrayList<>()).add(hacia);
    }

    // Muestra todo el grafo
    public static void mostrarGrafo(Map<String, List<String>> grafo) {
        for (String nodo : grafo.keySet()) {
            System.out.println(nodo + " --> " + grafo.get(nodo));
        }
    }
}

    
