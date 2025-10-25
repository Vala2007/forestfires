/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package havelhakimi;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class HavelHakimi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner leer = new Scanner(System.in);
        
        int i,j,n,t,tamaño,grado;

        System.out.println("Introduce la cantidad de grados en la secuencia:");
        n = leer.nextInt();

        int[] secuencia = new int[n+1];

        System.out.println("Introduce los grados en la secuencia:");
        for (i=1; i<=n; i++) {
            secuencia[i] = leer.nextInt();
            }

        while (true) {

            tamaño = 0;
            for (i=1; i<=n; i++) {
                if (secuencia[i] != 0) {
                    secuencia[i] = secuencia[tamaño++];
                }
            }
            n = tamaño;

            if (n == 0) {
                System.out.println("La secuencia es gráfica");                
                break;
            }

            for (i=1; i<=n-1; i++) {
                for (j=1; j<=n-i-1; j++) {
                    if (secuencia[j] <= secuencia[j+1]) {
                        t = secuencia[j];
                        secuencia[j] = secuencia[j+1];
                        secuencia[j+1] = t;
                    }
                }
            }
            
            grado = secuencia[1];
            for (i=1; i<=n-1; i++) {
                secuencia[i] = secuencia[i+1];
            }
            n--;

            if (grado > n) {
                System.out.println("La secuencia no es gráfica");
                break;
            }

            for (i=1; i<=grado; i++) {
                secuencia[i]--;
                if (secuencia[i] < 0) {
                    System.out.println("La secuencia no es gráfica");
                    break;
                }
            }
        }     
    }
}

        
    
    

