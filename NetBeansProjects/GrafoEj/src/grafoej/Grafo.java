/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoej;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ASUS
 */
public class Grafo {

    private ArrayList<Vertice> Vertices;
    private int MatrizAdyacencia[][];
    
    public Grafo(){
        this.Vertices = new ArrayList<>();
    }
    
    public void AgregarVertice(Vertice vertice){
        this.Vertices.add(vertice);
    }
    
    public void ConectarVertice(Vertice vertice1, Vertice vertice2){
        if (MatrizAdyacencia == null) {
            this.MatrizAdyacencia = new int[Vertices.size()][Vertices.size()];
            
        }
        
        vertice1.Agregar_Ady(vertice2);
        vertice2.Agregar_Ady(vertice1);
        
        MatrizAdyacencia[vertice1.getId()][vertice2.getId()] = 1;
        MatrizAdyacencia[vertice2.getId()][vertice1.getId()] = 1;
    }
    
    public void Imprimir(){
        for(Vertice vertice1 : Vertices){
            System.out.println(vertice1);
        }
        for (int i = 0; i < MatrizAdyacencia.length; i++) {
            for (int j=0; j < MatrizAdyacencia.length; j++) {
                System.out.print(MatrizAdyacencia[i][j]);
            }
            System.out.println("");
        }
    }
    
    public ArrayList<String> BFS(int inicio) {
        Queue<Integer> cola = new LinkedList<>();
        ArrayList<String> recorrido = new ArrayList<>();
        boolean[] visitados = new boolean[this.Vertices.size()];
        
        
        visitados[inicio] = true;
        cola.offer(inicio);
        
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            recorrido.add(this.Vertices.get(actual).getDato());
        
            for (Vertice adyacente : this.Vertices.get(actual).getAdyacente()) {
                int indice = this.Vertices.indexOf(adyacente);
                if (!visitados[indice]) {
                    
                    visitados[indice] = true;
                    cola.offer(indice);
            }
        }
        }
        return recorrido;
                
    }
    

    
}
