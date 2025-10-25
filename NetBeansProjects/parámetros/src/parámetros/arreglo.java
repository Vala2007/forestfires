/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parámetros;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class arreglo {
    
    public int leer(int vec[]){
        Scanner lea = new Scanner(System.in);
        System.out.println("Escriba el tamaño del arreglo");
        int t;
        t = lea.nextInt();
        int i;
        for (i=1; i<=t; i++){
            System.out.println("Ingrese vec["+i+"]");
            vec[i] = lea.nextInt();
        }   
        return t;
    }
    
    public void esc(int t, int vec[]){
        int i=0;
        System.out.println("El vector es el siguiente: ");
        for (i=1; i<=t; i++){
            System.out.println(""+vec[i]);
        }
        System.out.println("");
    }
    
     public objeto leer1(int vec[]){
        Scanner lea = new Scanner(System.in);
        System.out.println("Escriba el tamaño del arreglo");
        int t;
        t = lea.nextInt();
        int i;
        for (i=1; i<=t; i++){
            System.out.println("Ingrese vec["+i+"]");
            vec[i] = lea.nextInt();
        }   
        objeto o = new objeto(t,vec);
        return o;
}
