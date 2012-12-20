/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import controler.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
            if(words.equals("")){
                throw new Exception("le texte a encrypter est vide !");
            }
            words = parent.encrypt(words);
            parent.getRootPane().getEncryptBox().getEncrypText().setText(words);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this.parent.getRootPane(), ex.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    /*
     * 
     */
    
}
