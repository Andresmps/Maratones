/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrophy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Entrophy {

    static ArrayList<Integer> numPalabras = new ArrayList<>();
    static ArrayList<String> palabras = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        do {

            String[] splito;
            String cadena = "";
            String mensaje = "";
            int totalPalabras;
            boolean condicion = false;
            do {
                cadena += scan.nextLine() + " ";
                
                if (cadena.contains("****END_OF_INPUT****")) {
                    condicion = true;
                    break;
                }

                splito = cadena.split(" ");

                if (!splito[splito.length - 1].equals("****END_OF_TEXT****")) {
                    mensaje = cadena;
                }
            } while (!splito[splito.length - 1].equals("****END_OF_TEXT****"));

            if (condicion) {
                break;
            }
            splito = mensaje.split(" ");

            totalPalabras = splito.length;

            for (int i = 0; i < totalPalabras; i++) {
                String temp = splito[i];
                
                if (!temp.equals("")) {
                    
                    if (temp.charAt(temp.length() - 1) == ',' || temp.charAt(temp.length() - 1) == '.' || temp.charAt(temp.length() - 1) == '?') {
                        temp = temp.substring(0, temp.length() - 1);
                        splito[i] = temp;
                    }
                    if (!contains(temp)) {
                        palabras.add(temp);
                    }
                }
            }
            int c = 0;
            for (int i = 0; i < palabras.size(); i++) {
                String temp = palabras.get(i);
                for (int j = 0; j < totalPalabras; j++) {
                    if (temp.equalsIgnoreCase(splito[j])) {
                        c++;
                    }
                }
                numPalabras.add(c);
                c = 0;
            }
            double E_t = 0;

            for (int i = 0; i < numPalabras.size(); i++) {
                E_t += numPalabras.get(i) * (Math.log10(totalPalabras) - Math.log10(numPalabras.get(i)));
            }
            E_t *= 1.0 / totalPalabras;

            double E_max = Math.log10(totalPalabras);

            System.out.print(totalPalabras + " ");
            System.out.print((Math.round(E_t * 10d) / 10d) + " ");
            System.out.println(Math.round((E_t / E_max) * 100));

            palabras.clear();
            numPalabras.clear();

        } while (true);

//        
//        
//        System.out.println(palabras.size());
//        for (int i = 0; i < palabras.size(); i++) {
//            System.out.println(palabras.get(i));
//        }
//        System.out.println(numPalabras);
//        System.out.println(numPalabras.size());
    }

    public static boolean contains(String palabra) {

        for (int i = 0; i < palabras.size(); i++) {
            if (palabra.equalsIgnoreCase(palabras.get(i))) {
                return true;
            }
        }

        return false;
    }

}
