/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrices;
import java.util.Scanner;
     
/**
 *
 * @author ASUS
 */
public class matriz {
    int a[][];
    int n,m;
    
    public matriz(){
        a = new int[50][50];
        n=0;
        m=0;        
    }
    public void leer(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Escriba el tamaño de las filas");
        n = leer.nextInt();
        System.out.println("Escriba el tamaño de las columnas");
        m = leer.nextInt();
        int i,j;
        for (i=1;i<=n;i++){
            for (j=1;j<=m;j++){
                System.out.println("Escriba A["+i+","+j+"]");
                a[i][j] = leer.nextInt();
            }
        }
    }
    public void escribir(){
        int i,j;
        System.out.println("La matriz original es la siguiente");
        for (i=1;i<=n;i++){
            for (j=1;j<=m;j++){
                System.out.print(""+a[i][j]+"");                
            }
            System.out.println("");
        }
    }
    public int mayorelemento(){
        int i,j;
        
    }
}
