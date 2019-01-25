/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastprimenumber;

import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class FastPrimeNumber {

    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int N;
        long aux;
        double T;
        boolean flag = true;
        
        N = scan.nextInt();
        
        for (int i = 0; i < N; i++) {
            T = scan.nextDouble();
            aux = (long)Math.sqrt(T);
            
            for (int j = 2; j <= aux; j++) {
                if ((T % j) == 0) {
                    System.out.println("Not Prime");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Prime"); 
            }
            flag = true;
        }
    }
    
}
