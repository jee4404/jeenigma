/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import listener.*;

/**
 *
 * @author jee
 */
public class ActionBox extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
     * 
     */
    private JButton encrypter, next_step, decrypter, configurer;
    private RootPane parent;
    /*
     * 
     */
    public ActionBox(RootPane parent){
        this.parent = parent;
        this.encrypter = new JButton("encrypter");
        this.decrypter = new JButton("décrypter");
        this.next_step = new JButton("étape suivante");
        this.configurer = new JButton("configurer la clé");
        
        this.encrypter.addActionListener(new EncryptListener(parent.getMyParent()));
        this.decrypter.addActionListener(new DecryptListener(parent.getMyParent()));
        this.configurer.addActionListener(new ConfListener(parent.getMyParent()));
        this.next_step.addActionListener(new NextStepListener(parent.getMyParent()));
        
        this.add(this.configurer);
        this.add(this.encrypter);
        this.add(this.decrypter);
        this.add(this.next_step);
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
    public JButton getEncypter(){
        return this.encrypter;
    }
    /*
     * 
     */
    public JButton getDecypter(){
        return this.decrypter;
    }
    /*
     * 
     */
    public JButton getNextStep(){
        return this.next_step;
    }
}
