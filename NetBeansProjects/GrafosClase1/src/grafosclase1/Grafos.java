/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafosclase1;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Grafos {
    
    private ArrayList<Vertice> Vertices;
    private int MatrizAdyacencia[][];
    
    public Grafos() {
        this.Vertices = new ArrayList<>();
    }
    
    public void AgregarVertice(Vertice vertice) {
        this.Vertices.add(vertice);
    }
    
    public void ConectarVertice(Vertice vertice1, Vertice vertice2) {
        if (MatrizAdyacencia == null) {
            this.MatrizAdyacencia = new int[Vertices.size()][Vertices.size()];
        }
        
        vertice1.AgregarAdyacente(vertice2);
        vertice2.AgregarAdyacente(vertice1);
        
        MatrizAdyacencia[vertice1.getId()][vertice2.getId()] = 1;
        MatrizAdyacencia[vertice2.getId()][vertice1.getId()] = 1;
    }
    
    public void Imprimir() {
        for (Vertice vertice1 : Vertices) {
            System.out.println(vertice1);
        }
    }
    
}
