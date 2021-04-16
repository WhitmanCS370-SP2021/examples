package drawer5.tool;

import drawer5.DrawingCanvas;
import drawer5.figure.Figure;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This  class represents tools that listen for mouse events in a
 * drawing canvas.  When such an event is detected, figures in the
 * canvas are selected, unselected, or dragged, depending on where the
 * initial mouse press occurred and what figures in the canvas are
 * selected.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class SelectionTool extends Tool
{
    /**
     * the location of the latest mouse press or click
     */
    private Point origin;
    /**
     * pressInFigure is true if the mouse press or click was inside a figure
     */
    private boolean pressInFigure;

    public SelectionTool()
    {
        origin = new Point(0, 0);
        pressInFigure = false;
    }

    public void mouseClicked(MouseEvent e)
    {
        DrawingCanvas canvas = (DrawingCanvas) e.getSource();
        Figure figure = canvas.getFigureContaining(e.getX(), e.getY());
        pressInFigure = (figure != null);
        if (pressInFigure && ! figure.isSelected())
            canvas.unselectAll();
        if (pressInFigure)
            figure.setSelected(true);
        origin.x = e.getX();
        origin.y = e.getY();
    }

    public void mousePressed(MouseEvent e)
    {
        mouseClicked(e);
    }

    public void mouseReleased(MouseEvent e)
    {
        DrawingCanvas canvas = (DrawingCanvas) e.getSource();
        canvas.shrinkSelectionRect();
    }

    public void mouseDragged(MouseEvent e)
    {
        if (pressInFigure)
            updateDraggingFigures(e);
        else
            updateSelectionRect(e);
    }

    private void updateDraggingFigures(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        DrawingCanvas canvas = (DrawingCanvas) e.getSource();
        canvas.moveSelectedFigures(x - origin.x, y - origin.y);
        origin.x = x;
        origin.y = y;
    }

    private void updateSelectionRect(MouseEvent e)
    {
        DrawingCanvas canvas = (DrawingCanvas) e.getSource();
        canvas.setSelectionRect(origin, e.getPoint());
        canvas.selectFiguresIntersectingRect();
    }

}
