/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectfinalr;
import java.math.BigInteger;


/**
 *
 * @author ASUS
 */
public class procR {
    

    public static void generarMat(BigInteger[][] matriz) {
        int n = matriz.length; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = BigInteger.valueOf((int) (Math.random() * 9 + 1));
            }
        }
    }
    
    public static BigInteger[][] transpuestaMatR(BigInteger[][] matriz) {
    int n = matriz.length;
    BigInteger[][] transpuesta = new BigInteger[n][n];
    transpuestaRecursivo(matriz, transpuesta, 0, 0); 
    return transpuesta;
}

    public static void transpuestaRecursivo(BigInteger[][] matriz, BigInteger[][] transpuesta, int i, int j) {
        int n = matriz.length;
    
        if (i == n) {
            return;
        }
    
        if (j == n) {
            transpuestaRecursivo(matriz, transpuesta, i + 1, 0);
            return;
        }
    
        transpuesta[j][i] = matriz[i][j];
        transpuestaRecursivo(matriz, transpuesta, i, j + 1);
    }
    
    public static BigInteger[][] multMatR(BigInteger[][] mat1, BigInteger[][] mat2) {
    int n = mat1.length;
    BigInteger[][] resultado = new BigInteger[n][n];

    multiplicarRecursivo(mat1, mat2, resultado, 0, 0, 0);

    return resultado;
}

    public static void multiplicarRecursivo(BigInteger[][] mat1, BigInteger[][] mat2, BigInteger[][] resultado, int i, int j, int k) {
        int n = mat1.length;
        
        if (i == n) {
            return;
        }
        if (j == n) {
            multiplicarRecursivo(mat1, mat2, resultado, i + 1, 0, 0);
            return;
        }       
        if (k == n) {
            multiplicarRecursivo(mat1, mat2, resultado, i, j + 1, 0); 
            return;
        }        
        if (resultado[i][j] == null) {
        resultado[i][j] = BigInteger.ZERO;
        }
        
        resultado[i][j] = resultado[i][j].add(mat1[i][k].multiply(mat2[k][j]));        
        multiplicarRecursivo(mat1, mat2, resultado, i, j, k + 1);
}

    public static BigInteger[][] generarIdentidad(int n, int i, int j, BigInteger[][] identidad) {
        if (i == n) {
            return identidad;
        }
        if (j == n) {
            return generarIdentidad(n, i + 1, 0, identidad);
        }
        if (i == j) {
            identidad[i][j] = BigInteger.ONE;
        } 
        else {
            identidad[i][j] = BigInteger.ZERO; 
}
        return generarIdentidad(n, i, j + 1, identidad);
    }
    
    public static BigInteger[][] Recursivo(BigInteger[][] matrizB, int l) {
     
        if (l == 0) {
            int n = matrizB.length;
            return generarIdentidad(n, 0, 0, new BigInteger[n][n]);
        }
        else if (l == 1) {
            return matrizB;
        }
        else {
            return multMatR(matrizB, Recursivo(matrizB, l - 1));
        }
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
