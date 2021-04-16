package drawer3;

import drawer3.figure.Figure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents the drawing (the rectangless, ellipses, and squares)
 * currently displayed in the drawing canvas.  The only allowable
 * operations are adding new figures and iterating through all figures.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class Drawing
        implements Iterable<Figure>
{
    private List<Figure> figures;  //collection of Figures

    public Drawing()
    {
        figures = new ArrayList<Figure>();
    }

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
}
