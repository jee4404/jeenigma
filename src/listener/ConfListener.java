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
            if( (this.parent.getRootPane().getConfBox().getRotor1Ordre() + this.parent.getRootPane().getConfBox().getRotor2Ordre() + this.parent.getRootPane().getConfBox().getRotor3Ordre()) != 6){
                throw new Exception("Les rotors ne peuvent avoir le même ordre");
            }
            //set decalage rotor 1, 2 et 3
            this.parent.getConf().setDecalageRotor1(this.parent.getRootPane().getConfBox().getRotor1Decalage());
            this.parent.getConf().setDecalageRotor2(this.parent.getRootPane().getConfBox().getRotor2Decalage());
            this.parent.getConf().setDecalageRotor3(this.parent.getRootPane().getConfBox().getRotor3Decalage());

            //set ordre rotor 1, 2, et 3
            this.parent.getConf().setOrdreRotor1(this.parent.getRootPane().getConfBox().getRotor1Ordre());
            this.parent.getConf().setOrdreRotor2(this.parent.getRootPane().getConfBox().getRotor2Ordre());
            this.parent.getConf().setOrdreRotor3(this.parent.getRootPane().getConfBox().getRotor3Ordre());
            
            //set sens roto 1, 2 et 3
            this.parent.getConf().setSensRotor1(this.parent.getRootPane().getConfBox().getRotor1Sens());
            this.parent.getConf().setSensRotor2(this.parent.getRootPane().getConfBox().getRotor2Sens());
            this.parent.getConf().setSensRotor3(this.parent.getRootPane().getConfBox().getRotor3Sens());
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this.parent.getRootPane(), ex.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
