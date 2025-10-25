/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ejemplos {
    int f = 1;
    Scanner lea = new Scanner(System.in);
    
    public ejemplos(){
        
    }
    public int fact(int num){
        if (num == 0)
            return 1;
        else
            return (num*fact(num-1));
    }
    public void fact1(int num, int i){
        if (i<=num){
            f=f*i;
            fact1(num, i+1);
        }
        
    }
    public void fact2(int num, int i, datos o){
        if (i<=num){
            o.factorial = o.factorial*i;
            fact2(num, i+1, o);
        }
        
    }
    public void leer(int i, int t, int v[]){
        if (i<=t){
            System.out.println("Escriba v["+i+"]");
            v[i] = lea.nextInt();
            leer(i+1, t, v);
        }
    }
    public void escv(int i, int t, int v[]){
        if (i<=t){
            System.out.println(""+v[i]);
            escv(i+1, t, v);
        }
    }
    public void invertir(int v1[], int t, int i, datos o){
        if (i>=1){
            o.v[t-i+1] = v1[i];
            invertir(v1, t, i-1, o);
        }
    }
    public void invertir1(int v1[], int t, int i){
        int temp;
        if (i>=t/2){
            temp = v1[i];
            v1[i] = v1[t-i+1];
            v1[t-i+1] = temp;
            invertir1(v1, t, i+1);
        }
    }
    
}
