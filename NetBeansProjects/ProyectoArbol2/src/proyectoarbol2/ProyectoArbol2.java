/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoarbol2;

/**
 *
 * @author ASUS
 */
public class ProyectoArbol2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Arbol arbol = new Arbol();
        arbol.agregar_nodo(8);
        arbol.agregar_nodo(3);
        arbol.agregar_nodo(1);
        arbol.agregar_nodo(20);
        arbol.agregar_nodo(10);
        arbol.agregar_nodo(5);
        arbol.agregar_nodo(4);

        arbol.imprimir(arbol.getRaiz(), 0);
        arbol.preorden_recursivo(arbol.getRaiz());
        System.out.println("");
        arbol.enorden_recursivo(arbol.getRaiz());
        System.out.println("");
        arbol.postorden_recursivo(arbol.getRaiz());
    }

}
