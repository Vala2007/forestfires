/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author ASUS
 */
public class Arbol {
    private Nodo raíz;
    
    private void agregar_nodo(char Dato){
        Nodo nodo = new Nodo(Dato);
        if(raíz == null){
            raíz = nodo;
        }
        else{
            agregar_recursivo(raíz, nodo);
        }
    }
    
    private void agregar_recursivo(Nodo nodo, Nodo nuevo_nodo){
        if(nuevo_nodo.getDato() < nodo.getDato()){
            if(nodo.getIzq() == null){
                nodo.setIzq(nuevo_nodo);
            }
            else{
                agregar_recursivo(nodo.getIzq(), nuevo_nodo)
            }
        else{
            if(nodo.getDer() == null){
                nodo.setDer(nuevo_nodo);
            }
            else{
                
                }
            }
        }
    }
    
}
