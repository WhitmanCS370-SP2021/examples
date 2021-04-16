package drawer4;

import drawer4.figure.Figure;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents the drawing canvas on which figures are drawn.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class DrawingCanvas extends JPanel
{
    private Drawing drawing;
    private Rectangle selectionRect;

    public DrawingCanvas()
    {
        this.drawing = new Drawing();
        this.selectionRect = new Rectangle();
        setPreferredSize(new Dimension(400, 300));
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(Color.white);
    }

    public void paintComponent(Graphics g)
    {
        //draw the figures and the selection rectangle
        super.paintComponent(g);
        for (Figure figure : drawing) {
            figure.draw(g);
        }
        Color oldColor = g.getColor();
        g.setColor(Color.blue);
        g.drawRect(selectionRect.x, selectionRect.y, selectionRect.width,
                selectionRect.height);
        g.setColor(oldColor);
    }

    public void addFigure(Figure newFigure)
    {
        drawing.addFigure(newFigure);
        repaint();
    }

    public void setSelectionRect(Point corner1, Point corner2)
    {
        selectionRect.setSize(0, 0);
        selectionRect.setLocation(corner1);
        selectionRect.add(corner2);
        repaint();
    }

    public void shrinkSelectionRect()
    {
        selectionRect.setSize(0, 0);
        repaint();
    }

    public void unselectAll()
    {
        drawing.unselectAll();
        repaint();
    }

    public Figure getFigureContaining(int x, int y)
    {
        return drawing.getFigureContaining(x, y);
    }

    public void moveSelectedFigures(int dx, int dy)
    {
        drawing.moveSelectedFigures(dx, dy);
        repaint();
    }

    public void selectFigure(Figure figure)
    {
        drawing.selectFigure(figure);
        repaint();
    }

    public void selectFiguresIntersectingRect()
    {
        drawing.selectIntersectingFigures(selectionRect);
        repaint();
    }
}
