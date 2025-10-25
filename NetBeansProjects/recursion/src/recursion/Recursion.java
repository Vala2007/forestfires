/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursion;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*Scanner lea = new Scanner(System.in);
        System.out.println("Escriba el factorial que quiere obtener");
        int numero = lea.nextInt();
        ejemplos ej = new ejemplos();
        System.out.println("El factorial de "+numero+" es = "+ej.fact(numero));
        int ff = 1;
        ej.fact1(numero, 1);
        System.out.println("Factorial calculado con métodos que no retornan valor:");
        System.out.println("El factorial de "+numero+" es "+ej.f);
        System.out.println("Factorial calculado con un objeto:");
        datos obj = new datos();
        obj.factorial = 1;
        ej.fact2(numero,1,obj);
        System.out.println("El factorial de "+numero+" es "+obj.factorial);*/
        
        int a[] = new int[50];
        datos obj = new datos();
        ejemplos ej = new ejemplos();
        Scanner lea = new Scanner(System.in);
        System.out.println("Escriba el tamaño del vector");
        int n = lea.nextInt();
        ej.leer(1,n,a);
        System.out.println("El vector leído es el siguiente");
        ej.escv(1,n,a);
        ej.invertir(a, n, n, obj);
        System.out.println("El vector invertido es el siguiente");
        ej.escv(1,n,obj.v);
        ej.invertir1(a,n,1);
        
    }
    
}
