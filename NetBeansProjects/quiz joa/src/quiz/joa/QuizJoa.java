/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz.joa;
import java.lang.Math;
import java.util.Scanner;
        

/**
 *
 * @author ASUS
 */
public class QuizJoa {

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidadEstudiantes = scanner.nextInt();

        int sumaEdades = 0;
        int cantidadHombres = 0;
        int sumaEdadesHombres = 0;
        int cantidadMujeresMenoresEdad = 0;
        int edadMaximaHombres = 0;

        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.print("Ingrese el género del estudiante (M para hombre, F para mujer): ");
            char genero = scanner.nextLine().charAt(0);

            System.out.print("Ingrese la edad del estudiante: ");
            int edad = Integer.parseInt(scanner.nextLine());

            sumaEdades += edad;

            if (genero == 'M') {
                cantidadHombres++;
                sumaEdadesHombres += edad;
                if (edad > edadMaximaHombres) {
                    edadMaximaHombres = edad;
                }
            } else if (genero == 'F' && edad < 18) {
                cantidadMujeresMenoresEdad++;
            }
        }

        double promedioEdadTotal = (double) sumaEdades / cantidadEstudiantes;
        double promedioEdadHombres = cantidadHombres > 0 ? (double) sumaEdadesHombres / cantidadHombres : 0;

        System.out.println("El promedio de edad de los estudiantes es: " + promedioEdadTotal);
        System.out.println("El promedio de edad de los hombres es: " + promedioEdadHombres);
        System.out.println("La cantidad de mujeres menores de edad es: " + cantidadMujeresMenoresEdad);
        System.out.println("La edad máxima de los hombres es: " + edadMaximaHombres);

       
        
    }
    
}
