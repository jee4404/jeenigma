/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import conf.Conf;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author jee
 */
public class ReflecteurView extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object[][] data;
    private RootPane parent;
    /*
    * 
    */
    public ReflecteurView(RootPane parent){
        super();
        this.parent = parent;
        this.data = new Object[1][Conf.reflecteur.length];
        this.renderView();
    }
    private void renderView(){
        for(int i=0; i<Conf.reflecteur.length; i++){
            this.data[0][i] = Conf.reflecteur[i];
        }
    }
    /*
     * 
     */
    @Override
    public int getRowCount() {
        return this.data.length;
    }
    /*
     * 
     */
    @Override
    public int getColumnCount() {
        return Conf.reflecteur.length;
    }
    /*
     * 
     */   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.data[rowIndex][columnIndex];
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
    public Object[][] getData(){
        return this.data;
    }
    /*
     * 
     */
    public void setData(Object[][] data){
        this.data = data;
    }
}
