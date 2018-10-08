package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Main {

    static String lista[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat(".00");
        Main main = new Main();
        
        while (scan.hasNext()) {

            String a = scan.nextLine();
            String b = scan.nextLine();
            System.out.printf("%.2f %%\n",main.loveCalculator(a, b));
            //System.out.println(main.mostrar(formato.format(main.loveCalculator(a, b))));
            
        }
    }


    public double loveCalculator(String nombreA, String nombreB) {

        double totalA = calcularValor(nombreA.length(), nombreA);
        double totalB = calcularValor(nombreB.length(), nombreB);
        int A = condicion((int) totalA);
        int B = condicion((int) totalB);

        totalA = Math.max(A, B);
        totalB = Math.min(A, B);

        return (totalB / totalA) * 100.0;
    }

    public int calcularValor(int longitud, String nombre) {

        int total = 0;
        for (int i = 0; i < longitud; i++) {
            String temp = nombre.charAt(i) + "";

            for (int j = 0; j < lista.length; j++) {

                if (temp.equals(" ")) {
                    break;
                }
                if (temp.equalsIgnoreCase(lista[j])) {
                    total += j + 1;
                    break;
                }
            }
        }

        return total;
    }

    public int condicion(int numero) {

        if (numero > 9 && numero < 100) {
            return condicion(numbInOne(numero));

        } else if (numero > 99 && numero < 1000) {
            return condicion(numbInTwo(numero));
        }
        return numero;
    }

    public int numbInOne(int numero) {

        numero = (numero % 10) + ((numero / 10) % 10);
        return numero;
    }

    public int numbInTwo(int numero) {

        numero = (numero % 10) + ((numero / 10) % 10) + ((numero / 100) % 10);
        return numero;
    }

}
