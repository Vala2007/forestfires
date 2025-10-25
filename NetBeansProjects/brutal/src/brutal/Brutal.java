/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package brutal;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Brutal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int n,m,i;
        Scanner leer = new Scanner(System.in);
        System.out.println("Escriba el tamaño del arreglo A");
        n = leer.nextInt();
        System.out.println("Escriba el tamaño del arreglo B");
        m = leer.nextInt();
        int A[] = new int[n+1];
        int B[] = new int[n+1];
        
        for (i=1;i<=n;i++) {
            System.out.println("Escriba A["+i+"]");
            A[i] = leer.nextInt();
        }
        
    }
    
}
