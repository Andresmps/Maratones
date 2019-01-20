/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorialsum;

import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class FactorialSum {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            int M = scan.nextInt();
            int N = scan.nextInt();

            System.out.println(calcularFact(M) + calcularFact(N)); 
        } while (scan.hasNext());
    }

    public static long calcularFact(int X){
        
        long valor = 1;
        for (int i = 2; i <= X; i++) valor *= i;
        
        return valor;
    }
    
}
