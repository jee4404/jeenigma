/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conf.Conf;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author jee
 */
public class DecryptBox extends JPanel{
    /*
     * 
     */
    private JTextArea decrypt_text;
    private RootPane parent;
    /*
     * 
     */
    public DecryptBox(RootPane parent){
        super();
        this.setSize(750, 40);
        
        this.add(new JLabel("Texte a encrypter"));
        this.parent = parent;
        this.decrypt_text = new JTextArea(Conf.text_zone_rows, Conf.text_zone_cols);
        this.add(this.decrypt_text);
        
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
    public JTextArea getDecryptText(){
        return this.decrypt_text;
    }
}
