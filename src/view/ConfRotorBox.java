/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conf.Conf;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jee
 */
class ConfRotorBox extends JPanel{
    /*
    * 
    */
    private ConfBox parent;
    private JComboBox decalageInitial, ordreDecalage, sensDecalage;
    /*
     * 
     */
    public ConfRotorBox(ConfBox parent, int rotorNumber ){
        super();
        this.parent = parent;
        this.add(new JLabel("Rotor "+rotorNumber));
        this.add(new JLabel("déc. initial"));
        
        this.decalageInitial = new JComboBox(Conf.decalage_possible);
        this.decalageInitial.setSelectedItem(Conf.decalageRotorDefaut);
        this.add(this.decalageInitial);
        
        this.add(new JLabel("ordre déc."));
        Object[] ordre_possible = {1, 2, 3};
        this.ordreDecalage = new JComboBox(ordre_possible);
        this.ordreDecalage.setSelectedItem(rotorNumber);
        this.add(this.ordreDecalage);
        
        this.add(new JLabel("sens déc."));
        Object[] sens_possible = {'G', 'D'};
        this.sensDecalage = new JComboBox(sens_possible);
        this.sensDecalage.setSelectedItem(Conf.sensRotationRotorDefaut);
        this.add(this.sensDecalage);
    }
    /*
     * 
     */
    public ConfBox getMyParent(){
        return this.parent;
    }
    /*
     * 
     */
    public int getDecalageInitial(){
        return (int)this.decalageInitial.getSelectedItem();
    }
    /*
     * 
     */
    public int getOrdreDecalage(){
        return (int)this.ordreDecalage.getSelectedItem();
    }
    /*
     * 
     */
    public char getSensDecalage(){
        return (char)this.sensDecalage.getSelectedItem();
    }
}
