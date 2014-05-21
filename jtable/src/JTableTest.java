import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * Author :  kimsavinfo
 * Date : 21 mai 21 22:22
 *
 *  - highlight the selected row
 *  - highlight the selected column
 *  - change user input text so that we only save
 *      the first letter in upper case
 *
 * Suggestions, criticism ?
 * Do you have any question or do you want to use my code ?
 * Please do not hesitate to contact me by email
 * kimsavinfo@gmail.com
 */
public class JTableTest extends JTable
{
    static final int ROWS = 50;
    static final int COLUMNS = 4;
    private Object[][] data;
    private String[] headers;

    public JTableTest()
    {
        super(new DefaultTableModel(ROWS, COLUMNS));
        tableSetup();
        setVisible(true);
    }

    private void tableSetup()
    {
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        this.setDefaultRenderer(String.class, dtcr);

        data = new Object[ROWS][COLUMNS];
        headers = new String[COLUMNS];
        for (int column = 0; column < COLUMNS; column++)
        {
            headers[column] = "H " + column;

            for (int row = 0; row < data.length; row++)
            {
                data[row][column] = "R " + row + ", C " + column;

                this.setValueAt(data[row][column], row, column);
            }
        }
    }

    /* ---------
        Highlight
    */
    @Override
    public boolean isCellSelected(int row, int column)
    {
        // Only column :  return isColumnSelected(column) ;
        // Only row : return isRowSelected(column) ;
        // Both :
        return isColumnSelected(column) || isRowSelected(row);
    }

    @Override
    public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend)
    {
        super.changeSelection(rowIndex, columnIndex, false, false);
        repaint(getVisibleRect());
    }

    /* ---------
        Deal with the user input text
     */
    @Override
    public TableCellRenderer getCellRenderer(int row, int column)
    {
        // Update data so you can do whatever we want after
        // So you don't have to do this
        Object value = this.getValueAt(row, column);
        data[row][column] = getValueFirstLetterUpperCase(value);

        // Cell style
        return new MyRenderer();
    }


    @SuppressWarnings("serial")
    private class MyRenderer extends DefaultTableCellRenderer
    {
        public MyRenderer() {	}

        public void setValue(Object value)
        {
            if (value != null)
            {
                if (value instanceof String)
                {
                    // Mettre en maj et ne garder que la 1er lettre
                    setText( getValueFirstLetterUpperCase(value) );
                }
            }
        }
    }

    private String getValueFirstLetterUpperCase( Object p_value )
    {
        String userString = ((String)p_value).toUpperCase();
        userString = String.valueOf(userString.charAt(0));
        return userString;
    }
}
