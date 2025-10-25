/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilasedd;
import java.util.Stack;

/**
 *
 * @author ASUS
 */
public class PilasEDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] vector = {17, 25, 36, 44};
        Stack<Integer> pila = new Stack<>();
        for (int i : vector) {
            pila.push(i);
            System.out.println("Elemento en el tope: " + pila.peek());            
        }
        
        while (!pila.isEmpty()) {
            int a = pila.pop();
            System.out.println("El elemento eliminado es: " + a);
            if (!pila.isEmpty()) {
                System.out.println("Elemento en el tope: " + pila.peek());
            } else {
                System.out.println("La pila está vacía");
            }
        }
        
    }
    
}
