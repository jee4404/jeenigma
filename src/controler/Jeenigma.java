/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import conf.*;
import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import view.*;

/**
 *
 * @author jee
 */
public class Jeenigma {
    /*
     * 
     */
    private Rotor rotor1, rotor2, rotor3;
    private Reflecteur reflecteur;
    private RootPane rootPane;
    private Conf conf;
    private int workingRotorNumber;
    /*
     * 
     */
    public Jeenigma(){
        this.conf = new Conf();
        this.rotor1 = new Rotor(1,'D', 0, 1, Conf.rotor1Entree, Conf.rotor1Sortie);
        this.rotor2 = new Rotor(2,'D', 0, 2, Conf.rotor2Entree, Conf.rotor2Sortie);
        this.rotor3 = new Rotor(3,'D', 0, 3, Conf.rotor3Entree, Conf.rotor3Sortie);
        this.reflecteur = new Reflecteur(Conf.reflecteur);
        this.initWorkingRotor();
        this.rootPane = new RootPane(this);
    }
    /*
     * 
     */
    public int decalageEntree(Rotor rotor, int position){
        int next_position;
        
        if(rotor.getEntree(position) >= 0){
            next_position = (position + rotor.getEntree(position)) % Conf.alphabet.size();
        }else{
            next_position = ((position + rotor.getEntree(position)) + Conf.alphabet.size()) % Conf.alphabet.size();
        }
        
        return next_position;
    }
    /*
     * 
     */
    public int decalageSortie(Rotor rotor, int position){
        int next_position;
        
        if(rotor.getSortie(position) >= 0){
            next_position = (position + rotor.getSortie(position)) % Conf.alphabet.size();
        }else{
            next_position = ((position + rotor.getSortie(position)) + Conf.alphabet.size()) % Conf.alphabet.size();
        }
        
        return next_position;
    }
    /*
     * 
     */
    public char encrypt(char letter){
        char encrypted_letter;
        try{
            int position, next_position;
            //trouver la position du caractère
            position = Tools.getPositionByChar(Character.toUpperCase(letter));
            //décalage rotor1 en entrée
            next_position = this.decalageEntree(this.rotor1, position);
            
            //décalage rotor2 en entrée
            next_position = this.decalageEntree(this.rotor2, next_position);
            
            //décalage rotor3 en entrée
            next_position = this.decalageEntree(this.rotor3, next_position);
            
            //décalage réflecteur
            if(next_position + this.reflecteur.getDecalage(next_position) >=0){
                next_position = (next_position + this.reflecteur.getDecalage(next_position)) % Conf.alphabet.size();
            }else{
                next_position = ((next_position + this.reflecteur.getDecalage(position)) + Conf.alphabet.size()) % Conf.alphabet.size();
            }
            
            //décalage rotor3 en sortie
            next_position = this.decalageSortie(this.rotor3, next_position);
            
            //décalage rotor2 en sortie
            next_position = this.decalageSortie(this.rotor2, next_position);
            
            //décalage rotor1 en sortie
            next_position = this.decalageSortie(this.rotor1, next_position);
            
            encrypted_letter = Tools.getCharByPosition(next_position);
            
            this.getWorkingRotor().decaleRotor(1, true);
            //a un tour complet de rotor, il faut passer au suivant
            if(this.getWorkingRotor().afaitUnTour()){
                
                this.getWorkingRotor().setCompteDecalage(0);
                this.setNextWorkingRotor();
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this.getRootPane(), e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
            encrypted_letter = ' ';
        }
        return encrypted_letter;
    }
    /*
     * 
     */
    public String encrypt(String words){
        String encrypted_string = "";
        char encrypted_char;
        try{
            char[] letters;
            letters = words.toCharArray();
            
            for(int i=0; i<letters.length; i++){
                encrypted_char = this.encrypt(letters[i]);
                
                if(Character.isLetter(encrypted_char)){
                    encrypted_string += encrypted_char;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this.getRootPane(), e.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
        return encrypted_string;   
    }
    /*
     * 
     */
    public char decrypt(char lettre){
        return this.encrypt(lettre);
    }
    /*
     * 
     */
    public String decrypt(String words){
        return this.encrypt(words);
    }
    /*
     * 
     */
    public void setWorkingRotorNumber(int number){
        this.workingRotorNumber = number;
    }
    /*
     *
     */
    public int  getWorkingRotorNumber(){
        return this.workingRotorNumber;
    }
    /*
     * 
     */
    public RootPane getRootPane(){
        return this.rootPane;
    }
    /*
     * 
     */
    public Rotor getRotor1(){
        return this.rotor1;
    }
    /*
     * 
     */
    public Rotor getRotor2(){
        return this.rotor2;
    }
    /*
     * 
     */
    public Rotor getRotor3(){
        return this.rotor3;
    }
    /*
     * 
     */
    public Reflecteur getReflecteur(){
        return this.reflecteur;
    }
    /*
     * 
     */
    public Conf getConf(){
        return this.conf;
    }
    /*
     * 
     */
    public void initWorkingRotor(){
        int ordreDecalageR1 = this.rotor1.getOrdreDecalage();
        int ordreDecalageR2 = this.rotor2.getOrdreDecalage();
        int ordreDecalageR3 = this.rotor3.getOrdreDecalage();
        
        Rotor[] ordres = new Rotor[3];
        ordres[this.rotor1.getOrdreDecalage()-1] = this.rotor1;
        ordres[this.rotor2.getOrdreDecalage()-1] = this.rotor2;
        ordres[this.rotor3.getOrdreDecalage()-1] = this.rotor3;
        
        this.setWorkingRotorNumber(ordres[0].getRotorNumber());
    }
    /*
     * 
     */
    public void setNextWorkingRotor() throws InvalidAttributeValueException{
        int ordreProchainRotor;
        switch(this.getWorkingRotorNumber()){
            case 1:
                ordreProchainRotor = (this.rotor1.getOrdreDecalage() % 3) + 1;
            break;
                
            case 2:
                ordreProchainRotor = (this.rotor2.getOrdreDecalage() % 3) + 1;
            break;
                
            case 3:
                ordreProchainRotor = (this.rotor3.getOrdreDecalage() % 3) + 1;
            break;
                
            default:
                ordreProchainRotor = 1;
            break;
        }
        if(ordreProchainRotor == this.rotor1.getOrdreDecalage()){
            this.setWorkingRotorNumber(1);
        }else if( ordreProchainRotor == this.rotor2.getOrdreDecalage()){
            this.setWorkingRotorNumber(2);
        }else if( ordreProchainRotor == this.rotor3.getOrdreDecalage()){
            this.setWorkingRotorNumber(3);
        }
    }
    /*
     * 
     */
    public Rotor getWorkingRotor(){
        Rotor workingRotor;
        switch(this.getWorkingRotorNumber()){
            case 1:
                workingRotor = this.rotor1;
            break;
            
            case 2:
                workingRotor = this.rotor2;
            break;
                
            case 3:
                workingRotor = this.rotor3;
            break;
            
            default:
                workingRotor = this.rotor1;
            break;
        }
        return workingRotor;
    }
    /*
     * 
     */
    public static void main(String[] args) {
        try{
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run(){
                    Jeenigma enigma = new Jeenigma();
                }
            });
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
