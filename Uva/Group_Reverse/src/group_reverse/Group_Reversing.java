/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group_reverse;

import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Group_Reversing {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String line = "";
        String mensaje;
        String newMensaje = "";
        int G;
        while (!line.equals("0")) {
            line = scan.nextLine();

            if (line.equals("0")) {
                break;
            }

            String[] lines = line.split(" ");
            G = Integer.parseInt(lines[0]);
            mensaje = lines[1];
            int longitudCadena = mensaje.length() / G;

            for (int i = 0; i < G; i++) {

                newMensaje += reverse(mensaje.substring(0, longitudCadena));
                mensaje = mensaje.substring(longitudCadena);

            }
            System.out.println(newMensaje);
            newMensaje = "";
        }

    }

    public static String reverse(String cadena) {

        String newCadena = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            newCadena += cadena.charAt(i);
        }

        return newCadena;
    }

}
