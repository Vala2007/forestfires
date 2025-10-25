/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafoej;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 */
public class Vertice {
    
    private String Dato;
    private ArrayList<Vertice> Adyacente;
    private int Id;
    static int cId;

    public ArrayList<Vertice> getAdyacente() {
        return Adyacente;
    }

    public void setAdyacente(ArrayList<Vertice> Adyacente) {
        this.Adyacente = Adyacente;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String Dato) {
        this.Dato = Dato;
    }

    public Vertice(String Dato) {
        this.Dato = Dato;
        this.Adyacente = new ArrayList<>();
        this.Id = cId++;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public static int getcId() {
        return cId;
    }

    public static void setcId(int cId) {
        Vertice.cId = cId;
    }
    
    public void Agregar_Ady(Vertice v){
        this.Adyacente.add(v);
    }    
    
    public String toString() {
        return "Vertice{" +
                "nombre='" + Dato + '\'' +
                ",adyacentes="+
                Adyacente.stream().map(Vertice::getDato).collect(Collectors.joining(", ")) + '}';
    }    
    
    
}
