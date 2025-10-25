/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoejercicio;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author vcardenass
 */
public class Vertice {
    private String dato;
    private ArrayList<Vertice> Adyacente;
    private int id;
    static int cid;

    public Vertice(String dato) {
        this.dato = dato;
        this.Adyacente = new ArrayList<>();
        this.id = cid++;

    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public void setAdyacente(ArrayList<Vertice> Adyacente) {
        this.Adyacente = Adyacente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setCid(int cid) {
        Vertice.cid = cid;
    }

    public String getDato() {
        return dato;
    }

    public ArrayList<Vertice> getAdyacente() {
        return Adyacente;
    }

    public int getId() {
        return id;
    }

    public static int getCid() {
        return cid;
    }

    public void AgregarAdyacente(Vertice vertice) {
        this.Adyacente.add(vertice);
    }

    public String toString() {
        return "Vertice{"
                + "Nombre='" + dato + '\''
                + "   ,adyacentes="
                + Adyacente.stream().map(Vertice::getDato).collect(Collectors.joining(", ")) + '}';
    }//Tarea investigar  + Adyacente.stream().map(Vertice::getDato).collect(Collectors.joining(", ")) + '}';
}
