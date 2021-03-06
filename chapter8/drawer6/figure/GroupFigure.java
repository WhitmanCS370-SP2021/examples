package drawer6.figure;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a composite figure composed of other
 * simple or composite figures.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class GroupFigure extends Figure
{
    private ArrayList<Figure> children;

    // precondition:  figures has at least one Figure
    public GroupFigure(Collection<Figure> figures)
    {
        super(0, 0, 0, 0);
        children = new ArrayList<Figure>();
        children.addAll(figures);

        //construct the new bounding rectangle
        Rectangle boundingRect = null;
        for (Figure figure : figures) {
            Rectangle nextRect = figure.getBoundingRect();
            if (boundingRect == null) {
                boundingRect = nextRect;
            }
            else {
                boundingRect.add(nextRect);
            }
        }
        super.moveTo(boundingRect.x, boundingRect.y);
        super.setSize(boundingRect.width, boundingRect.height);
    }

    //stretches figure leaving the upper-left corner fixed
    public void setSize(int width, int height)
    {
        super.setSize(width, height);
        //...incomplete...
        //This method needs to stretch the composed figures as well as the
        //group figure.
    }

    public void drawShape(Graphics g)
    {
        for (Figure child : children) {
            child.drawShape(g);
        }
    }

    public void move(int dx, int dy)
    {
        super.move(dx, dy);
        for (Figure child : children) {
            child.move(dx, dy);
        }
    }

    public void moveTo(int x, int y)
    {
        super.move(x, y);
        //...incomplete...
        //this method needs to move the composed figures aw well as the
        //group figure.
    }

    public ArrayList<Figure> getComposedFigures()
    {
        ArrayList<Figure> list = new ArrayList<Figure>();
        list.addAll(children);
        return list;
    }

    public Object clone()
    {
        GroupFigure clone = (GroupFigure) super.clone();
        clone.children = (ArrayList<Figure>) this.children.clone();
        for (int i = 0; i < clone.children.size(); i++) {
            clone.children.set(i, (Figure) clone.children.get(i).clone());
        }
        return clone;
    }
}
