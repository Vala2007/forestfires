/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalrec;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class FinalRec {

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
        
        BigInteger[][] matrizA = new BigInteger[n][n];
        procRec.generarMat(matrizA);
        BigInteger[][] transpuesta = procRec.transpuestaMatR(matrizA);
        BigInteger[][] matrizB = procRec.multMatR(matrizA, transpuesta);

        System.out.println("Matriz A:");
        procRec.imprimirMat(matrizA);
        System.out.println("Transpuesta de A:");
        procRec.imprimirMat(transpuesta);
        System.out.println("Matriz B (A x A^T):");
        procRec.imprimirMat(matrizB);

        long inicioRecursivo = System.nanoTime();
        BigInteger[][] resultadoRecursivo = procRec.Recursivo(matrizB, l);
        long finRecursivo = System.nanoTime();

        System.out.println("Resultado Recursivo (B^" + l + "):");
        procRec.imprimirMat(resultadoRecursivo);
        System.out.println("Tiempo Recursivo: " + (finRecursivo - inicioRecursivo) / 1e6 + " ms");

    }
        
    }
        
    
    

