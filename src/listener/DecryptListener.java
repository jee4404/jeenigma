/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;
import controler.Jeenigma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            
            words = this.parent.decrypt(words);
            
            this.parent.getRootPane().getDecryptBox().getDecryptText().setText(words);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
