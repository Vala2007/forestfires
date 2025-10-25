/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procedimientos;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class olímpicos {
    
    int olimpiadas[][] = new int[31][5];
    String países[] = new String[31];
    int n,o,p,b,d;
    
    public olímpicos(){
        
    }
    
    public void países(){
        Scanner lea = new Scanner(System.in);
        System.out.println("Escriba el número de países");
        n = lea.nextInt();
        System.out.println("Escriba los países");
        for(int i=1; i<=n; i++){
            países[i] = lea.next();
        }
        System.out.println("Escriba el peso de la medalla de oro");
        o = lea.nextInt();
        System.out.println("Escriba el peso de la medalla de plata");
        p = lea.nextInt();
        System.out.println("Escriba el peso de la medalla de bronce");
        b = lea.nextInt();
        System.out.println("Escriba el peso de un diploma olímpico");
        d = lea.nextInt();
    }
    
    public void lecturaOl(){
        Scanner lea = new Scanner(System.in);
        System.out.println("Escriba las medallas obtenidas por cada país");
        for (int i=1; i<=n; i++){
            for(int j=1; j<=4; j++){
                olimpiadas[i][j] = lea.nextInt();
            }
        }
    }
    
    public void mayor(int pos){
        int may=0;
        String nomb = new String();
        for(int i=1; i<=n; i++){
            if(olimpiadas[i][1]>may){
                may = olimpiadas[i][pos];
                nomb = países[i];
            }
        }
        System.out.println("País: "+nomb+" cantidad: "+may);
    }
    public void puntajes(){
        int puntajes[] = new int[31];
        for (int i=1; i<=n; i++){
            puntajes[i] = olimpiadas[i][1]*o + olimpiadas[i][2]*p + olimpiadas[i][3]*b + olimpiadas[i][4]*d;
        }
    }
    
}
