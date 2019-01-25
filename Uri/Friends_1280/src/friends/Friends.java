/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friends;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Andres Martinez
 */
public class Friends {

    public static Scanner scan = new Scanner(System.in);
    public static BigInteger payment = BigInteger.ZERO; 
    public static BigInteger TWO = BigInteger.ONE.add(BigInteger.ONE); 
    public static BigInteger THREE = BigInteger.ONE.add(TWO); 
    public static BigInteger FOUR = TWO.add(TWO); 
    

    public static void main(String[] args) {

        int T;
        BigInteger m, n;

        T = Integer.valueOf(scan.nextLine());

        for (int i = 0; i < T; i++) {
            String line = scan.nextLine();
            m = new BigInteger(line.split(" ")[0]);
            n = new BigInteger(line.split(" ")[1]);

            if (m.equals(BigInteger.ONE)) { 
                payment = n.add(TWO);
            }else
            if (m.equals(TWO)) {
                payment = (TWO.multiply(n)).add(THREE);
            }else
            if (m.equals(THREE)) {
                payment = ( TWO.pow( Integer.valueOf( ""+(n.add(THREE) ) ) ) ).add(THREE.negate());
            }else
            if (m.equals(FOUR)) {
                payment = ( TWO.pow( Integer.valueOf( ""+(power(n.add(BigInteger.ONE))) ) ) ).add(THREE.negate());
            }else
                payment = amigos(m, n);
             
            
            if (m.equals(THREE)) {
                payment.add(TWO.multiply(BigInteger.TEN.multiply(BigInteger.TEN)));
            }
            if (m.equals(FOUR)) { 
                payment.add(TWO);
            }

            System.out.println(payment);

        }
    }
    
    public static BigInteger power(BigInteger n){
        
        if (n.equals(BigInteger.ZERO)) {
            return TWO;
        }
        return TWO.pow( Integer.valueOf((power( n.add( BigInteger.ONE.negate() ) ) )+"") ); 
    }
    
    
    public static BigInteger amigos(BigInteger m, BigInteger n) {
        
        if (m.equals(BigInteger.ZERO)) {
            return BigInteger.ONE.add(n); 
        }
        
        if (n.equals(BigInteger.ZERO) && (m.compareTo(BigInteger.ONE)) == 1) {
            return amigos(m.add(BigInteger.ONE.negate()), BigInteger.ONE);
        }
        if ((n.compareTo(BigInteger.ONE)) == 1 && (m.compareTo(BigInteger.ONE)) == 1) {
            return amigos(m.add(BigInteger.ONE.negate()), amigos(m, n.add(BigInteger.ONE.negate())));
        }
 
        return BigInteger.ZERO;
    }

}
