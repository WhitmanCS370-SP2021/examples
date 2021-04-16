package drawer4;

import drawer4.figure.Figure;

import java.util.List;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents the drawing (the rectangless, ellipses, and squares)
 * currently displayed in the drawing canvas.
 * It has operations for iterating through all figures,
 * and adding, moving, finding, and selecting figures.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class Drawing implements Iterable<Figure>
{
    private List<Figure> figures;

    /**
     * constructor
     */
    public Drawing()
    {
        figures = new ArrayList<Figure>();
    }

    //---------- adding/finding figures ------------

    //precondition:  newFigure is non-null and is not already in
    //this Drawing
    public void addFigure(Figure newFigure)
    {
        figures.add(newFigure);
    }

    public Iterator<Figure> iterator()
    {
        return figures.iterator();
    }

    public Figure getFigureContaining(int x, int y)
    {
        for (int i = figures.size() - 1; i >= 0; i--) {
            Figure figure = figures.get(i);
            if (figure.contains(x, y))
                return figure;
        }
        return null;
    }

    //------------- selecting/moving figures ------------

    //precondition:  figure is non-null and is in this Drawing
    public void selectFigure(Figure figure)
    {
        figure.setSelected(true);
    }

    public void selectAll()
    {
        for (Figure figure : figures) {
            figure.setSelected(true);
        }
    }

    public void unselectAll()
    {
        for (Figure figure : figures) {
            figure.setSelected(false);
        }
    }

    public void selectIntersectingFigures(Rectangle selectionRect)
    {
        for (Figure figure : figures) {
            if (figure.intersects(selectionRect)) {
                figure.setSelected(true);
            }
            else {
                figure.setSelected(false);
            }
        }
    }

    public void moveSelectedFigures(int dx, int dy)
    {
        for (Figure figure : figures) {
            if (figure.isSelected()) {
                figure.move(dx, dy);
            }
        }
    }

}
