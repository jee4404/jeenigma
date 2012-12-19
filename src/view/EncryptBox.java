/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conf.Conf;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author jee
 */
public class EncryptBox extends JPanel{
    /*
     * 
     */
    private JTextArea encrypt_text;
    private RootPane parent;
    /*
     * 
     */
    public EncryptBox(RootPane parent){
        super();
        this.setSize(700, 40);
        this.parent = parent;
        
        this.add(new JLabel("Texte a décrypter"));
        this.encrypt_text = new JTextArea(Conf.text_zone_rows, Conf.text_zone_cols);
        this.add(encrypt_text);
        this.setVisible(true);
    }
    /*
     * 
     */
    public JTextArea getEncrypText(){
        return this.encrypt_text;
    }
    /*
     * 
     */
    public RootPane getMyParent(){
        return this.parent;
    }
}
