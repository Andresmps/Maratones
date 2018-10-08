/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int a;
        int b;
        int c;
        int d;

        do {
            
            
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            d = scan.nextInt();

            if ((a == 0 && b == 0 && c == 0 && d == 0)) {
                break;
            }
            System.out.println(locker(a, b, c, d));

        } while (!(a == 0 && b == 0 && c == 0 && d == 0));

    }

    public static int locker(int a, int b, int c, int d) {

        int total = 0;
        if ((a == b) && (b == c) && (c == d)) {
            total = 1080;
        } else {
            if (a - b > 0) {
                total += a - b;
            } else {
                total += Math.abs(40 - b) + a;
            }

            if (c - b > 0) {
                total += c - b;
            } else {
                total += Math.abs(40 - b) + c;
            }

            if (c - d > 0) {
                total += c - d;
            } else {
                total += Math.abs(40 - d) + c;
            }

            total += 120;
            total *= 9;
        }
        return total;
    }

}
