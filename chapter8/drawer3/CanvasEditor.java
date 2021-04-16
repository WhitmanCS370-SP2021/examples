package drawer3;

import drawer3.figure.Figure;

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
public class CanvasEditor implements MouseListener
{
    //instance variables
    private Figure currentFigure;

    //constructor
    public CanvasEditor(Figure initialFigure)
    {
        this.currentFigure = initialFigure;
    }

    public void setCurrentFigure(Figure newFigure)
    {
        currentFigure = newFigure;
    }

    public void mouseClicked(MouseEvent e)
    {
        Figure newFigure = (Figure) currentFigure.clone();
        newFigure.setCenter(e.getX(), e.getY());
        ((DrawingCanvas) e.getSource()).addFigure(newFigure);
    }

    /*
     * empty method implementations, needed to implement the
     * MouseListener interface
     */
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) { }
}