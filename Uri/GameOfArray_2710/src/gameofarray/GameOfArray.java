/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofarray;

import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class GameOfArray {
    
    static Scanner scan = new Scanner(System.in);
    static int [][]matriz = new int[500][500];
    static String []splito;
    
    public static void main(String[] args) {
        
        int Q = Integer.valueOf(scan.nextLine());
        for (int i = 0; i < Q; i++) {
            String operacion = scan.nextLine();
            splito = operacion.split(" ");
            
            switch(splito[0]){
                case "U":  caseU();  break;
                case "A":  System.out.println(caseA());;  break;
            }  
            
        }
        caseM();
    }
    
    public static void caseU(){
        
        int X,Y,Z,W,V;
        
        X = Integer.valueOf(splito[1])-1;
        Y = Integer.valueOf(splito[2])-1;
        Z = Integer.valueOf(splito[3])-1;
        W = Integer.valueOf(splito[4])-1;
        V = Integer.valueOf(splito[5]);

        for (int i = X; i < Z+1; i++) {
            for (int j = Y; j < W+1; j++) {
                matriz[i][j] += Math.abs(V); 
            }
        }
    }
    
    public static int caseA(){
        
        return matriz[Integer.valueOf(splito[1])-1][Integer.valueOf(splito[2])-1];
    }
    
    public static void caseM(){
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
