/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import conf.Conf;
import java.util.Set;

/**
 *
 * @author jee
 */
public class Tools {
    /*
     * 
     */
    public static int[] decaleDroite(int decalage, int[] ligne) throws ArithmeticException{
        if( decalage <= 0){
            throw new ArithmeticException("le decalage doit être positif");
        }
        
        int[] newline;
        newline = new int[ligne.length];
        
        for(int i=0; i<ligne.length; i++){
            newline[ (i+decalage) % ligne.length ] = ligne[i];
        }
        
        return newline;
    }
    /*
     * 
     */
    public static int[] decaleGauche(int decalage, int[] ligne) throws ArithmeticException{
        if( decalage <= 0){
            throw new ArithmeticException("le decalage doit être positif");
        }
        
        int[] newline;
        newline = new int[ligne.length];
        
        decalage = ligne.length - decalage;
        
        for(int i=0; i<ligne.length; i++){
            newline[ (i+decalage) % ligne.length ] = ligne[i];
        }
        
        return newline;
    }
    /*
     * 
     */
    public static int getPositionByChar(char letter) throws Exception{
        int position;
        if( !Conf.alphabet.containsKey(letter) ){
            throw new Exception("la lettre à encrypter n'est pas disponible dans notre alphabet");
        }
        
        position = (int) Conf.alphabet.get(letter);
        return position;
    }
    /*
     * 
     */
    public static char getCharByPosition(int position) throws Exception{
        if(position < 0 || position > Conf.alphabet_reverse.length ){
            throw new Exception("la position donnée est hors alphabet");
        }
        char letter;
        letter = Conf.alphabet_reverse[position];
        return letter;
    }
}
