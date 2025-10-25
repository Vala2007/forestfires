/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;
import java.math.BigInteger;

/**
 *
 * @author ASUS
 */
public class procNR {
    

    public static void generarMat(BigInteger[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j];
            }
        }
    }
    

    public static BigInteger[][] transpuestaMatNR(BigInteger[][] matriz) {
        int n = matriz.length;
        BigInteger[][] transpuesta = new BigInteger[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }
    

    public static BigInteger[][] multMatNR(BigInteger[][] mat1, BigInteger[][] mat2) {
        int n = mat1.length;
        BigInteger[][] resultado = new BigInteger[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = BigInteger.ZERO;
                for (int k = 0; k < n; k++) {
                    resultado[i][j] = resultado[i][j].add(mat1[i][k].multiply(mat2[k][j]));
                }
            }
        }
        return resultado;
    }
    
    public static BigInteger[][] NoRecursivo(BigInteger[][] matrizB, int l) {
    int n = matrizB.length;
    BigInteger[][] resultado = new BigInteger[n][n];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) {
               resultado[i][j] = BigInteger.ONE;
          } else {
               resultado[i][j] = BigInteger.ZERO;
        }
        }
    }
    for (int i = 0; i < l; i++) {
        resultado = multMatNR(resultado, matrizB);
    }
    return resultado;
    }
    

    public static void imprimirMat(BigInteger[][] matriz) {
    for (int i = 0; i < matriz.length; i++) { 
        for (int j = 0; j < matriz[i].length; j++) { 
            System.out.print(matriz[i][j] + "  "); 
        }
        System.out.println(); 
        }
    System.out.println(); 
    }
}
    


