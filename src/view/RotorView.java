/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author jee
 */
public class RotorView extends AbstractTableModel{
    private Object[][] data;
    private int[] rotorConfEntree, rotorConfSortie;
    private RootPane parent;
    /*
     * 
     */
    public RotorView(int[] rotorConfEntree, int[] rotorConfSortie, RootPane parent){
        super();
        this.data = new Object[2][rotorConfEntree.length];
        this.parent = parent;
        this.rotorConfEntree = rotorConfEntree;
        this.rotorConfSortie = rotorConfSortie;
        this.renderView();
    }
    /*
     * 
     */
    private void renderView(){
        for(int i=0; i<this.rotorConfSortie.length; i++){
            this.data[0][i] = this.rotorConfSortie[i];
        }
        
        for(int i=0; i<this.rotorConfEntree.length; i++){
            this.data[1][i] = this.rotorConfEntree[i];
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
        return this.rotorConfEntree.length;
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
    /*
     * 
     */
    public int[] getRotorConfEntree(){
        return this.rotorConfEntree;
    }
    /*
     * 
     */
    public int[] getRotorConfSortie(){
        return this.rotorConfSortie;
    }
}
