/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import conf.Conf;
import controler.Jeenigma;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author jee
 */
public class RootPane extends JFrame{
    private JTable tableR1, tableR2, tableR3;
    private ConfBox confbox;
    private ActionBox actionbox;
    private DecryptBox decryptbox;
    private EncryptBox encryptbox;
    private Jeenigma parent;
    /*
     * 
     */
    public RootPane(Jeenigma parent){
        super(Conf.appName);
        
        this.parent = parent;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 600);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        
        //reflecteur label + tableau
        JLabel label = new JLabel("Reflecteur");
        this.add(label);
        
        JTable table = new JTable( new ReflecteurView(this));
        this.add(table);
        
        //rotor 3 label + tableau
        label = new JLabel("Rotor3");
        this.add(label);
        
        table = new JTable( new RotorView(Conf.rotor3Entree, Conf.rotor3Sortie, this));
        this.add(table);
        
        //rotor 2 label + tableau
        label = new JLabel("Rotor2");
        this.add(label);
        
        table = new JTable( new RotorView(Conf.rotor2Entree, Conf.rotor2Sortie, this));
        this.add(table);
        
        //rotor 1 label + tableau
        label = new JLabel("Rotor1");
        this.add(label);
        
        table = new JTable( new RotorView(Conf.rotor1Entree, Conf.rotor1Sortie, this));
        this.add(table);
        
        //boite de configuration
        this.confbox = new ConfBox(this);
        this.add(this.confbox);
        
        //zone de texte a encrypter / texte décrypté
        this.decryptbox = new DecryptBox(this);
        this.add(this.decryptbox);
        
        //zone de texte encrypté / à décrypter
        this.encryptbox = new EncryptBox(this);
        this.add(this.encryptbox);
        
        //boutons d'action
        this.actionbox = new ActionBox(this);
        this.add(this.actionbox);
        
        this.setVisible(true);
    }
    /*
     * 
     */
    public JTable getTableR1(){
        return this.tableR1;
    }
    /*
     * 
     */
    public JTable getTableR2(){
        return this.tableR2;
    }
    /*
     * 
     */
    public JTable getTableR3(){
        return this.tableR3;
    }
    /*
     * 
     */
    public ConfBox getConfBox(){
        return this.confbox;
    }
    /*
     * 
     */
    public ActionBox getActionBox(){
        return this.actionbox;
    }
    /*
     * 
     */
    public DecryptBox getDecryptBox(){
        return this.decryptbox;
    }
    /*
     * 
     */
    public EncryptBox getEncryptBox(){
        return this.encryptbox;
    }
    /*
     * 
     */
    public Jeenigma getMyParent(){
        return this.parent;
    }
}
