/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tristeza;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Tristeza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int N = 2; // Tamaño de la matriz 2N x 2N
        int[][] matriz = MatrizCuadrantes.generarMatriz(2 * N);

        // Calcular la suma de la diagonal principal del cuadrante III
        int sumaDiagonalIII = MatrizCuadrantes.sumaDiagonalPrincipalCuadrante(matriz, N, 3);

        if (MatrizCuadrantes.esNumeroPerfecto(sumaDiagonalIII)) {
            // Si es un número perfecto, contar elementos de la serie en el cuadrante II
            int elementosSerieEnII = MatrizCuadrantes.contarElementosEnSerie(matriz, N, 2);
            System.out.println("Número de elementos en el cuadrante II que están en la serie: " + elementosSerieEnII);
        } else {
            // Si no es perfecto, calcular B = ||III|| - (||I - IV||)
            int normaIII = MatrizCuadrantes.normaCuadrante(matriz, N, 3);
            int normaIV = MatrizCuadrantes.normaCuadrante(matriz, N, 4);
            int normaI = MatrizCuadrantes.normaCuadrante(matriz, N, 1);
            int B = normaIII - (normaI - normaIV);
            System.out.println("Valor de B: " + B);
        }
    }
        
        
    }
    

