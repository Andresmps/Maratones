package chaos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author green
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String entrada = scan.nextLine();
            String[] tiempo = entrada.split(":");
            String horas = tiempo[0];
            String minutos = tiempo[1];
            String m = horas + minutos;

            int time = Integer.parseInt(m);

            if (horas.equals(reverse(minutos)) && time < 112) {
                mostrarHora(time + 1);
            } else {

                do {
                    time++;

                    if ((time % 100) == 60) {
                        time = time + 40;
                    }

                    if ((time / 100) == 24) {
                        time = 0;
                    }
                } while (!(time + "").equals(reverse(time + "")));

                mostrarHora(time);

            }

        }

    }

    public static void mostrarHora(int time) {

        String tiempo = time + "";
        if (time < 10) {
            System.out.println("00:0" + time);
        } else if (time < 100) {
            System.out.println("00:" + time);
        } else if (time < 1000) {
            System.out.println("0" + tiempo.charAt(0) + ":" + tiempo.charAt(1) + "" + tiempo.charAt(2));
        } else {
            System.out.println(tiempo.charAt(0) + "" + tiempo.charAt(1) + ":" + tiempo.charAt(2) + "" + tiempo.charAt(3));
        }
    }

    public static String reverse(String minutos) {

        String minutosTemp = "";
        for (int i = minutos.length() - 1; i >= 0; i--) {
            minutosTemp += minutos.charAt(i);
        }

        return minutosTemp;
    }

}
