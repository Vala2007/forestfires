/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafoejercicio;

import java.util.ArrayList;

/**
 *
 * @author vcardenass
 */
public class GrafoEjercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        // Vertices
        Vertice Armenia = new Vertice("Armeria");
        Vertice Denver = new Vertice("Denver");
        Vertice Ontario = new Vertice("Ontario");
        Vertice Montevideo = new Vertice("Montevideo");
        Vertice Bogota = new Vertice("Bogota");
        Vertice Guadalajara = new Vertice("Guadalajara");
        Vertice Lima = new Vertice("Lima");
        Vertice Caracas = new Vertice("Caracas");
        
        grafo.AgregarVertice(Ontario);//0
        grafo.AgregarVertice(Armenia);//1
        grafo.AgregarVertice(Denver);//2
        grafo.AgregarVertice(Bogota);//3
        grafo.AgregarVertice(Guadalajara);//4
        grafo.AgregarVertice(Lima);//5
        grafo.AgregarVertice(Caracas);//6
        grafo.AgregarVertice(Montevideo);//7
        
        grafo.ConectarVertice(Armenia, Denver);
        grafo.ConectarVertice(Armenia, Ontario);
        grafo.ConectarVertice(Armenia, Bogota);
        grafo.ConectarVertice(Denver, Montevideo);
        grafo.ConectarVertice(Ontario, Bogota);
        grafo.ConectarVertice(Ontario, Guadalajara);
        grafo.ConectarVertice(Montevideo, Bogota);
        grafo.ConectarVertice(Bogota, Lima);
        grafo.ConectarVertice(Bogota, Caracas);
        grafo.ConectarVertice(Lima, Caracas);
        grafo.ConectarVertice(Guadalajara, Caracas);
        
        //grafo.Imprimir();
        
        /*
        ArrayList<String> recorridoBFS = grafo.BFS(0);
        for (String string : recorridoBFS) {
            
            System.out.print(string+", ");
        }
        System.out.println("");*/
        
        ArrayList<String> recorridoCorto = grafo.caminoMasCorto(0, 7);
        for (String string : recorridoCorto) {
            
            System.out.print(string+", ");
        }
    }
    
}
