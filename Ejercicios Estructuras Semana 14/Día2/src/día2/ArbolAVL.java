/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package día2;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

// Clase Nodo del árbol AVL
class NodoAVL {

    int valor;      // Valor que guarda el nodo
    int fe;         // Factor de equilibrio
    NodoAVL izq;    // Hijo izquierdo
    NodoAVL der;    // Hijo derecho

    public NodoAVL(int _valor) {
        this.valor = _valor;
        this.fe = 0;      // Factor de equilibrio inicia en 0
        this.izq = null;
        this.der = null;
    }
}

// Clase que contiene los métodos del árbol AVL
class MetodosAVL {

    Scanner entrada;
    NodoAVL raiz;
    boolean h; // Bandera que indica si la altura del árbol cambió

    public MetodosAVL() {
        this.entrada = new Scanner(System.in);
        this.raiz = null;
        this.h = true;
    }

    // Menú de opciones
    public int menu() {
        System.out.println("\n--- MENÚ ÁRBOL AVL ---");
        System.out.println("Insertar nodo     [1]");
        System.out.println("Mostrar árbol     [2]");
        System.out.println("Eliminar nodo     [3]");
        System.out.println("Salir             [0]");
        System.out.print("Elige una opción: ");
        return entrada.nextInt();
    }

    // Verifica si un nodo está vacío (es nulo)
    public boolean nodoVacio(NodoAVL actual) {
        return actual == null;
    }

    // Rotación simple izquierda-izquierda
    public NodoAVL rotacionII(NodoAVL actual, NodoAVL n1) {
        actual.izq = n1.der;
        n1.der = actual;
        if (n1.fe == -1) {
            actual.fe = 0;
            n1.fe = 0;
        } else {
            actual.fe = -1;
            n1.fe = 1;
        }
        return n1;
    }

    // Rotación simple derecha-derecha
    public NodoAVL rotacionDD(NodoAVL actual, NodoAVL n1) {
        actual.der = n1.izq;
        n1.izq = actual;
        if (n1.fe == 1) {
            actual.fe = 0;
            n1.fe = 0;
        } else {
            actual.fe = 1;
            n1.fe = -1;
        }
        return n1;
    }

    // Rotación doble izquierda-derecha
    public NodoAVL rotacionID(NodoAVL actual, NodoAVL n1) {
        NodoAVL n2 = n1.der;
        actual.izq = n2.der;
        n2.der = actual;
        n1.der = n2.izq;
        n2.izq = n1;

        if (n2.fe == 1) {
            n1.fe = -1;
        } else {
            n1.fe = 0;
        }

        if (n2.fe == -1) {
            actual.fe = 1;
        } else {
            actual.fe = 0;
        }

        n2.fe = 0;
        return n2;
    }

    // Rotación doble derecha-izquierda
    public NodoAVL rotacionDI(NodoAVL actual, NodoAVL n1) {
        NodoAVL n2 = n1.izq;
        actual.der = n2.izq;
        n2.izq = actual;
        n1.izq = n2.der;
        n2.der = n1;

        if (n2.fe == -1) {
            n1.fe = 1;
        } else {
            n1.fe = 0;
        }

        if (n2.fe == 1) {
            actual.fe = -1;
        } else {
            actual.fe = 0;
        }

        n2.fe = 0;
        return n2;
    }

    // Inserta un nodo en el árbol manteniendo balance AVL
    public NodoAVL insertarAVL(int num, NodoAVL actual) {
        if (nodoVacio(actual)) {
            NodoAVL nuevo = new NodoAVL(num);
            h = true;
            return nuevo;
        } else if (num < actual.valor) {
            actual.izq = insertarAVL(num, actual.izq);
            if (h) {
                switch (actual.fe) {
                    case 1 -> {
                        actual.fe = 0;
                        h = false;
                    }
                    case 0 ->
                        actual.fe = -1;
                    case -1 -> {
                        NodoAVL n1 = actual.izq;
                        if (n1.fe == -1) {
                            actual = rotacionII(actual, n1);
                        } else {
                            actual = rotacionID(actual, n1);
                        }
                        h = false;
                    }
                }
            }
        } else {
            actual.der = insertarAVL(num, actual.der);
            if (h) {
                switch (actual.fe) {
                    case 1 -> {
                        NodoAVL n1 = actual.der;
                        if (n1.fe == 1) {
                            actual = rotacionDD(actual, n1);
                        } else {
                            actual = rotacionDI(actual, n1);
                        }
                        h = false;
                    }
                    case 0 ->
                        actual.fe = 1;
                    case -1 -> {
                        actual.fe = 0;
                        h = false;
                    }
                }
            }
        }
        return actual;
    }

