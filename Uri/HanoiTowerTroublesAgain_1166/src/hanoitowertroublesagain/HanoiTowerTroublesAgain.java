/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoitowertroublesagain;

import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class HanoiTowerTroublesAgain {

    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int T, N, sum = 0;
        
        T = scan.nextInt();
        
        for (int i = 0; i < T; i++) {
            N = scan.nextInt();
            
            for (int j = 1; j < N+1; j++) {
                if((j % 2) != 0) sum += 1;
                sum += j;
            }
            
            System.out.println(sum-1);
            sum = 0;
        }
    }
    
}
