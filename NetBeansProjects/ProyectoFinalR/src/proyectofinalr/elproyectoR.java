/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinalr;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ProyectoFinalR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner lea = new Scanner(System.in);
        
        System.out.println("Ingrese el tamaño n de la matriz");
        int n = lea.nextInt();
        System.out.println("Ingrese la potencia L");
        int l = lea.nextInt();
        
        // Generar matriz A y calcular B = A x A^T
        BigInteger[][] matrizA = new BigInteger[n][n];
        procR.generarMat(matrizA);
        BigInteger[][] transpuesta = procR.transpuestaMatR(matrizA);
        BigInteger[][] matrizB = procR.multMatR(matrizA, transpuesta);

        System.out.println("Matriz A:");
        procR.imprimirMat(matrizA);

        System.out.println("Transpuesta de A:");
        procR.imprimirMat(transpuesta);

        System.out.println("Matriz B (A x A^T):");
        procR.imprimirMat(matrizB);

        // Calcular B^L de forma recursiva
        long inicioRecursivo = System.nanoTime();
        BigInteger[][] resultadoNoRecursivo = procR.Recursivo(matrizB, l);
        long finRecursivo = System.nanoTime();

        System.out.println("Resultado Recursivo (B^" + l + "):");
        procR.imprimirMat(resultadoNoRecursivo);
        System.out.println("Tiempo Recursivo: " + (finRecursivo - inicioRecursivo) / 1e6 + " ms");

    }
        
    }
    
