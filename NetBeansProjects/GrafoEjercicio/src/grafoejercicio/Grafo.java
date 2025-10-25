/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoejercicio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author vcardenass
 */
public class Grafo {

    private ArrayList<Vertice> Vertices;
    private int MatrizAdyacencia[][]; //Tiene 2 corchetes

    public Grafo() {
        this.Vertices = new ArrayList<>(); //yoyo = <>
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

    public ArrayList<String> caminoMasCorto(int inicio, int fin) {
        Queue<Integer> cola = new LinkedList<>();
        ArrayList<String> recorrido = new ArrayList<>();
        boolean[] visitados = new boolean[this.Vertices.size()];
        int[] padres = new int[this.Vertices.size()];

        boolean encontrado = false;

        visitados[inicio] = true;
        cola.offer(inicio);

        while (!cola.isEmpty() && !encontrado) {
            int actual = cola.poll();
            //recorrido.add(this.Vertices.get(actual).getDato());

            for (Vertice adyacente : this.Vertices.get(actual).getAdyacente()) {
                int indice = this.Vertices.indexOf(adyacente);
                if (!visitados[indice]) {
                    visitados[indice] = true;
                    cola.offer(indice);
                    padres[indice] = actual;
                    if (indice == fin) {
                        encontrado = true;
                        break;
                    }
                }
            }
        }
        if (encontrado) {
            int indice = fin;
            while (indice != inicio){
                recorrido.add(0, this.Vertices.get(indice).getDato());
                indice = padres[indice];
            }
            recorrido.add(0, this.Vertices.get(indice).getDato());
        }
        
        
        
        return recorrido;
    }

    public void Imprimir() {
        for (Vertice Vertice1 : Vertices) {
            System.out.println(Vertice1);
        }
        for (int i = 0; i < MatrizAdyacencia.length; i++) {
            for (int j = 0; j < MatrizAdyacencia.length; j++) {
                System.out.print(MatrizAdyacencia[i][j]);
            }
            System.out.println("");
        }

    }

    public ArrayList<Vertice> getVertices() {
        return Vertices;
    }

    public int[][] getMatrizAdyacencia() {
        return MatrizAdyacencia;
    }
}
