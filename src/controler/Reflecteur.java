/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import javax.management.InvalidAttributeValueException;

/**
 *
 * @author jee
 */
public class Reflecteur{
    /*
     * 
     */
    private int[] ligne;
    /*
     * 
     */
    public Reflecteur(int[] ligne){
        this.ligne = ligne;
    }
    /*
     * 
     */
    public int[] getLigne(){
        return this.ligne;
    }
    /*
     * 
     */
    public void setLigne(int[] ligne){
        this.ligne = ligne;
    }
    /*
     * 
     */
    public void decaleLigne( char sens, int decalage)throws InvalidAttributeValueException{
        switch( sens ){
            case 'g':
                this.ligne = Tools.decaleGauche(decalage, this.ligne);
            break;
                
            case 'd':
                this.ligne = Tools.decaleDroite(decalage, this.ligne);
            break;
            
            default:
                throw new InvalidAttributeValueException("seul g et d sont des paramètres valides");
        }
    }
    /*
     * 
     */
    public int getDecalage(int index){
        return this.ligne[index];
    }
}
