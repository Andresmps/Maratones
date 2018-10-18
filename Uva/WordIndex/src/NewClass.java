/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author camil
 */
public class NewClass {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Andrés
 */
public class IntegrationExam {

    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    ArrayList<Double> valoresDeX = new ArrayList();
    ArrayList<Double> areaPuntoMedio = new ArrayList();
    ArrayList<Double> areaTrapecio = new ArrayList();

    // Valores por defecto de C y D
    double c = 4.0, d = 5.0;

    public static void main(String[] args) {
        IntegrationExam Menu = new IntegrationExam();
        Menu.menu();
    }

    public void menu() {

        double a, b, numIntervalos, puntoMedio, deltaX,
                funcionPuntoMedio, funcionA, funcionB,
                promedioPuntoMedio, promedioTrapecio,
                varianzaPuntoMedio, varianzaTrapecio,
                desviacionEstandarPuntoMedio, desviacionEstandarTrapecio,
                areaTotalPuntoMedio = 0, areaTotalTrapecio = 0;

        // Pide los valores a, b y N
        do {

            System.out.println("Digite los limites de la integración (a,b):");
            System.out.println("Recuerde que el valor de \"a\" debe ser menor que \"b\"");
            System.out.print("a: ");
            a = scan.nextDouble();
            System.out.print("b: ");
            b = scan.nextDouble();
            System.out.println("");
        } while (a >= b);

        System.out.println("Digite el numero N de intervalos:");
        numIntervalos = scan.nextInt();
        valoresDeX(a, b, numIntervalos);
        deltaX = b - a;

        // Calcula el area de la integral por medio del metodo punto fijo
        for (int i = 1; i < valoresDeX.size(); i++) {

            puntoMedio = (valoresDeX.get(i - 1) + valoresDeX.get(i)) / 2;
            funcionPuntoMedio = funcion(puntoMedio);
            areaTotalPuntoMedio += area(funcionPuntoMedio, deltaX);
            areaPuntoMedio.add(area(funcionPuntoMedio, deltaX));
        }

        // Calcula el area de la integral por medio del metodo del trapecio
        for (int i = 1; i < valoresDeX.size(); i++) {

            funcionA = funcion(valoresDeX.get(i - 1));
            funcionB = funcion(valoresDeX.get(i));
            puntoMedio = (funcionA + funcionB) / 2;
            areaTotalTrapecio += area(puntoMedio, deltaX);
            areaTrapecio.add(area(puntoMedio, deltaX));
        }

        // Promedio
        promedioPuntoMedio = promedio(areaPuntoMedio);
        promedioTrapecio = promedio(areaTrapecio);

        // Varianza
        varianzaPuntoMedio = varianza(promedioPuntoMedio, areaPuntoMedio);
        varianzaTrapecio = varianza(promedioTrapecio, areaTrapecio);

        // Desviacion Estandar
        // Se calcula sacandole la raiz a la varianza
        desviacionEstandarPuntoMedio = Math.sqrt(varianzaPuntoMedio);
        desviacionEstandarTrapecio = Math.sqrt(varianzaTrapecio);

        System.out.println("\n");
        System.out.println("Valores de X:\n" + valoresDeX + "\n");
        
        System.out.println("Punto Fijo: \n\tAreas: " + areaPuntoMedio);
        System.out.println("\tArea Total: " + areaTotalPuntoMedio);
        System.out.println("\tPromedio: " + promedioPuntoMedio);
        System.out.println("\tVarianza: " + varianzaPuntoMedio);
        System.out.println("\tDesviación Estandar: " + desviacionEstandarPuntoMedio + "\n");

        System.out.println("Trapecio: \n\tAreas: " + areaTrapecio);
        System.out.println("\tArea Total: " + areaTotalTrapecio);
        System.out.println("\tPromedio: " + promedioTrapecio);
        System.out.println("\tVarianza: " + varianzaTrapecio);
        System.out.println("\tDesviación Estandar: " + desviacionEstandarTrapecio);

    }

    //   Calcula la varianza de las areas
    //  Recibe una lista con las areas, ya sea las calculadas por punto fijo o trapecio
    //   Realiza la sumatoria de las areas + el promedio de todas y al resultado le resta N - 1 
    public double varianza(double promedio, ArrayList<Double> areas) {

        double sumatoria = 0;

        for (int i = 0; i < areas.size(); i++) {
            
            double sumaTemp = areas.get(i) - promedio;
            sumatoria += Math.pow(sumaTemp, 2);
        }
        return sumatoria / valoresDeX.size();
    }

    // Calcula el promedio de las areas
    // Recibe una lista con las areas, ya sea las calculadas por punto fijo o trapecio
    public double promedio(ArrayList<Double> areas) {

        double promedio = 0;

        for (int i = 0; i < areas.size(); i++) {
            promedio += areas.get(i);
        }
        return promedio/valoresDeX.size();
    }

    /*      Calcula el area 
    
        Donde la altura es:
                 altura = f(c) si es calculada por el punto medio o
                 altura = ( f(a) * f(b) ) / 2 si es calculada por el trapecio
                 delta(x) = b - a
     */
    public double area(double altura, double deltaX) {

        return altura * deltaX;
    }

//    public void valoresX(){
//        
//        valoresDeX.add(1.4234252);
//        
//        System.out.println(valoresDeX);
//        
//    }
//    
    //      Precarga los datos de X con numeros Pseudo-aleatorios
    public void valoresDeX(double a, double b, double N) {
        valoresDeX.add(a);
        valoresDeX.add(b);

        for (int i = 0; i < N - 3; i++) {
            double valorTemp = random.nextFloat()+a;
            //System.out.println("numeroRandom: ["+valorTemp+"]");
            if (!valoresDeX.contains(valorTemp) && valorTemp < b && valorTemp > a) {
                valoresDeX.add(valorTemp);
            } else {
                i--;
            }

        }

        // Organiza los valores de X que han sido generados aleatorios
        valoresDeX.sort(Comparator.naturalOrder());
    }

    // Evalua la función
    public double funcion(double x) {

        double funcion = c + (d * Math.pow(x, 4));
        return Math.sqrt(funcion);
    }

}

}
