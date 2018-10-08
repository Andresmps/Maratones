/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package how_many_knights;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class How_Many_Knights {

    private Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        How_Many_Knights menu = new How_Many_Knights();

        menu.knights();
    }

    public void knights() {
        
        
        double M = -1;
        double N = -1;
        double mayor = 0;

        while (M != 0 && N != 0) {

            M = scan.nextInt();
            N = scan.nextInt();

            if (M > 2 && N > 2) {

                System.out.println((int)Math.ceil((M * N) / 2.0));
            }

            if (M == 2 || N == 2) {
                
                mayor = Math.max(M, N);
                
                if ((mayor % 4) == 0) {
                    
                }
            }
            
            if (M == 1 || N == 1) {
                System.out.println((int)Math.max(M, N));
            }

        }

    }

}
