/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import conf.Conf;
import javax.management.InvalidAttributeValueException;

/**
 *
 * @author jee
 */
public class Rotor {
    /*
     * 
     */
    private int numRotor;
    private int compteDecalage;
    private int[] ligneEntree;
    private int[] ligneSortie;
    private int decalageInitial;
    private int ordreDecalage;
    private char sensDecalage;
    /*
     * 
     */
    public Rotor(int numRotor, char sensDecalage, int decalageInitial, int ordreDecalage, int[] confEntree, int[] confSortie){
        this.ligneEntree = confEntree;
        this.ligneSortie = confSortie;
        this.compteDecalage = 0;
        this.numRotor = numRotor;
        this.decalageInitial = decalageInitial;
        this.ordreDecalage = ordreDecalage;
        this.sensDecalage = sensDecalage;
    }
    /*
     * 
     */
    public int[] getLigneEntree(){
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
    public int[] getLigneSortie(){
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
    public int getCompteDecalage(){
        return this.compteDecalage;
    }
    /*
     * 
     */
    public void setCompteDecalage(int decalage){
        this.compteDecalage = decalage;
    }
    /*
     * 
     */
    public int getRotorNumber(){
        return this.numRotor;
    }
    /*
     * 
     */
    public void setRotorNumber(int numRotor){
        this.numRotor = numRotor;
    }
    /*
     * 
     */
    public int getDecalageInitial(){
        return this.decalageInitial;
    }
    /*
     * 
     */
    public void setDecalageInitial(int decalage){
        this.decalageInitial = decalage;
    }
    /*
     * 
     */
    public int getOrdreDecalage(){
        return this.ordreDecalage;
    }
    /*
     * 
     */
    public void setOrdreDecalage(int ordreDecalage){
        this.ordreDecalage = ordreDecalage;
    }
    /*
     * 
     */
    public boolean afaitUnTour(){
        return this.compteDecalage >= Conf.reflecteur.length;
    }
    /*
     * 
     */
    public void decaleLigneEntree(int decalage ) throws InvalidAttributeValueException{
        switch( Character.toUpperCase(this.sensDecalage) ){
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
    public void decaleLigneSortie(int decalage) throws InvalidAttributeValueException{
        switch( Character.toUpperCase(this.sensDecalage) ){
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
    public void initRotor() throws InvalidAttributeValueException{
        this.decaleRotor(this.decalageInitial, false);
    }
    /*
     * 
     */
    public void decaleRotor(int decalage, boolean compteDecalage) throws InvalidAttributeValueException{
        switch( Character.toUpperCase(this.sensDecalage) ){
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
        if(compteDecalage){
            this.compteDecalage = this.compteDecalage+1;
        }
    }
    /*
     * 
     */
    public void setConf(int decalageInitial, int ordreDecalage, char sensDecalage){
        this.decalageInitial = decalageInitial;
        this.ordreDecalage = ordreDecalage;
        this.sensDecalage = sensDecalage;
    }
}
