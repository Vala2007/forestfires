/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coño.mano;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class CoñoMano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Leer el tamaño de la matriz
        System.out.print("Ingrese el tamaño de la matriz: ");
        int n = sc.nextInt();
        
        // Declarar la matriz
        int[][] A = new int[n][n];
        
        // Leer los valores de la matriz
        System.out.println("Ingrese los valores de la matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        
        // Realizar el intercambio de elementos
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int T = A[i][j];
                A[i][j] = A[n - j - 1][n - i - 1];
                A[n - j - 1][n - i - 1] = T;
            }
        }
        
        // Imprimir la matriz resultante
        System.out.println("Matriz después del intercambio:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        
        sc.close();
    }
    
}
