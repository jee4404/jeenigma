/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import controler.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jee
 */
public class EncryptListener implements ActionListener{
    /*
     * 
     */
    public Jeenigma parent;
    /*
     * 
     */
    public EncryptListener(Jeenigma parent){
        this.parent = parent;
    }
    /*
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String words;
            words = parent.getRootPane().getDecryptBox().getDecryptText().getText();
            words = parent.encrypt(words);
            
            //char sens;
            //sens = 'd';
            //parent.getWorkingRotor().decaleLigneEntree(sens, 1);
            //parent.getWorkingRotor().decaleLigneSortie(sens, 1);
            parent.getRootPane().getEncryptBox().getEncrypText().setText(words);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    /*
     * 
     */
    
}
