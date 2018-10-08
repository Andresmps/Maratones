/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Main {

    private final int MAX = 100;
    private ArrayList<Integer> primes = new ArrayList();
    private ArrayList<Integer> factores = new ArrayList();
    private Scanner scan = new Scanner(System.in);
    private int total = 0;

    
    public static void main(String[] args) {
        Main main = new Main();

        main.calculatePrimes();
        main.menu();
    }
    
    public void menu() {

        int numb = 0;
        do {
            numb = scan.nextInt();
            if (numb == 0) {
                break;
            }
            BigInteger numero = factorial(numb);

            for (int i = 0; i < primes.size(); i++) {
                BigInteger temp = factorizacion(numero, primes.get(i));

                if (total != 0) {
                    factores.add(total);
                }
                total = 0;
                if (temp.equals(BigInteger.ONE)) {
                    break;
                }

            }

            String mensaje = "";
            if (factores.size() > 15) {
                if (numb < 10) {
                    mensaje = "  " + numb + "! =";
                } else if (numb < 100) {
                    mensaje = " " + numb + "! =";
                } else {
                    mensaje = numb + "! =";
                }
            } else {
                if (numb < 10) {
                    mensaje = "  " + numb + "! =";
                } else if (numb < 100) {
                    mensaje = " " + numb + "! =";
                } else {
                    mensaje = numb + "! =";
                }
            }
            for (int i = 0; i < factores.size(); i++) {

                if (i == 15) {
                    if (factores.get(i) < 10) {
                        mensaje += "\n        " + factores.get(i);
                    }
                } else {
                    if (factores.get(i) < 10) {
                        mensaje += "  " + factores.get(i);
                    } else if (factores.get(i) < 100) {
                        mensaje += " " + factores.get(i);
                    }
                }
            }

            System.out.println(mensaje);
            factores.clear();

        } while (numb != 0);

    }

    public BigInteger factorial(int numero) {

        BigInteger factorial = new BigInteger("1");

        for (int i = 2; i <= numero; i++) {
            BigInteger iterador = new BigInteger(i + "");
            factorial = factorial.multiply(iterador);
        }

        return factorial;
    }

    public BigInteger factorizacion(BigInteger numero, int primo) {

        BigInteger primos = new BigInteger("" + primo);

        if (numero.equals(BigInteger.ONE)) {
            return numero;
        }

        if (numero.divideAndRemainder(primos)[1].equals(BigInteger.ZERO)) {
            total++;
            return factorizacion(numero.divideAndRemainder(primos)[0], primo);
        }

        return numero;
    }

    public void calculatePrimes() {
        primes.add(2);
        int c = 0;

        for (int i = 3; i <= MAX; i++) {

            for (int j = 0; j < primes.size(); j++) {

                if (i % primes.get(j) == 0) {
                    c = 0;
                    break;
                } else {
                    c = 1;
                }
            }
            if (c == 1) {
                primes.add(i);
            }

        }

    }
}
