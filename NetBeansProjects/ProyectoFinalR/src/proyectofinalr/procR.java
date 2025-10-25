/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalr;
import java.math.BigInteger;

/**
 *
 * @author ASUS
 */
public class procR {
    
   // Subrutina para generar una matriz NxN con valores aleatorios entre 1 y 9
    public static void generarMat(BigInteger[][] matriz) {
        int n = matriz.length; // Asume que la matriz ya está inicializada con dimensiones NxN
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
    
        // Caso base: si hemos recorrido toda la matriz, terminamos
        if (i == n) {
            return;
        }
    
        // Si hemos llegado al final de la fila, pasamos a la siguiente fila
        if (j == n) {
            transpuestaRecursivo(matriz, transpuesta, i + 1, 0);
            return;
        }
    
        // Realizamos la transposición (i, j) -> (j, i)
        transpuesta[j][i] = matriz[i][j];
    
        // Llamamos recursivamente para el siguiente elemento en la misma fila
        transpuestaRecursivo(matriz, transpuesta, i, j + 1);
    }
    
    public static BigInteger[][] multMatR(BigInteger[][] mat1, BigInteger[][] mat2) {
    int n = mat1.length;
    BigInteger[][] resultado = new BigInteger[n][n];
    // Inicializa la matriz resultado con ceros
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            resultado[i][j] = BigInteger.ZERO;
        }
    }
    // Llama al método recursivo
    multiplicarRecursivo(mat1, mat2, resultado, 0, 0, 0);
    return resultado;
}

    public static void multiplicarRecursivo(BigInteger[][] mat1, BigInteger[][] mat2, BigInteger[][] resultado, int i, int j, int k) {
        int n = mat1.length;

        // Caso base: si hemos recorrido todas las filas, terminamos
        if (i == n) {
            return;
        }

        // Si hemos terminado con una columna, pasa a la siguiente fila
        if (j == n) {
            multiplicarRecursivo(mat1, mat2, resultado, i + 1, 0, 0); // Pasa a la siguiente fila
            return;
        }

        // Si hemos terminado con los productos de una celda, pasa a la siguiente columna
        if (k == n) {
            multiplicarRecursivo(mat1, mat2, resultado, i, j + 1, 0); // Pasa a la siguiente columna
            return;
        }

        // Calcula y acumula el producto de los elementos
        resultado[i][j] = resultado[i][j].add(mat1[i][k].multiply(mat2[k][j]));

        // Llama recursivamente para el siguiente valor de k
        multiplicarRecursivo(mat1, mat2, resultado, i, j, k + 1);
}


    
    public static BigInteger[][] Recursivo(BigInteger[][] matrizB, int l) {
    if (l == 0) {
        // Retornar la matriz identidad si L = 0
        int n = matrizB.length;
        BigInteger[][] identidad = new BigInteger[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    identidad[i][j] = BigInteger.ONE;
                } else {
                    identidad[i][j] = BigInteger.ZERO;
                }
            }
        }
        return identidad;
    } else if (l == 1) {
        // Retornar la misma matriz si L = 1
        return matrizB;
    } else {
        // Multiplicar recursivamente
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
    

