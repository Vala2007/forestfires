/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;
import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;
/**
 *
 * @author ABRAHAM
 */
public class Arbol {
    
    public Nodo raiz;
    
//    public void  agregarNodo(int dato){
//        Nodo nodo = new Nodo(dato);
//        if(raiz == null){
//            raiz = nodo;
//        }else{
//            agregarNodoRecursivo(raiz,nodo);
//        }
//    }
//    
//    public void agregarNodoRecursivo(Nodo nodo, Nodo nodo1){
//        if(nodo1.getDato() < nodo.getDato()){
//            if(nodo.getIzq() == null){
//                nodo.setIzq(nodo1);
//            }else{
//                agregarNodoRecursivo(nodo.getIzq(),nodo1);
//            }
//        }else{
//            if(nodo.getDer() == null){
//                nodo.setDer(nodo1);
//            }else{
//                agregarNodoRecursivo(nodo.getDer(),nodo1);
//            }
//        }
//    }
    
    public void imprimir(Nodo nodo, int nivel){
        if(nodo != null){
            imprimir(nodo.getDer(),nivel+1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("     ");
            }
            System.out.println(nodo.getDato());
            imprimir(nodo.getIzq(),nivel+1);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public void preorden_recursivo(Nodo nodo){
        if(nodo == null){
            return;
        }
        System.out.print(nodo.getDato());
        preorden_recursivo(nodo.getIzq());
        preorden_recursivo(nodo.getDer());
    }
    
    public void enorden_recursivo(Nodo nodo){
        if(nodo == null){
            return;
        }
        enorden_recursivo(nodo.getIzq());
        System.out.print(nodo.getDato());
        enorden_recursivo(nodo.getDer());
    }
    
    public void postorden_recursivo(Nodo nodo){
        if(nodo == null){
            return;
        }
        postorden_recursivo(nodo.getIzq());
        postorden_recursivo(nodo.getDer());
        System.out.print(nodo.getDato());
    }
    
    public void preorden_iterativo(Nodo nodo){
        Stack<Nodo> Pila = new Stack<>();
        Nodo P = nodo;
        do{
            if(P != null){
                System.out.print(P.getDato());
                inpila(Pila,P);
                P = P.getIzq();
            }else{ 
                P = verTope(Pila);
                canpila(Pila);
                P = P.getDer();
            }
        }while(P != null || !Pila.isEmpty());
    }   
    
    public void inorden_iterativo(Nodo nodo){
        Stack<Nodo> Pila = new Stack<>();
        Nodo P = nodo;
        do{
            if(P != null){
                inpila(Pila,P);
                P = P.getIzq();
            }else{ 
                P = verTope(Pila);
                canpila(Pila);
                System.out.print(P.getDato());
                P = P.getDer();
            }
        }while(P != null || !Pila.isEmpty());
    }   
        
    public void postorden_iterativo(Nodo nodo){
        Stack<Nodo> Pila = new Stack<>();
        Nodo P = nodo;
        Nodo q;
        Nodo ult= null;
        while (P != null || !Pila.isEmpty()) {
            if (P != null) {
                inpila(Pila, P);
                P = P.getIzq();
            } else {
                q = verTope(Pila);
                if (q.getDer() != null && ult != q.getDer()) {
                    P = q.getDer();
                } else {
                    System.out.print(q.getDato());
                    ult = q;    
                    canpila(Pila);  
                }
            }
        }
    }   
        
    
    public void inpila(Stack<Nodo> pila, Nodo elemento) {
        pila.push(elemento);
    } 
    public void canpila(Stack<Nodo> pila) {
        pila.pop();
    }
    public Nodo verTope(Stack<Nodo> pila) {
        return pila.peek();
    }

    
//    public int sumar(Nodo nodo){
//        if(nodo == null){
//            return 0;
//        }
//        return nodo.getDato()+sumar(nodo.getIzq())+sumar(nodo.getDer());
//    }
    
//    public Nodo buscar_nodo(Nodo nodo, int dato) {
//        if (nodo == null) {
//            return null; 
//        }
//        if (dato == nodo.getDato()) {
//            return nodo; 
//        }
//        if (dato < nodo.getDato()) {
//            return buscar_nodo(nodo.getIzq(), dato); 
//        } else {
//            return buscar_nodo(nodo.getDer(), dato); 
//        }
//    }
    
    public int altura_arbol(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return Math.max(altura_arbol(nodo.getIzq()), altura_arbol(nodo.getDer())) + 1;
    }
    
//    public Nodo buscar_padre(Nodo raiz, Nodo nodo) {
//        if (raiz == null || raiz == nodo) {
//            return null;
//        }
//        if (raiz.getIzq() == nodo || raiz.getDer() == nodo) {
//            return raiz; 
//        }
//        if (nodo.getDato() < raiz.getDato()) {
//            return buscar_padre(raiz.getIzq(), nodo);
//        } else {
//            return buscar_padre(raiz.getDer(), nodo);
//        }
//      }
    
//    public Nodo tio(Nodo raiz, Nodo nodo) {
//        Nodo padre = buscar_padre(raiz, nodo);
//        if (padre == null) {
//            return null; 
//        }
//        Nodo abuelo = buscar_padre(raiz, padre);
//        if (abuelo == null) {
//            return null; 
//        }
//
//        if (abuelo.getIzq() == padre) {
//            return abuelo.getDer();
//        } else {
//            return abuelo.getIzq();
//        }
//    }
    
    Scanner scanner = new Scanner(System.in);
    
    
    public int arbol_completo(Nodo nodo) {
        int altura = altura_arbol(nodo);
        return completo(nodo, 1, altura);
    }
    
    public int completo(Nodo nodo, int nivel, int altura) {

        if (nodo.getIzq() == null && nodo.getDer() != null) {
            return 0;
        }

        if (nodo.getIzq() != null && nodo.getDer() != null) {
            int izq = completo(nodo.getIzq(), nivel + 1, altura);
            if (izq == 0) {
                return 0;
            }
            int der = completo(nodo.getDer(), nivel + 1, altura);
            return der;
        }

        if (nodo.getIzq() != null && nodo.getDer() == null) {
            if (nivel + 1 == altura) {
                return 1; 
            } else {
                return 0;
            }
        }

        return 1;
    }
    
    public Nodo predecesor(Nodo nodo) {
        if (nodo.getIzq() == null) {
            return nodo;
        }
        return nodomayor(nodo.getIzq());
    }
    
    public Nodo sucesor(Nodo nodo) {
        if (nodo.getDer() == null) {
            return nodo;
        }
        return nodomenor(nodo.getDer());
    }
    
    public Nodo nodomayor(Nodo nodo) {
        while (nodo.getDer() != null) {
            nodo = nodo.getDer();
        }
        return nodo;
    }
    
    public Nodo nodomenor(Nodo nodo) {
        while (nodo.getIzq() != null) {
            nodo = nodo.getIzq();
        }
        return nodo;
    }
    
//    public void eliminar_nodo(int dato) {
//        raiz = eliminar(raiz, dato);
//    }   
//    
//        public Nodo eliminar(Nodo nodo, int dato) {
//        if (nodo == null) {
//            return null;
//        }
//
//        if (dato < nodo.getDato()) {
//            nodo.setIzq(eliminar(nodo.getIzq(), dato));
//        } else if (dato > nodo.getDato()) {
//            nodo.setDer(eliminar(nodo.getDer(), dato));
//        } else {
//
//            if (nodo.getIzq() == null && nodo.getDer() == null) {
//                return null;
//            }
//            else if (nodo.getIzq() == null) {
//                return nodo.getDer();
//            } else if (nodo.getDer() == null) {
//                return nodo.getIzq();
//            }
//            System.out.println("Usar predecesor o sucesor?");
//            System.out.println("1.Predecesor 2.Sucesor");
//            int caso3 = scanner.nextInt();
//            if (caso3 == 1) {
//                Nodo predecesor = nodomayor(nodo.getIzq());
//                nodo.setDato(predecesor.getDato());
//                nodo.setIzq(eliminar(nodo.getIzq(), predecesor.getDato()));
//                }
//            else {
//                Nodo sucesor = nodomenor(nodo.getDer());
//                nodo.setDato(sucesor.getDato());
//                nodo.setDer(eliminar(nodo.getDer(), sucesor.getDato()));
//                }
//               
//            }
//            return nodo;
//    }
    
    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
 
    public static void printTree(String[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.getDato();
        printTree(M, root.getIzq(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getDer(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }
 
    public void TreePrinter() {
        int h = altura_arbol(this.raiz);
        int col = getcol(h);
        String[][] M = new String[h][col];     
        printTree(M, this.raiz, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j]== null) {
                    System.out.print("  ");
                } else {
                    System.out.print(M[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    int i;
    
    public void diosmio(String[] In, String[] Pre) {
        i = 0;
        raiz = agregarNodoIn(In, Pre, 0, In.length - 1);
    }

    public Nodo agregarNodoIn(String[] In, String[] Pre, int iinicial, int ifinal) {
        if (iinicial > ifinal) { 
            return null;
        }

        Nodo nodo = new Nodo(Pre[i]);
        i++;

        if (iinicial == ifinal) { 
            return nodo;
        }

        int inI = indice(In, iinicial, ifinal, nodo.getDato());

        nodo.setIzq(agregarNodoIn(In, Pre, iinicial, inI- 1));
        nodo.setDer(agregarNodoIn(In, Pre, inI + 1, ifinal));

        return nodo;
    }

    public int indice (String[] In, int start, int end, String dato) {
        int k;
        for (k = start; k <= end; k++) {
            if (In[k].equals(dato)) { 
                return k;
            }
        }
        return -1;
    }
    
    

    
    
//    public int alturaa(Nodo nodo) {
//        if (nodo == null) {
//           return 0;
//        }
//
//        int altIzq = alturaa(nodo.getIzq());
//        int altDer = alturaa(nodo.getDer());
//
//        int mayor;
//        if (altIzq > altDer) {
//            mayor = altIzq;
//        } 
//        else {
//            mayor = altDer;
//        }
//
//        return mayor + 1;
//    }    
//    
    
//    public void agregarNodoIn(String dato){
//        Nodo nodo = new Nodo(dato);
//        if(raiz == null){
//            raiz = nodo;
//        }else{
//            agregarNodoInRecursivo(raiz,nodo);
//        }
//    }
//    
//    public void agregarNodoInRecursivo(Nodo nodo, Nodo nodo1){
//        if(nodo1.getDato().compareTo(nodo.getDato()) > 0){
//            if(nodo.getIzq() == null){
//                nodo.setIzq(nodo1);
//            }else{
//                agregarNodoInRecursivo(nodo.getIzq(),nodo1);
//            }
//        }else if (nodo1.getDato().compareTo(nodo.getDato()) < 0) {
//            if(nodo.getDer() == null){
//                nodo.setDer(nodo1);
//            }else{
//                agregarNodoInRecursivo(nodo.getDer(),nodo1);
//            }
//        }
//    }  
    
    

    
}
