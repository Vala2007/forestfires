/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoarbolavl;

/**
 *
 * @author ASUS
 */
public class ProyectoArbolAVL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int [] arbol = {20, 30, 40, 35, 15, 50, 55, 56, 57, 58};
        Arbol arbolAVL = new Arbol();
        
        for (int i : arbol) {
            arbolAVL.insertar(i);
            System.out.println(" imprimir");
            arbolAVL.TreePrinter();
        }
        
        int alt = arbolAVL.alturaa(arbolAVL.getRaiz());
        System.out.println("La altura del árbol es " + alt); 
        
        arbolAVL.delete(arbolAVL.getRaiz(), 15);
        
        arbolAVL.TreePrinter();
        
    }
    
}
