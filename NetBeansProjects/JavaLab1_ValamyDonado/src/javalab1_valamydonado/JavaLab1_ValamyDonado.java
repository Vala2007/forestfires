/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javalab1_valamydonado;

import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author vgorut
 */
public class JavaLab1_ValamyDonado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Hola, ¿cuál es tu nombre?");
      String nombre = sc.nextLine();
 
      System.out.println("Bienvenido, " + nombre + ", calculemos tu liquidación" );
      System.out.println("Digita tu salario mensual");
      int salario = sc.nextInt();
      System.out.println("Digita la cantidad de días trabajados");
      int díastrab = sc.nextInt();
      
      double cesantías;
      double intcesant;
      double primaserv;
      double vacaciones;
      double liquidación;
      double retención;
      
      cesantías = ((salario*díastrab)/360);
      intcesant = ((cesantías*díastrab*0.12)/360);
      primaserv = ((salario*díastrab)/360);
      vacaciones = ((salario*díastrab)/720);
      liquidación = (cesantías + intcesant + primaserv + vacaciones);
      retención = (liquidación - ((liquidación)*0.05));
      
      System.out.println("El valor total de tus cesantías es: $" + cesantías);
      System.out.println("El valor total de tus intereses sobre cesantías es: $" + intcesant);
      System.out.println("El valor total de tu prima de servicios es: $" + primaserv);
      System.out.println("El valor total de tus vacaciones es: $" + vacaciones);
      System.out.println("El valor total de tu liquidación es: $" + liquidación);
      System.out.println("El valor total de tu liquidación menos la retención es: $" + retención);
      System.out.println("Un placer, " + nombre);
  
    }
    
}
