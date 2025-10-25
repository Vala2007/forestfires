/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jiji;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class arreglos {
    int A[];
    int B[];
    int n,k,sum,i;
    
    public void leervector() {
        Scanner leer = new Scanner(System.in);
        for (i=1;i<=n;i++) {
            System.out.println("Escriba A["+i+"]");
            A[i] = leer.nextInt();
        }
    }
    
    public int sumar() {
        sum = 0;
        for(i=1;i<=n;i++) 
            sum = sum + A[i];
        return sum;   
    }
}
    
