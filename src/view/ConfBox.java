/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author jee
 */
public class ConfBox extends JPanel{
    /*
     * 
     */
    private ConfBoxRotor confRotor1, confRotor2, confRotor3;
    private RootPane parent;
    /*
     * 
     */
    public ConfBox(RootPane parent){
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.parent = parent;
        
        this.confRotor1 = new ConfBoxRotor(this, this.parent.getMyParent().getRotor1().getRotorNumber());
        this.add(this.confRotor1);
        
        this.confRotor2 = new ConfBoxRotor(this, this.parent.getMyParent().getRotor2().getRotorNumber());
        this.add(this.confRotor2);
        
        this.confRotor3 = new ConfBoxRotor(this, this.parent.getMyParent().getRotor3().getRotorNumber());
        this.add(this.confRotor3);
        
        this.setVisible(true);
    }
    /*
     * 
     */
    public RootPane getMyParent(){
        return this.parent;
    }
    /*
     * 
     */
    public ConfBoxRotor getConfRotor1(){
        return this.confRotor1;
    }
    /*
     * 
     */
    public ConfBoxRotor getConfRotor2(){
        return this.confRotor2;
    }
    /*
     * 
     */
    public ConfBoxRotor getConfRotor3(){
        return this.confRotor3;
    }
}
