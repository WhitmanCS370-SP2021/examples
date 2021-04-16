package drawer1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class acts as listeners for clicks to the buttons in the
 * toolbar and for clicks in the canvas.  It causes a rectangle,
 * square, or ellipse, depending on the last clicked button,
 * to be drawn centered at the click.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class CanvasEditor
        implements ActionListener, MouseListener
{
    /** the currently selected button in the toolbar */
    private JButton currentButton;

    /**
     * constructs a CanvasEditor
     * @param initialButton the initially selected button
     */
    public CanvasEditor(JButton initialButton)
    {
        this.currentButton = initialButton;
    }

    /**
     * saves a reference to the button that was just clicked
     * @param ae the ActionEvent with details of the action
     */
    public void actionPerformed(ActionEvent ae)
    {
        currentButton = (JButton) ae.getSource();
    }

    /**
     * draws a figure in the canvas centered at the click.
     * The figure drawn depends on the currently selected button
     * @param e the MouseEvent with details of the mouse click
     */
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        JPanel canvas = (JPanel) e.getSource();
        if (currentButton.getText().equals("Ellipse"))
            canvas.getGraphics().drawOval(x - 30, y - 20, 60, 40);
        else if (currentButton.getText().equals("Rect"))
            canvas.getGraphics().drawRect(x - 30, y - 20, 60, 40);
        else //if( currentButton.getText().equals("Square") )
            canvas.getGraphics().drawRect(x - 25, y - 25, 50, 50);
    }

    /*
     * empty method implementations, needed to implement the
     * MouseListener interface
     */
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
}