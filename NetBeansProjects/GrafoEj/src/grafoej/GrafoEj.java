/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafoej;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class GrafoEj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Grafo grafo = new Grafo();
        Vertice Armenia = new Vertice("Armenia");
        Vertice Denver = new Vertice("Denver");
        Vertice Ontario = new Vertice("Ontario");
        Vertice Montevideo = new Vertice("Montevideo");
        Vertice Bogota = new Vertice("Bogota");
        Vertice Guadalajara = new Vertice("Guadalajara");
        Vertice Lima = new Vertice("Lima");
        Vertice Caracas = new Vertice("Caracas");

        grafo.AgregarVertice(Ontario);
        grafo.AgregarVertice(Armenia);
        grafo.AgregarVertice(Denver);
        grafo.AgregarVertice(Bogota);
        grafo.AgregarVertice(Guadalajara);
        grafo.AgregarVertice(Lima);
        grafo.AgregarVertice(Caracas);
        grafo.AgregarVertice(Montevideo);
        
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
        
        grafo.Imprimir();        
        
        ArrayList<String> recorridoBFS = grafo.BFS(0);
        for (String integer : recorridoBFS) {
            System.out.print(integer + ", ");
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("Ontario, Bogotá, Montevideo");
    }
    
}
