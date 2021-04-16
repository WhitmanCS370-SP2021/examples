package drawer3;

import drawer3.figure.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * This class represents the drawing canvas on which figures are drawn.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class DrawingCanvas extends JPanel
{
    private Drawing drawing;

    public DrawingCanvas()
    {
        this.drawing = new Drawing();
        setBackground(Color.white);
        setPreferredSize(new Dimension(400, 300));
        setBorder(BorderFactory.createEtchedBorder());
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for (Figure figure : drawing) {
            figure.draw(g);
        }
    }

    public void addFigure(Figure newFigure)
    {
        drawing.addFigure(newFigure);
        repaint();
    }
}
