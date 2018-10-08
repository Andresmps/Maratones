/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamonds;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author camil
 */
public class Diamonds {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Stack<Integer> pila = new Stack();
        int N = Integer.parseInt(scan.nextLine());
        int diamonds = 0;

        for (int i = 0; i < N; i++) {
            String mensaje = scan.nextLine();

            for (int j = 0; j < mensaje.length(); j++) {
                if (mensaje.charAt(j) == '<') {
                    pila.push(j);
                } else if(!pila.empty()){
                    if (mensaje.charAt(j) == '>') {
                        pila.pop();
                        diamonds++;
                    }
                }
            }
            System.out.println(diamonds);
            diamonds = 0;
            pila.clear();
        }
        
        

    }

}
