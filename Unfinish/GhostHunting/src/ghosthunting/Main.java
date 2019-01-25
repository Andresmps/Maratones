/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghosthunting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author camil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {

            int N = scan.nextInt();
            int[][] coordenadas = new int[2][N];
            ArrayList<Double> areas = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {

                coordenadas[0][i] = scan.nextInt();
                coordenadas[1][i] = scan.nextInt();
            }

            for (int j = 0; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    for (int l = k + 1; l < N; l++) {
//                        int[][] coordenadasTemp = coordenada(coordenadas[0][j], coordenadas[1][j], coordenadas[0][k],
//                                coordenadas[1][k], coordenadas[0][l], coordenadas[1][l]);
//                        
                        areas.add(area2(coordenadas[0][j], coordenadas[1][j], coordenadas[0][k],
                                coordenadas[1][k], coordenadas[0][l], coordenadas[1][l]));
                        
                    }
                }
            }
            double area = areas.get(0);
            for (int i = 1; i < areas.size(); i++) {
                if (areas.get(i) == 0) {
                    continue; 
                }
                if (area < areas.get(i)) {
                    area = areas.get(i); 
                }

            }
            area = Math.round(area * 10d) / 10d;
            System.out.println(area);
        }

    }
//
//    public static double area(int[][] coordenadas) {
//
//        double area;
//        double iz = 0;
//        double de = 0;
//
//        for (int i = 0; i < coordenadas[0].length - 1; i++) {
//
//            iz += coordenadas[1][i] * coordenadas[0][i + 1];
//            de += coordenadas[0][i] * coordenadas[1][i + 1];
//        }
//
//        area = Math.abs(iz - de) * 0.5;
//
//        return area;
//    }
//
//    public static int[][] coordenada(int x_1, int y_1, int x_2, int y_2, int x_3, int y_3) {
//
//        int[][] coordenadas = new int[2][4];
//
//        coordenadas[1][0] = x_1;
//        coordenadas[1][1] = x_2;
//        coordenadas[1][2] = x_3;
//        coordenadas[1][3] = x_1;
//        coordenadas[0][0] = y_1;
//        coordenadas[0][1] = y_2;
//        coordenadas[0][2] = y_3;
//        coordenadas[0][3] = y_1;
//
//        return coordenadas;
//    }

    
    public static String minimo(double a, double b, double c){
        
        if (c > a && c > b) {
            return a+":"+b;
        }else if (b > a && b > c) {
            return a+":"+c;
        }
        
        return b+":"+c;
    }
    
    public static double distancia(double x, double y, double x_1, double y_1){
        
        return Math.sqrt( ( (y_1 - y) * (y_1 - y) ) + ( (x_1 - x) * (x_1 - x) ) );
    }
    
    public static double area2(int x_1, int y_1, int x_2, int y_2, int x_3, int y_3){
        
        String valores = minimo(distancia(x_1, y_1, x_2, y_2), distancia(x_1, y_1, x_3, y_3), distancia(x_3, y_3, x_2, y_2));
        double base = Double.parseDouble(valores.split(":")[0]);
        double altura = Double.parseDouble(valores.split(":")[1]);
        
        
        return base*altura*0.5;
    }
    
}