    // Busca un valor en el árbol y muestra cuántos pasos tomó
    public void buscar(NodoAVL actual, int num, int cont) {
        if (nodoVacio(actual)) {
            System.out.println("Elemento no encontrado...");
        } else if (num < actual.valor) {
            buscar(actual.izq, num, ++cont);
        } else if (num > actual.valor) {
            buscar(actual.der, num, ++cont);
        } else {
            System.out.println("Nodo encontrado en " + cont + " pasos.");
        }
    }

    // Elimina un nodo del árbol AVL y rebalancea si es necesario
    public NodoAVL eliminar(int num, NodoAVL actual) {
        if (actual == null) {
            System.out.println("Nodo no encontrado.");
            h = false;
            return null;
        } else if (num < actual.valor) {
            actual.izq = eliminar(num, actual.izq);
            if (h) {
                actual = balancearDerecha(actual);
            }
        } else if (num > actual.valor) {
            actual.der = eliminar(num, actual.der);
            if (h) {
                actual = balancearIzquierda(actual);
            }
        } else {
            // Nodo encontrado
            NodoAVL aux = actual;
            if (aux.der == null) {
                actual = aux.izq;
                h = true;
            } else if (aux.izq == null) {
                actual = aux.der;
                h = true;
            } else {
                NodoAVL reemplazo = buscarReemplazo(aux.izq);
                actual.valor = reemplazo.valor;
                actual.izq = eliminar(reemplazo.valor, actual.izq);
                if (h) {
                    actual = balancearDerecha(actual);
                }
            }
        }
        return actual;
    }

    // Encuentra el mayor valor del subárbol izquierdo (reemplazo)
    private NodoAVL buscarReemplazo(NodoAVL actual) {
        while (actual.der != null) {
            actual = actual.der;
        }
        return actual;
    }

    // Balanceo cuando se elimina por la izquierda
    private NodoAVL balancearDerecha(NodoAVL actual) {
        switch (actual.fe) {
            case -1 ->
                actual.fe = 0;
            case 0 -> {
                actual.fe = 1;
                h = false;
            }
            case 1 -> {
                NodoAVL n1 = actual.der;
                if (n1.fe >= 0) {
                    actual = rotacionDD(actual, n1);
                    if (n1.fe == 0) {
                        actual.fe = -1;
                        h = false;
                    }
                } else {
                    actual = rotacionDI(actual, n1);
                }
            }
        }
        return actual;
    }

    // Balanceo cuando se elimina por la derecha
    private NodoAVL balancearIzquierda(NodoAVL actual) {
        switch (actual.fe) {
            case 1 ->
                actual.fe = 0;
            case 0 -> {
                actual.fe = -1;
                h = false;
            }
            case -1 -> {
                NodoAVL n1 = actual.izq;
                if (n1.fe <= 0) {
                    actual = rotacionII(actual, n1);
                    if (n1.fe == 0) {
                        actual.fe = 1;
                        h = false;
                    }
                } else {
                    actual = rotacionID(actual, n1);
                }
            }
        }
        return actual;
    }

    // Muestra el árbol en orden (de menor a mayor)
    public void mostrarPorNiveles(NodoAVL raiz) {
        if (raiz == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        Queue<NodoAVL> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size();  // Número de nodos en el nivel actual

            for (int i = 0; i < nivelSize; i++) {
                NodoAVL actual = cola.poll();
                System.out.print(actual.valor + " ");

                if (actual.izq != null) {
                    cola.add(actual.izq);
                }
                if (actual.der != null) {
                    cola.add(actual.der);
                }
            }
            System.out.println(); // Salto de línea para cambiar de nivel
        }
    }
}

// Clase principal con el main
public class ArbolAVL {

    public static void main(String[] args) {
        int op, num;
        MetodosAVL myArbol = new MetodosAVL();

        do {
            op = myArbol.menu();
            switch (op) {
                case 1 -> {
                    System.out.print("Valor a insertar: ");
                    num = myArbol.entrada.nextInt();
                    myArbol.raiz = myArbol.insertarAVL(num, myArbol.raiz);
                }
                case 2 -> {

                    System.out.println("Árbol AVL por niveles:");
                    myArbol.mostrarPorNiveles(myArbol.raiz);
                }
                case 3 -> {
                    System.out.print("Valor a eliminar: ");
                    num = myArbol.entrada.nextInt();
                    myArbol.raiz = myArbol.eliminar(num, myArbol.raiz);
                }
                case 0 ->
                    System.out.println("Saliendo del programa...");
                default ->
                    System.out.println("Opción no válida.");
            }
        } while (op != 0);
    }
}
