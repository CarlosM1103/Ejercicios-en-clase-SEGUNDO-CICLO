/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.estructuras.semana.pkg11;

/**
 *
 * @author utpl
 */
public class Nodo {

    String valor;
    Nodo izquierdo, derecho;

    Nodo(String valor) {
        this.valor = valor;
        this.izquierdo = this.derecho = null;
    }
}
