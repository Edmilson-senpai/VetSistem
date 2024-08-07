
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class colorCelda extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         //To change body of generated methods, choose Tools | Templates.
         /*
        for (int i = 0; i < table.getRowCount(); i++) {
            
        }*/
        
        int stk = Integer.parseInt(table.getValueAt(row, 4).toString());

            if (stk <= 10) {
                setBackground(Color.red);
                setForeground(Color.white);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
    }

    /*
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, column);

        for (int i = 0; i < table.getRowCount(); i++) {
            int stk = Integer.parseInt(table.getValueAt(row, 4).toString());

            if (stk <= 10) {
                setBackground(Color.red);
                setForeground(Color.white); 
            } else {
                setBackground(Color.white);
                setForeground(Color.black); 
            }
        }
        return this;
    }
     */
}
