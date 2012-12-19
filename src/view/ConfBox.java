/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import conf.Conf;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import listener.*;

/**
 *
 * @author jee
 */
public class ConfBox extends JPanel{
    /*
     * 
     */
    private JComboBox rotor1Decalage, rotor2Decalage, rotor3Decalage;
    private JComboBox rotor1Ordre, rotor2Ordre, rotor3Ordre;
    private JComboBox rotor1Sens, rotor2Sens, rotor3Sens;
    private JButton configurer;
    private RootPane parent;
    /*
     * 
     */
    public ConfBox(RootPane parent){
        super();
        
        this.parent = parent;
        this.initConfPanel();
        this.initKeyPanel();
        this.initSensPanel();
        
        this.configurer = new JButton("initialiser la clé");
        this.configurer.addActionListener(new ConfListener(this.parent.getMyParent()));
        this.add(configurer);
        
        this.setVisible(true);
    }
    /*
     * 
     */
    private void initConfPanel(){
        Object[] data = Conf.decalage_possible;
        
        JPanel panel_conf = new JPanel();
        panel_conf.setLayout( new BoxLayout(panel_conf, BoxLayout.Y_AXIS));
        panel_conf.add(new JLabel("délcalage initial"));
        
        JPanel panel_conf_rotor = new JPanel();
        //ajout label rotor x + rotorXConf combo box
        this.rotor1Decalage = new JComboBox(data);
        this.rotor1Decalage.setSelectedItem(Conf.defaultDecalageRotor);
        this.rotor1Decalage.setSize(150, 30);
        
        panel_conf_rotor.add(new JLabel("Rotor 1: "));
        panel_conf_rotor.add(this.rotor1Decalage);
        //ajout panel_conf_rotor au panel_conf
        panel_conf.add(panel_conf_rotor);
        
        panel_conf_rotor = new JPanel();
        this.rotor2Decalage = new JComboBox(data);
        this.rotor2Decalage.setSelectedItem(Conf.defaultDecalageRotor);
        this.rotor2Decalage.setSize(100, 20);
        panel_conf_rotor.add(new JLabel("Rotor 2 : "));
        panel_conf_rotor.add(this.rotor2Decalage);
        panel_conf.add(panel_conf_rotor);
        
        panel_conf_rotor = new JPanel();
        this.rotor3Decalage = new JComboBox(data);
        this.rotor3Decalage.setSelectedItem(Conf.defaultDecalageRotor);
        this.rotor3Decalage.setSize(150, 30);
        panel_conf_rotor.add(new JLabel("Rotor 3 : "));
        panel_conf_rotor.add(this.rotor3Decalage);
        panel_conf.add(panel_conf_rotor);
        
        panel_conf_rotor = new JPanel();
        panel_conf.add(panel_conf_rotor);
        
        panel_conf_rotor = null;
        
        this.add(panel_conf);
    }
    /*
     * 
     */
    private void initKeyPanel(){
        Object[] data = {1, 2, 3};
        JPanel panel_cle = new JPanel();
        panel_cle.setLayout( new BoxLayout(panel_cle, BoxLayout.Y_AXIS));
        
        panel_cle.add(new JLabel("ordre de rotation"));
        
        JPanel panel_cle_rotor = new JPanel();
        panel_cle_rotor.add(new JLabel("Rotor 1 : "));
        this.rotor1Ordre = new JComboBox(data);
        this.rotor1Ordre.setSelectedItem(1);
        this.rotor1Ordre.setSize(150, 30);
        panel_cle_rotor.add(this.rotor1Ordre);
        panel_cle.add(panel_cle_rotor);
        
        panel_cle_rotor = new JPanel();
        panel_cle_rotor.add(new JLabel("Rotor 2 : "));
        this.rotor2Ordre = new JComboBox(data);
        this.rotor2Ordre.setSelectedItem(2);
        this.rotor2Ordre.setSize(150, 30);
        panel_cle_rotor.add(this.rotor2Ordre);
        panel_cle.add(panel_cle_rotor);
        
        panel_cle_rotor = new JPanel();
        panel_cle_rotor.add(new JLabel("Rotor 3 : "));
        this.rotor3Ordre = new JComboBox(data);
        this.rotor3Ordre.setSelectedItem(3);
        this.rotor3Ordre.setSize(150, 30);
        panel_cle_rotor.add(this.rotor3Ordre);
        panel_cle.add(panel_cle_rotor);
        
        panel_cle_rotor = null;
        
        this.add(panel_cle);
    }
    /*
     * 
     */
    private void initSensPanel(){
        Object[] data = { 'G', 'D' };
        JPanel panel_sens = new JPanel();
        panel_sens.setLayout( new BoxLayout(panel_sens, BoxLayout.Y_AXIS));
        
        panel_sens.add(new JLabel("Sens de rotation"));
        
        JPanel panel_sens_rotor = new JPanel();
        panel_sens_rotor.add(new JLabel("Rotor 1 : "));
        this.rotor1Sens = new JComboBox(data);
        this.rotor1Sens.setSelectedItem(Conf.defaultSensRotationRotor);
        this.rotor1Sens.setSize(150, 30);
        panel_sens_rotor.add(this.rotor1Sens);
        panel_sens.add(panel_sens_rotor);
        
        panel_sens_rotor = new JPanel();
        panel_sens_rotor.add(new JLabel("Rotor 2 : "));
        this.rotor2Sens = new JComboBox(data);
        this.rotor2Sens.setSelectedItem(Conf.defaultSensRotationRotor);
        this.rotor2Sens.setSize(150, 30);
        panel_sens_rotor.add(this.rotor2Sens);
        panel_sens.add(panel_sens_rotor);
        
        panel_sens_rotor = new JPanel();
        panel_sens_rotor.add(new JLabel("Rotor 3 : "));
        this.rotor3Sens = new JComboBox(data);
        this.rotor3Sens.setSelectedItem(Conf.defaultSensRotationRotor);
        this.rotor3Sens.setSize(150, 30);
        panel_sens_rotor.add(this.rotor3Sens);
        panel_sens.add(panel_sens_rotor);
        
        panel_sens.setVisible(true);
        this.add(panel_sens);
        
    }
    /*
     * 
     */
    public int getRotor1Decalage(){
        return (int)this.rotor1Decalage.getSelectedItem();
    }
    /*
     * 
     */
    public int getRotor2Decalage(){
        return (int)this.rotor2Decalage.getSelectedItem();
    }
    /*
     * 
     */
    public int getRotor3Decalage(){
        return (int)this.rotor3Decalage.getSelectedItem();
    }
    /*
     * 
     */
    public int getRotor1Ordre(){
        return (int)this.rotor1Ordre.getSelectedItem();
    }
    /*
     * 
     */
    public int getRotor2Ordre(){
        return (int)this.rotor2Ordre.getSelectedItem();
    }
    /*
     * 
     */
    public int getRotor3Ordre(){
        return (int)this.rotor3Ordre.getSelectedItem();
    }
    /*
     * 
     */
    public char getRotor1Sens(){
        return (char)this.rotor1Sens.getSelectedItem();
    }
    /*
     * 
     */
    public char getRotor2Sens(){
        return (char)this.rotor2Sens.getSelectedItem();
    }
    /*
     * 
     */
    public char getRotor3Sens(){
        return (char)this.rotor3Sens.getSelectedItem();
    }
}
