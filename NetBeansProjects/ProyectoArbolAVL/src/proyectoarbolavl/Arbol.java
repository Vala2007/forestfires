/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoarbolavl;

/**
 *
 * @author ASUS
 */
public class Arbol {
   
    public Nodo raiz;
    public Nodo getRaiz() {
        return raiz;
    }
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
   
    public int altura_nodo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return Math.max(altura_nodo(nodo.getIzq()), altura_nodo(nodo.getDer())) + 1;
    }
    
    public int factor_equilibrio(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura_nodo(nodo.getIzq()) - altura_nodo(nodo.getDer());
    }
    
    public Nodo rotacion_derecha(Nodo y) {
        Nodo x = y.getIzq();
        Nodo temp = x.getDer();
        
        x.setDer(y);
        y.setIzq(temp);
        
        y.setFe(Math.max(altura_nodo(y.getIzq()), altura_nodo(y.getDer())) + 1);
        x.setFe(Math.max(altura_nodo(x.getIzq()), altura_nodo(x.getDer())) + 1);
        
        return x;
    }
    
    public Nodo rotacion_izquierda(Nodo x) {
        Nodo y = x.getDer();
        Nodo temp = y.getIzq();
        
        y.setIzq(x);
        x.setDer(temp);
        
        y.setFe(Math.max(altura_nodo(y.getIzq()), altura_nodo(y.getDer())) + 1);
        x.setFe(Math.max(altura_nodo(x.getIzq()), altura_nodo(x.getDer())) + 1);
        
        return y;
    }    
    
    public Nodo rotacion_der_izq(Nodo x) {
        Nodo y = x.getDer();
        Nodo z = y.getIzq();
        Nodo temp = z.getDer();
        Nodo temp2 = z.getIzq();
       
        z.setDer(y);
        x.setDer(z);
        y.setIzq(temp);
        
        z.setIzq(x);
        x.setDer(temp2);
        
        y.setFe(Math.max(altura_nodo(y.getIzq()), altura_nodo(y.getDer())) + 1);
        x.setFe(Math.max(altura_nodo(x.getIzq()), altura_nodo(x.getDer())) + 1);
        z.setFe(Math.max(altura_nodo(z.getIzq()), altura_nodo(z.getDer())) + 1);
        
        return z;
    } 
    
    public void insertar(int valor) {
        this.raiz = insertar(valor, this.raiz);
    }
    

    public Nodo insertar(int valor, Nodo nodo){
        if(nodo == null){
            Nodo new_nodo = new Nodo(valor);
            return new_nodo;        
        }
        if(valor < nodo.getDato()){
            nodo.setIzq(insertar(valor,nodo.getIzq()));
        }else if(valor > nodo.getDato()){
            nodo.setDer(insertar(valor,nodo.getDer()));            
        }else{
            return nodo;
        }
        nodo.setFe(Math.max(altura_nodo(nodo.getIzq()),altura_nodo(nodo.getDer())));
        
        int equilibrio = factor_equilibrio(nodo);
        int a = nodo.getDer() != null ? nodo.getDer().getDato() : 0;
        int b = nodo.getIzq() != null ? nodo.getIzq().getDato() : 0;
        if(equilibrio > 1 && valor < b){
            System.out.println("Rotación derecha");
            return rotacion_derecha(nodo);
        }
        if(equilibrio > 1 && valor > b){
            System.out.println("Rotación doble izquierda derecha");
            nodo.setIzq(rotacion_izquierda(nodo.getIzq()));
            return rotacion_derecha(nodo);
        }
        if(equilibrio < -1 && valor > a){
            System.out.println("Rotación izquierda");
            return rotacion_izquierda(nodo);
        }
        if(equilibrio < -1 && valor < a){
            System.out.println("Rotación doble derecha izquierda");
            nodo.setDer(rotacion_derecha(nodo.getDer()));
            return rotacion_izquierda(nodo);
        }
        
        return nodo;
    }

    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
 
    public static void printTree(int[][] M, Nodo root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.getDato();
        printTree(M, root.getIzq(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getDer(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }
    
    public void TreePrinter() {
    int h = altura_nodo(this.raiz);
    int col = getcol(h);
    int[][] M = new int[h][col];
    printTree(M, this.raiz, col / 2, 0, h);
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < col; j++) {
            if (M[i][j] == 0) {
                System.out.print("  ");
            } else {
                System.out.print(M[i][j] + " ");
            }
        }
        System.out.println();
    }
    }  
    
    public int alturaa(Nodo nodo) {
        if (nodo == null) {
           return 0;
        }

        int altIzq = alturaa(nodo.getIzq());
        int altDer = alturaa(nodo.getDer());

        int mayor;
        if (altIzq > altDer) {
            mayor = altIzq;
        } 
        else {
            mayor = altDer;
        }

        return mayor + 1;
    } 

    
    public Nodo delete(Nodo root, int dato) {
        
        if (root == null) {
            return root;
        }

        if (dato < root.getDato()) {
            root.setIzq(delete(root.getIzq(), dato));
        } else if (dato > root.getDato()) {
            root.setDer(delete(root.getDer(), dato));
        } else {
            // Nodo con un solo hijo o sin hijos
            if (root.getIzq() == null) {
                return root.getDer();
            } else if (root.getDer() == null) {
                return root.getIzq();
            }

            // Nodo con dos hijos: obtener el sucesor en orden
            root.setDato(minValue(root.getDer()));

            // Eliminar el sucesor en orden
            root.setDer(delete(root.getDer(), root.getDato()));
        }
        
        Nodo nodo = root;
        // Actualizar altura y balance
        int setAltura = (Math.max(alturaa(root.getIzq()), alturaa(root.getDer())) + 1 );
        int balance = factor_equilibrio(root);

        // Rebalancear el árbol
        int equilibrio = factor_equilibrio(nodo);
        int a = nodo.getDer() != null ? nodo.getDer().getDato() : 0;
        int b = nodo.getIzq() != null ? nodo.getIzq().getDato() : 0;
        if(equilibrio > 1 && dato < b){
            System.out.println("Rotación derecha");
            return rotacion_derecha(nodo);
        }
        if(equilibrio > 1 && dato > b){
            System.out.println("Rotación doble izquierda derecha");
            nodo.setIzq(rotacion_izquierda(nodo.getIzq()));
            return rotacion_derecha(nodo);
        }
        if(equilibrio < -1 && dato > a){
            System.out.println("Rotación izquierda");
            return rotacion_izquierda(nodo);
        }
        if(equilibrio < -1 && dato < a){
            System.out.println("Rotación doble derecha izquierda");
            nodo.setDer(rotacion_derecha(nodo.getDer()));
            return rotacion_izquierda(nodo);
        }    
        
        return root;
    }

    public int minValue(Nodo nodo) {
        int minValue = nodo.getDato();
        while (nodo.getIzq() != null) {
            minValue = nodo.getIzq().getDato();
            nodo = nodo.getIzq();
        }
        return minValue;
    }
        
}    



