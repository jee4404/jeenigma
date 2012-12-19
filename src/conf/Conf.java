/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author jee
 */
public class Conf {
    /*
     * CONSTANTES DE CONF
     */
    public static final int[] rotor1Entree = {10, 21, 5, -17, 21, -4, 12, 16, 6, -3, 7, -7, 4, 2, 5, -7, -11, -17, -9, -6, -9, -19, 2, -3, -21, -4};
    public static final int[] rotor1Sortie = {17, 4, 19, 21, 7, 11, 3, -5, 7, 9, -10, 9, 17, 6, -6, -2, -4, -7, -12, -5, 3, 4, -21, -16, -2, -21};
    public static final int[] rotor2Entree = {3, 17, 22, 18, 16, 7, 5, 1, -7, 16, -3, 8, 2, 9, 2, -5, -1, -13, -12, -17, -11, -4, 1, -10, -19, -25};
    public static final int[] rotor2Sortie = {25, 7, 17, -3, 13, 19, 12, 3, -1, 11, 5, -5, -7, 10, -2, 1, -2, 4, -17, -8, -16, -18, -9, -1, -22, -16};
    public static final int[] rotor3Entree = {1, 16, 5, 17, 20, 8, -2, 2, 14, 6, 2, -5, -12, -10, 9, 10, 5, -9, 1, -14, -2, -10, -6, 13, -10, -23};
    public static final int[] rotor3Sortie = {12, -1, 23, 10, 2, 14, 5, -5, 9, -2, -13, 10, -2, -8, 10, -6, 6, -16, 2, -1, -17, -5, -14, -9, -20, -10};
    public static final int[] reflecteur = {25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1, -1, -3, -5, -7, -9, -11, -13, -15, -17, -19, -21, -23, -25};
    
    public static final Map alphabet = new HashMap(){{
        put('A',0);
        put('B',1);
        put('C',2);
        put('D',3);
        put('E',4);
        put('F',5);
        put('G',6);
        put('H',7);
        put('I',8);
        put('J',9);
        put('K',10);
        put('L',11);
        put('M',12);
        put('N',13);
        put('O',14);
        put('P',15);
        put('Q',16);
        put('R',17);
        put('S',18);
        put('T',19);
        put('U',20);
        put('V',21);
        put('W',22);
        put('X',23);
        put('Y',24);
        put('Z',25);
    }};
    
    public static final char[] alphabet_reverse = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static final String appName = "Enigma";
    public static final int text_zone_rows = 2;
    public static final int text_zone_cols = 80;
    public static final Object[] decalage_possible = {
            -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1,
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    };
    public static final char sensRotationRotorDefaut = 'D';
    public static final int decalageRotorDefaut = 0;
    /*
     * FIN CONSTANTES
     */
    /*
     * 
     */
    public Conf(){
       
    }
    /*
     * 
     */
    
}
