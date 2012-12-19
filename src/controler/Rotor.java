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
public class Rotor {
    /*
     * 
     */
    private int[] ligneEntree;
    private int[] ligneSortie;
    /*
     * 
     */
    public Rotor(int[] confEntree, int[] confSortie){
        this.ligneEntree = confEntree;
        this.ligneSortie = confSortie;
    }
    /*
     * 
     */
    public int[] ligneEntree(){
        return this.ligneEntree;
    }
    /*
     * 
     */
    public void setLigneEntree(int[] confEntree){
        this.ligneEntree = confEntree;
    }
    /*
     * 
     */
    public int[] ligneSortie(){
        return this.ligneSortie;
    }
    /*
     * 
     */
    public void setLigneSortie(int[] confSortie){
        this.ligneSortie = confSortie;
    }
    /*
     * 
     */
    public int getEntree(int index){
        return this.ligneEntree[index];
    }
    /*
     * 
     */
    public void setEntree(int index, int value){
        this.ligneEntree[index] = value;
    }
    /*
     * 
     */
    public int getSortie(int index){
        return this.ligneSortie[index];
    }
    /*
     * 
     */
    public void setSortie(int index, int value){
        this.ligneEntree[index] = value;
    }
    /*
     * 
     */
    public void decaleLigneEntree(char sens, int decalage ) throws InvalidAttributeValueException{
        switch( Character.toUpperCase(sens) ){
            case 'G':
                this.ligneEntree = Tools.decaleGauche(decalage, this.ligneEntree);
            break;
                
            case 'D':
                this.ligneEntree = Tools.decaleDroite(decalage, this.ligneEntree);
            break;
            
            default:
                throw new InvalidAttributeValueException("seul g et d sont des paramètres valides");
        }
    }
    /*
     * 
     */
    public void decaleLigneSortie(char sens, int decalage ) throws InvalidAttributeValueException{
        switch( Character.toUpperCase(sens) ){
            case 'G':
                this.ligneSortie = Tools.decaleGauche(decalage, this.ligneSortie);
            break;
                
            case 'D':
                this.ligneSortie = Tools.decaleDroite(decalage, this.ligneSortie);
            break;
            
            default:
                throw new InvalidAttributeValueException("seul g et d sont des paramètres valides");
        }
    }
    /*
     * 
     */
    public void initRotor(char sens, int decalage) throws InvalidAttributeValueException{
        switch( Character.toUpperCase(sens) ){
            case 'G':
                this.ligneEntree = Tools.decaleGauche(decalage, this.ligneEntree);
                this.ligneSortie = Tools.decaleGauche(decalage, this.ligneSortie);
            break;
                
            case 'D':
                this.ligneEntree = Tools.decaleDroite(decalage, this.ligneEntree);
                this.ligneSortie = Tools.decaleDroite(decalage, this.ligneSortie);
            break;
            
            default:
                throw new InvalidAttributeValueException("seul g et d sont des paramètres valides");
        }
    }
}
