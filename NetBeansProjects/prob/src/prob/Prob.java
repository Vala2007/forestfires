/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prob;

/**
 *
 * @author ASUS
 */
public class Prob {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Definición de los intervalos
        int[] intervaloMin = {22, 26, 30, 34, 38, 42};
        int[] intervaloMax = {26, 30, 34, 38, 42, 46};
        
        // Puntos medios (xi)
        double[] puntosMedios = {24, 28, 32, 36, 40, 44};
        
        // Frecuencias absolutas (fi)
        int[] frecuencia = {12, 8, 8, 1, 0, 1};  // Total suma 30
        
        // Variables para la media
        double sumaFrecuenciaPorPuntoMedio = 0;
        int totalDatos = 30;
        int modaIndice = 0;
        int frecuenciaMaxima = frecuencia[0];
        
        // Arreglos para almacenar resultados
        int[] frecuenciaAcumulada = new int[frecuencia.length];
        double[] frecuenciaRelativa = new double[frecuencia.length];
        double[] frecuenciaRelativaAcumulada = new double[frecuencia.length];
        double[] desviacionMedia = new double[frecuencia.length];
        double[] frecuenciaPorDesviacion = new double[frecuencia.length];
        double[] frecuenciaPorPuntoMedio = new double[frecuencia.length];
        double[] frecuenciaPorDesviacionCuadrado = new double[frecuencia.length]; // Nuevo arreglo para fi * di^2
        
        double media = 0.0;  // Inicializar la media
        
        // Cálculo de la frecuencia acumulada, relativa y otros valores
        for (int i = 0; i < frecuencia.length; i++) {
            // Frecuencia acumulada
            if (i == 0) {
                frecuenciaAcumulada[i] = frecuencia[i];
            } else {
                frecuenciaAcumulada[i] = frecuenciaAcumulada[i - 1] + frecuencia[i];
            }
            
            // Frecuencia relativa
            frecuenciaRelativa[i] = (double) frecuencia[i] / totalDatos;
            
            // Frecuencia relativa acumulada
            if (i == 0) {
                frecuenciaRelativaAcumulada[i] = frecuenciaRelativa[i];
            } else {
                frecuenciaRelativaAcumulada[i] = frecuenciaRelativaAcumulada[i - 1] + frecuenciaRelativa[i];
            }
            
            // Desviación media (di) como valor absoluto de la diferencia con la media
            desviacionMedia[i] = i;  // di = xi - media
            frecuenciaPorDesviacion[i] = frecuencia[i] * desviacionMedia[i];  // fi * di
            frecuenciaPorDesviacionCuadrado[i] = frecuencia[i] * Math.pow(desviacionMedia[i], 2);  // fi * di^2
            
            // Producto de fi * xi para cálculo de la media
            frecuenciaPorPuntoMedio[i] = frecuencia[i] * puntosMedios[i];
            sumaFrecuenciaPorPuntoMedio += frecuenciaPorPuntoMedio[i];
            
            if (frecuencia[i] > frecuenciaMaxima) {
                frecuenciaMaxima = frecuencia[i];
                modaIndice = i;
            }
        }

        // Cálculo de la media
        media = sumaFrecuenciaPorPuntoMedio / totalDatos;
        
        
        // Impresión de la tabla ajustada
        System.out.println("Intervalo\t x_i\t f_i\t F_i\t f_ri\t F_ri\t d_i\t f_i * d_i  f_i * d_i^2\t f_i * x_i");
        for (int i = 0; i < frecuencia.length; i++) {
            System.out.printf("[%d - %d]\t %.2f\t %d\t %d\t %.3f\t %.3f\t %.2f\t %.2f\t    %.2f\t %.2f%n", 
                intervaloMin[i], intervaloMax[i], puntosMedios[i], frecuencia[i], frecuenciaAcumulada[i], 
                frecuenciaRelativa[i], frecuenciaRelativaAcumulada[i], desviacionMedia[i], 
                frecuenciaPorDesviacion[i], frecuenciaPorDesviacionCuadrado[i], frecuenciaPorPuntoMedio[i]);
        }
        
        // Resultados adicionales
        System.out.println("\nMedia: " + String.format("%.2f", media));
        int intervaloModa = modaIndice;
        double Lm = intervaloMin[intervaloModa];
        double Um = intervaloMax[intervaloModa];
        int fm = frecuencia[intervaloModa];
        int fm1 = (intervaloModa > 0) ? frecuencia[intervaloModa - 1] : 0;
        int fm2 = (intervaloModa < frecuencia.length - 1) ? frecuencia[intervaloModa + 1] : 0;
        double w = Um - Lm;
        
        double moda = Lm + ((fm - fm1) / (2.0 * fm - fm1 - fm2)) * w;
        System.out.println("Moda: " + String.format("%.0f", moda));
        
    }
    
}
