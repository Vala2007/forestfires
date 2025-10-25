/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jiji;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Jiji {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int i, sum, m, n;
        System.out.println("Escriba el tamaño del arreglo");
        n = leer.nextInt();
        int A[] = new int[n+1];
        int B[] = new int[n+1];
        
        for (i=1;i<=n;i++) {
            System.out.println("Escriba A["+i+"]");
            A[i] = leer.nextInt();
        }
    
        sum = 0;
        for(i=1;i<=n;i++) {
            sum = sum + A[i];            
        }
        System.out.println("La suma es "+sum);
        
        int sw = 0;
        if (sum>=1) {
            i=2;
            while (i<sum && sw==0) {
                if ((sum % i) == 0) {
                    sw = 1;
                }
                else {
                    sw = 0;
                }
                i++;
            }     
        }
        else 
            sw = 1;
        
        if (sw==0)
            System.out.println("Es primo");
        else 
            System.out.println("No es primo");
        
        if (sw==0) {
            m=1;
            for (i=1;i<=n+1;i++) {
                if (i%2 == 0) {
                    B[m]=A[i];
                }
            }
        }
        else {
            m=1;
            for (i=1;i<=n+1;i++) {
                if (A[i]%2 != 0) {
                    B[m]=A[i];
                    m++;
                }
            }
        }
    }
    
}
