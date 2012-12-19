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
public class DecryptListener implements ActionListener{
    /*
     * 
     */
    private Jeenigma parent;
    /*
     * 
     */
    public DecryptListener(Jeenigma parent){
        this.parent = parent;
    }
    /*
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String words = this.parent.getRootPane().getEncryptBox().getEncrypText().getText();
            
            if(words.equals("")){
                throw new Exception("le texte a décrypter est vide !");
            }
            
            words = this.parent.decrypt(words);
            
            this.parent.getRootPane().getDecryptBox().getDecryptText().setText(words);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this.parent.getRootPane(), ex.getMessage(), "erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
