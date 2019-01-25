/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grainschessboard;

import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class GrainsChessBoard {

    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int N;
        long X;
        
        
        N = scan.nextInt();
        
        for (int i = 0; i < N; i++) {
            X = scan.nextInt();
            X = (long) (Math.pow(2, X) / 12000);
            System.out.println(X+" kg");
        }
    }
    
}
