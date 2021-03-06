package drawer5;

import drawer5.figure.Figure;
import drawer5.figure.GroupFigure;

import java.util.List;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents the drawing (the rectangless, ellipses, and squares)
 * currently displayed in the drawing canvas.
 * It has operations for iterating through all figures,
 * and adding, removing, moving, finding, grouping,
 * ungrouping and selecting figures.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class Drawing
    implements Iterable<Figure>
{
    private List<Figure> figures;

    /**
     * constructor
     */
    public Drawing()
    {
        figures = new ArrayList<Figure>();
    }

    //---------- adding/finding/removing figures ------------

    //precondition:  newFigure is non-null and not already in the drawing
    public void addFigure(Figure newFigure)
    {
        figures.add(newFigure);
    }

    //precondition:  theFigure is in the drawing
    public void removeFigure(Figure theFigure)
    {
        figures.remove(theFigure);
    }

    public Iterator<Figure> iterator()
    {
        return figures.iterator();
    }

    //returns the first figure containing the point (x,y)
    //returns null if no figure contains the point (x,y)
    public Figure getFigureContaining(int x, int y)
    {
        for (Figure figure : figures) {
            if (figure.contains(x, y))
                return figure;
        }
        return null;
    }

    //------------- selecting/unselecting figures ------------

    //precondition:  figure is in the drawing
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

    public void selectFiguresIntersecting(Rectangle selectionRect)
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

    public void removeSelectedFigures()
    {
        List<Figure> figuresToRemove = new ArrayList<Figure>();
        for (Figure figure : figures) {
            if (figure.isSelected()) {
                figuresToRemove.add(figure);
            }
        }
        figures.removeAll(figuresToRemove);
    }

    //does nothing if zero or one figures are selected
    public void groupSelectedFigures()
    {
        //create a list of all selected figures
        List<Figure> group = new ArrayList<Figure>();
        for (Figure figure : figures) {
            if (figure.isSelected()) {
                group.add(figure);
            }
        }
        //replace all selected figures in the drawing with a new group figure.
        if (group.size() > 1) {
            GroupFigure groupFigure = new GroupFigure(group);
            removeSelectedFigures();
            addFigure(groupFigure);
            selectFigure(groupFigure);
        }
    }

    public void ungroupSelectedFigures()
    {
        //find all figures to remove and to add
        List<Figure> figuresToRemove = new ArrayList<Figure>();
        List<Figure> composedFigures = new ArrayList<Figure>();
        for (Figure figure : figures) {
            if (figure.isSelected()) {
                composedFigures.addAll(figure.getComposedFigures());
                figuresToRemove.add(figure);
            }
        }
        //remove the originals
        for (Figure figure : figuresToRemove) {
            removeFigure(figure);
        }
        //add the composed figures
        for (Figure figure : composedFigures) {
            addFigure(figure);
            selectFigure(figure);
        }
    }

}
