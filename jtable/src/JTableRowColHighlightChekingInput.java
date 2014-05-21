/**
 * Author :  kimsavinfo
 * Date : 21 mai 21 20:11
 *
 * Subject :
 * Training with jtables
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
import javax.swing.*;

public class JTableRowColHighlightChekingInput
{
    private JTableTest tableTest;

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {

            @Override
            public void run()
            {
                new JTableRowColHighlightChekingInput().configWindow();
            }
        });
    }

    public void configWindow()
    {
        tableTest = new JTableTest();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.add(new JScrollPane(tableTest));
        frame.setVisible(true);
    }
}