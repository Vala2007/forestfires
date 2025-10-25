/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafosclase1;

/**
 *
 * @author ASUS
 */
public class GrafosClase1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Grafos red = new Grafos();
        Vertice pc1 = new Vertice("pc1");
        Vertice pc2 = new Vertice("pc2");
        Vertice pc3 = new Vertice("pc3");
        Vertice pc4 = new Vertice("pc4");
        Vertice pc5 = new Vertice("pc5");
        
        red.AgregarVertice(pc1);
        red.AgregarVertice(pc2);
        red.AgregarVertice(pc3);
        red.AgregarVertice(pc4);
        red.AgregarVertice(pc5);
        
        red.ConectarVertice(pc1, pc2);
        red.ConectarVertice(pc1, pc5);
        red.ConectarVertice(pc3, pc4);
        red.ConectarVertice(pc5, pc4);
        red.ConectarVertice(pc5, pc2);
        
        red.Imprimir();
        
    }
    
}
