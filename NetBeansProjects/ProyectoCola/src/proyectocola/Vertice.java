/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocola;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
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

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public ArrayList<Vertice> getAdyacente() {
        return Adyacente;
    }

    public void setAdyacente(ArrayList<Vertice> Adyacente) {
        this.Adyacente = Adyacente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCid() {
        return cid;
    }

    public static void setCid(int cid) {
        Vertice.cid = cid;
    }
    
    public void AgregarAdyacente(Vertice vertice) {
        this.Adyacente.add(vertice);
    }
    
    public String toString() {
        return "Vertice{" +
                "nombre='" + dato + '\'' +
                ",adyacentes="+
                Adyacente.stream().map(Vertice::getDato).collect(Collectors.joining(", "))+ '}';
    }
    
    
    
}
