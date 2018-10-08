/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rails;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author camil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> arrayTemp = new ArrayList<>();
        int N, temp = 1;

        do {
            N = scan.nextInt();

            do {

                for (int i = 0; i < N; i++) {
                    temp = scan.nextInt();
                    if (temp == 0) {
                        break;
                    }
                    arrayTemp.add(temp);
                }
                if (temp == 0) {
                    break;
                }
                llenarArray(array, N);
                run(array, arrayTemp);
                array.clear();
                arrayTemp.clear();

            } while (temp != 0);

            if (N == 0) {
                break;
            }
            System.out.println("");
        } while (N != 0);

    }

    public static void run(ArrayList<Integer> array, ArrayList<Integer> arrayTemp) {

        Stack<Integer> pila = new Stack<>();
        int size = array.size();
        boolean condicion = true;

        for (int i = 0; condicion; i++) {

            if (pila.empty()) {
                if (array.get(0).equals(arrayTemp.get(0))) {
                    array.remove(0);
                    arrayTemp.remove(0);
                } else {

                    pila.push(array.get(0));
                    array.remove(0);
                }

            } else {
                if (arrayTemp.get(0).equals(pila.peek())) {

                    arrayTemp.remove(0);
                    pila.pop();
                } else if (array.get(0).equals(arrayTemp.get(0))) {

                    array.remove(0);
                    arrayTemp.remove(0);

                } else {

                    pila.push(array.get(0));
                    array.remove(0);
                }

            }
            if (array.isEmpty()) {
                condicion = false;
            }
        }

        if (!pila.empty()) {
            int size2 = pila.size();
            for (int i = 0; i < size2; i++) {
                //System.out.println("C: " + (pila.peek().equals(arrayTemp.get(0))));
                if (pila.peek().equals(arrayTemp.get(0))) {
                    arrayTemp.remove(0);
                    pila.pop();
                } else {
                    System.out.println("No");
                    break;
                }
            }

        }

        if (pila.empty() && arrayTemp.isEmpty()) {
            System.out.println("Yes");
        }

        pila.clear();
    }

    public static void llenarArray(ArrayList<Integer> array, int N) {

        for (int i = 0; i < N; i++) {
            array.add(i + 1);
        }

    }
}
