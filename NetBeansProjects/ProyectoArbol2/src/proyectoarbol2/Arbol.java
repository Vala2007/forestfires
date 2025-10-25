/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoarbol2;

/**
 *
 * @author ASUS
 */
public class Arbol {

    private Nodo raiz;

    public void agregar_nodo(int dato) {
        Nodo nodo = new Nodo(dato);
        if (raiz == null) {
            raiz = nodo;
        } else {
            agregarnodo_recursivo(raiz, nodo);
        }
    }

    public void agregarnodo_recursivo(Nodo nodo1, Nodo nodo2) {
        if (nodo2.getDato() < nodo1.getDato()) {
            if (nodo1.getIzq() == null) {
                nodo1.setIzq(nodo2);
            } else {
                agregarnodo_recursivo(nodo1.getIzq(), nodo2);
            }
        } else {
            if (nodo1.getDer() == null) {
                nodo1.setDer(nodo2);
            } else {
                agregarnodo_recursivo(nodo1.getDer(), nodo2);
            }
        }
    }

    public void imprimir(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimir(nodo.getDer(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("    ");
            }
            System.out.println(nodo.getDato());
            imprimir(nodo.getIzq(), nivel + 1);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void preorden_recursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.print(nodo.getDato());
        preorden_recursivo(nodo.getIzq());
        preorden_recursivo(nodo.getDer());
    }

    public void enorden_recursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        enorden_recursivo(nodo.getIzq());
        System.out.print(nodo.getDato());
        enorden_recursivo(nodo.getDer());
    }

    public void postorden_recursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        postorden_recursivo(nodo.getIzq());
        postorden_recursivo(nodo.getDer());
        System.out.print(nodo.getDato());
    }

}
