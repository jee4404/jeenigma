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
public class NextStepListener implements ActionListener{
    /*
     * 
     */
    private Jeenigma parent;
    /*
     * 
     */
    public NextStepListener(Jeenigma parent){
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this.parent.getRootPane(), "fonction non implémentée !", "info", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
