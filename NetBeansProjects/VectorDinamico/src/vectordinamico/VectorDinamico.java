/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vectordinamico;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class VectorDinamico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<String> Equipo = new ArrayList<>();
        
        Equipo.add("Junior");
        Equipo.add("Medellin");
        Equipo.add("Santa Fe");
        
        for (String a : Equipo) {
            System.out.println(a);
        }               
        
        System.out.println(Equipo.contains("Junior"));
        
        int tamaño = Equipo.size();
        System.out.println(tamaño);
        String pos = Equipo.get(1);
        System.out.println(pos);
        Equipo.set(2, "Jaguares");
        Equipo.remove(1);
        
        for (String a : Equipo) {
            System.out.println(a);
        }
        
        Random ran = new Random();
        ArrayList<Integer> nums = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            nums.add(ran.nextInt(20));
            aqui falta
        }
        
    }
    
}
