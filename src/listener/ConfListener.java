/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import controler.Jeenigma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author jee
 */
public class ConfListener implements ActionListener{
    /*
     * 
     */
    private Jeenigma parent;
    /*
     * 
     */
    public ConfListener(Jeenigma parent){
        this.parent = parent;
    }
    /*
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(
                (this.parent.getRootPane().getConfBox().getConfRotor1().getOrdreDecalage() +
                this.parent.getRootPane().getConfBox().getConfRotor2().getOrdreDecalage() +
                this.parent.getRootPane().getConfBox().getConfRotor3().getOrdreDecalage()) != 6  
            ){
                throw new Exception("Les rotors ne peuvent avoir le même ordre");
            }
            
            this.parent.getRotor1().setConf(
                this.parent.getRootPane().getConfBox().getConfRotor1().getDecalageInitial(),
                this.parent.getRootPane().getConfBox().getConfRotor1().getOrdreDecalage(),
                this.parent.getRootPane().getConfBox().getConfRotor1().getSensDecalage()
            );
            this.parent.getRotor1().setCompteDecalage(0);
            
            this.parent.getRotor2().setConf(
                this.parent.getRootPane().getConfBox().getConfRotor2().getDecalageInitial(),
                this.parent.getRootPane().getConfBox().getConfRotor2().getOrdreDecalage(),
                this.parent.getRootPane().getConfBox().getConfRotor2().getSensDecalage()
            );
            this.parent.getRotor2().setCompteDecalage(0);
            
            this.parent.getRotor3().setConf(
                this.parent.getRootPane().getConfBox().getConfRotor3().getDecalageInitial(),
                this.parent.getRootPane().getConfBox().getConfRotor3().getOrdreDecalage(),
                this.parent.getRootPane().getConfBox().getConfRotor3().getSensDecalage()
            );
            this.parent.getRotor3().setCompteDecalage(0);
            this.parent.initWorkingRotor();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this.parent.getRootPane(), ex.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
