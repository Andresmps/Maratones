/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leapyear;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class LeapYear {

    public static Scanner scan = new Scanner(System.in);
    public static BigInteger FOUR = new BigInteger("4");
    public static BigInteger CUATROCIENTOS = new BigInteger("400");
    public static BigInteger CINCUENTAYCINCO = new BigInteger("55");
    public static BigInteger CIEN = new BigInteger("100");
    public static BigInteger QUINCE = new BigInteger("15");

    public static void main(String[] args) {

        BigInteger year;
        int c = 0;
        String temp = "";
        boolean flag = false;
        boolean flag2 = false;

        do {
            if (c != 0) {
                System.out.println("");
            }
            year = new BigInteger(scan.nextLine());

            if ((year.remainder(FOUR).equals(BigInteger.ZERO) && !year.remainder(CIEN).equals(BigInteger.ZERO)) 
                    || year.remainder(CUATROCIENTOS).equals(BigInteger.ZERO)
                    ) {
                System.out.println("This is leap year.");
                flag2 = true;
            }

            if (year.remainder(CINCUENTAYCINCO).equals(BigInteger.ZERO) && flag2 == true) {
                temp = "This is bulukulu festival year.";
                flag2 = true;
                flag = true;
            }

            if (year.remainder(QUINCE).equals(BigInteger.ZERO)) {
                System.out.println("This is huluculu festival year.");
                flag2 = true;
            }

            if (flag) {
                System.out.println(temp);
                flag = false;
            }
            
            if (!flag2) {
                System.out.println("This is an ondinary year.");
            } else {
                flag2 = false;
            }

            
            c++;
        } while (scan.hasNext());

    }

}
