/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordindex;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Main {

    static String lista[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    static HashMap<String, Integer> wordsMap = new HashMap<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int suma = 0;
        int temp, temp2;

        generarAllWords();

        while (scan.hasNext()) {

            String cadena = scan.nextLine();
            if (validarString(cadena) == 0) {
                System.out.println("0");
            } else {

                System.out.println(wordsMap.get(cadena));
            }

        }
    }

    public static int validarString(String cadena) {

        int[] indicesCadena = new int[cadena.length()];
        int anterior = 0, siguiente;
        for (int i = 0; i < cadena.length(); i++) {
            String temp = cadena.charAt(i) + "";
            for (int j = 0; j < lista.length; j++) {

                if (i == 0) {
                    if (temp.equals(lista[j])) {
                        anterior = j;
                        break;
                    }
                } else {
                    if (temp.equals(lista[j])) {
                        siguiente = j;

                        if (siguiente <= anterior) {
                            return 0;
                        } else {
                            anterior = siguiente;
                        }

                    }

                }

            }
        }

        return -1;
    }


    public static void generarAllWords() {

        int z = 1, t = 1, u = 1, w = 1;
        for (int i = 1; i < 27; i++) {

            wordsMap.put(lista[i - 1], i);
            for (int j = i; j < 26; j++) {
                wordsMap.put(lista[i - 1] + lista[j], z + 26);
                z++;
                for (int k = j; k < 25; k++) {
                    wordsMap.put(lista[i - 1] + lista[j] + lista[k + 1], t + 351);
                    t++;

                    for (int l = k; l < 24; l++) {
                        wordsMap.put(lista[i - 1] + lista[j] + lista[k + 1] + lista[l + 2], u + 2951);
                        u++;
                        for (int m = l; m < 23; m++) {
                            wordsMap.put(lista[i - 1] + lista[j] + lista[k + 1] + lista[l + 2] + lista[m + 3], w + 17901);

                            w++;
                        }

                    }

                }
            }

        }

    }
    
    
    
    
//
//    public static void generarAllWords() {
//
//        int z = 1, t = 1, u = 1, w = 1;
//        for (int i = 1; i < 27; i++) {
//
//            wordsMap.put(i, lista[i - 1]);
//            for (int j = i; j < 26; j++) {
//                wordsMap.put(z + 26, lista[i - 1] + lista[j]);
//                z++;
//                for (int k = j; k < 25; k++) {
//                    wordsMap.put(t + 351, lista[i - 1] + lista[j] + lista[k + 1]);
//                    t++;
//
//                    for (int l = k; l < 24; l++) {
//                        wordsMap.put(u + 2951, lista[i - 1] + lista[j] + lista[k + 1] + lista[l + 2]);
//                        u++;
//                        for (int m = l; m < 23; m++) {
//                            wordsMap.put(w + 17901, lista[i - 1] + lista[j] + lista[k + 1] + lista[l + 2] + lista[m + 3]);
//
//                            w++;
//                        }
//
//                    }
//
//                }
//            }
//
//        }
//
//        System.out.println(wordsMap);
//        System.out.println(wordsMap.size());
//        
//    }
}
