package drawer2;

import drawer2.figure.Figure;

import javax.swing.*;
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
        implements MouseListener
{
    /** the figure to be drawn when a click occurs in the canvas */
    private Figure currentFigure;

    /**
     * constructs a CanvasEditor that initially draws the given figure
     * @param figure The initial Figure to be drawn when a click occurs in
     *               the canvas.
     */
    public CanvasEditor(Figure figure)
    {
        this.currentFigure = figure;
    }

    /**
     * change the figure to be drawn when the canvas is clicked
     * @param newFigure the new Figure to be drawn
     */
    public void setCurrentFigure(Figure newFigure)
    {
        currentFigure = newFigure;
    }

    /**
     * draws the current figure centered at the point of the mouse click
     * @param e the MouseEvent giving the position of the click
     */
    public void mouseClicked(MouseEvent e)
    {
        JPanel canvas = (JPanel) e.getSource();
        currentFigure.setCenter(e.getX(), e.getY());
        currentFigure.draw(canvas.getGraphics());
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