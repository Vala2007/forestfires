/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoarbolavl;

/**
 *
 * @author ASUS
 */
public class Nodo {
    
    private int dato;
    public Nodo der;
    public Nodo izq;
    public int Fe;
    

    public int getDato() {
        return dato;
    }
    
    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public int getFe() {
        return Fe;
    }

    public void setFe(int Fe) {
        this.Fe = Fe;
    }
    
    public Nodo (int dato) {
        this.dato = dato;
        der = izq = null;
        this.Fe = 1;
                
    }
    
}
