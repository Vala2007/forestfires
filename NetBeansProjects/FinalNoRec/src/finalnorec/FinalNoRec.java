/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalnorec;
import java.util.Scanner;
import java.math.BigInteger;

/**
 *
 * @author ASUS
 */
public class FinalNoRec {

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
        procNoRec.generarMat(matrizA);
        BigInteger[][] transpuesta = procNoRec.transpuestaMatNR(matrizA);
        BigInteger[][] matrizB = procNoRec.multMatNR(matrizA, transpuesta);

        System.out.println("Matriz A:");
        procNoRec.imprimirMat(matrizA);
        System.out.println("Transpuesta de A:");
        procNoRec.imprimirMat(transpuesta);
        System.out.println("Matriz B (A x A^T):");
        procNoRec.imprimirMat(matrizB);

        long inicioNoRecursivo = System.nanoTime();
        BigInteger[][] resultadoNoRecursivo = procNoRec.NoRecursivo(matrizB, l);
        long finNoRecursivo = System.nanoTime();

        System.out.println("Resultado No Recursivo (B^" + l + "):");
        procNoRec.imprimirMat(resultadoNoRecursivo);
        System.out.println("Tiempo No Recursivo: " + (finNoRecursivo - inicioNoRecursivo) / 1e6 + " ms");

    }
        
    }
    

