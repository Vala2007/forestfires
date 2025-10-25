/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursividad;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Recursividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        factorial f = new factorial();
        Scanner lea = new Scanner(System.in);
        System.out.println("Escriba el número");
        double num = lea.nextDouble();
        System.out.println("El factorial de "+num+" es = "+f.fact(num));     
        
        
    }
    
}
