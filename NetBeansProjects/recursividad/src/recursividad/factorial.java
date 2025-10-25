/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursividad;

/**
 *
 * @author ASUS
 */
public class factorial {
    
    public double fact(double n){
        if(n>0)
            return(n*fact(n-1));
        else 
            return 1;
    }
    
    
}
