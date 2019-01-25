/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primegenerator;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class PrimeGenerator {

    public static BigInteger m;
    public static BigInteger n;
    public static BigInteger aux;
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int t = Integer.valueOf(scan.nextLine());

        for (int i = 0; i < t; i++) {
            String line = scan.nextLine();
            m = new BigInteger(line.split(" ")[0]);
            n = new BigInteger(line.split(" ")[1]);

            if (m.isProbablePrime(1000) && m.compareTo(BigInteger.ONE) != 0) {
                System.out.println(m);
            }
            if(m.intValue() <= 2) System.out.println("2");
            
            for (int j = m.add(BigInteger.ONE).intValue(); j <= n.intValue(); j++) {
                if((j % 2) == 0) continue;
                aux = new BigInteger(j+"");
                if (aux.isProbablePrime(1000)) {
                    System.out.println(j);
                }
            }
            
            System.out.println("");
        }
    }
}
/*


aux = m.nextProbablePrime();
            while (true) {
                
                if (n.compareTo(aux) == -1) {
                    break;
                }
                System.out.println(aux);
                aux = aux.nextProbablePrime();
            }

*/