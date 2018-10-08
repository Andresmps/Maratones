/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int casos = scan.nextInt();
        for (int i = 0; i < casos; i++) {
            
            int lowerJumps = 0;
            int upperJumps = 0;
            int jump = scan.nextInt();
            int saltos[] = new int[jump];
            
            for (int j = 0; j < jump; j++) {
                saltos[j] = scan.nextInt();
            }
            
            int temp = saltos[0];
            for (int j = 1; j < jump; j++) {

                if (temp > saltos[j]) {
                    lowerJumps++;
                }

                if (temp < saltos[j]) {
                    upperJumps++;
                }
                temp = saltos[j];
            }

            System.out.println("Case " + (i + 1) + ": " + upperJumps + " " + lowerJumps);
            
        }

    }

}
