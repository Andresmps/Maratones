/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorfulflower;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class ColorfulFlower {

    static Scanner scan = new Scanner(System.in);
    static DecimalFormat format = new DecimalFormat("0.0000");
    
    
    public static void main(String[] args) {

        double p, perimetro, areaTriangulo, areaICirculo, areaECirculo, operacion, a, b, c;
        
        do {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();

            perimetro = a + b + c;
            p = perimetro / 2.0;
            
            operacion = p * (p - a) * (p - b) * (p - c);
            areaTriangulo = Math.sqrt(operacion);
            
            areaICirculo = (areaTriangulo / p) * (areaTriangulo / p) * Math.PI;
            
            operacion = (a * b * c) / (4.0 * areaTriangulo);
            areaECirculo = operacion * operacion * Math.PI;
            
            areaECirculo -= areaTriangulo;
            areaTriangulo -= areaICirculo;

//            areaECirculo = Math.round(areaECirculo * 10000d) / 10000d;
//            areaTriangulo = Math.round(areaTriangulo * 10000d) / 10000d;
//            areaICirculo = Math.round(areaICirculo * 10000d) / 10000d;

            System.out.println(format.format(areaECirculo) + " " + format.format(areaTriangulo) + " " + format.format(areaICirculo));
            
        } while (scan.hasNext());
    }

}
