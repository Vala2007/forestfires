/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tristeza;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class MatrizCuadrantes {
    
     // Genera una matriz de tamaño 2N x 2N con valores de ejemplo
    public static int[][] generarMatriz(int tamaño) {
        int[][] matriz = new int[tamaño][tamaño];
        int valor = 1;
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = valor++;
            }
        }
        return matriz;
    }

    // Suma de la diagonal principal del cuadrante dado
    public static int sumaDiagonalPrincipalCuadrante(int[][] matriz, int N, int cuadrante) {
        int suma = 0;
        int inicioFila = (cuadrante == 3 || cuadrante == 4) ? N : 0;
        int inicioColumna = (cuadrante == 2 || cuadrante == 4) ? N : 0;

        for (int i = 0; i < N; i++) {
            suma += matriz[inicioFila + i][inicioColumna + i];
        }
        return suma;
    }

    // Verifica si un número es perfecto
    public static boolean esNumeroPerfecto(int numero) {
        int sumaDivisores = 0;
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }
        return sumaDivisores == numero;
    }

    // Cuenta cuántos elementos del cuadrante están en la serie dada
    public static int contarElementosEnSerie(int[][] matriz, int N, int cuadrante) {
        int[] serie = {1, 4, 7, 8, 9, 13, 20, 28, 37, 50, 70, 98};
        int contador = 0;
        int inicioFila = (cuadrante == 3 || cuadrante == 4) ? N : 0;
        int inicioColumna = (cuadrante == 2 || cuadrante == 4) ? N : 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int valor = matriz[inicioFila + i][inicioColumna + j];
                if (perteneceASerie(valor, serie)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // Verifica si un número pertenece a la serie
    public static boolean perteneceASerie(int numero, int[] serie) {
        for (int num : serie) {
            if (num == numero) {
                return true;
            }
        }
        return false;
    }

    // Calcula la norma de un cuadrante
    public static int normaCuadrante(int[][] matriz, int N, int cuadrante) {
        int suma = 0;
        int inicioFila = (cuadrante == 3 || cuadrante == 4) ? N : 0;
        int inicioColumna = (cuadrante == 2 || cuadrante == 4) ? N : 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                suma += Math.abs(matriz[inicioFila + i][inicioColumna + j]);
            }
        }
        return suma;
    }
    
    
    
}
