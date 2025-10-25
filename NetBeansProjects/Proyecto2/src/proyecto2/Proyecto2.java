/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

import java.util.Scanner;
/**
 *
 * @author ABRAHAM
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        
        //arbol.agregarNodoIn("A");
        String In[] = {"G", "D", "K", "H", "B", "E", "A", "C", "I", "F", "J"};
        String Pre[] = {"A", "B", "D", "G", "H", "K", "E", "C", "F", "I", "J"};
        
        arbol.diosmio(In, Pre);

        arbol.TreePrinter();
         
//        for(int i = 0; i < 7; i++){
//            System.out.println("Ingrese el dato del arbol ");
//            int e = scanner.nextInt();
//            arbol.agregarNodoIn(e);

       
        //arbol.imprimir(arbol.getRaiz(), 0);
        
//        System.out.println("");
//        arbol.preorden_iterativo(arbol.getRaiz());
//        
//        System.out.println("");
//        arbol.preorden_recursivo(arbol.getRaiz());
//        System.out.println("");
//        arbol.enorden_recursivo(arbol.getRaiz());
//        System.out.println("");
//        arbol.inorden_iterativo(arbol.getRaiz());
//        System.out.println("");
//        arbol.postorden_recursivo(arbol.getRaiz());
//        System.out.println("");
//        arbol.postorden_iterativo(arbol.getRaiz());
//        
        

        
       
       
       
        //arbol.postorden_iterativo(arbol.getRaiz());
//      System.out.print(arbol.sumar(arbol.getRaiz()));                
//      System.out.println("La suma de los nodos es " + arbol.sumar(arbol.getRaiz()));

        
//        System.out.println("\nIngrese un número para buscar en el árbol ");
//        int buscado = scanner.nextInt();
//        Nodo resultado = arbol.buscar_nodo(arbol.getRaiz(), buscado);
//        if (resultado != null) {
//            System.out.println("El elemento " + resultado.getDato() + " sí se encuentra en el árbol");
//        } else {
//            System.out.println("El elemento " + buscado + " no se encuentra en el árbol");
//        }
        
        
//        System.out.println("La altura del árbol es " + arbol.altura_arbol(arbol.getRaiz()));
//
//        
//        System.out.println("\nIngrese un número para encontrar su tío ");
//        int buscartio = scanner.nextInt();
//
//        Nodo nodo = arbol.buscar_nodo(arbol.getRaiz(), buscartio);
//        Nodo tio = arbol.tio(arbol.getRaiz(), nodo);
//
//        if (tio != null) {
//            System.out.println("El tío de " + buscartio + " es " + tio.getDato());
//        } else {
//            System.out.println("El nodo " + buscartio + " no tiene tío");
//        }
        
        
//        int completo = arbol.arbol_completo(arbol.getRaiz());
//        if (completo == 1){
//            System.out.println("El árbol es completo");            
//        }
//        else {
//            System.out.println("El árbol no es completo");
//        }
        
        
        //System.out.println("\nIngrese el dato a eliminar: ");
        //int datoEliminar = scanner.nextInt();
        //arbol.eliminar_nodo(datoEliminar);

        //System.out.println("\nÁrbol después de eliminar:");
        //arbol.imprimir(arbol.getRaiz(), 0);
        
        
//        int alt = arbol.alturaa(arbol.getRaiz());
//        System.out.println("La altura del árbol es " + alt);        
        


   } 
    
}
