package drawer5.figure;

import java.awt.*;

/**
 * This class represents a rectangular figure.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class Rect extends Figure
{
    public Rect(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }

    public void drawShape(Graphics g)
    {
        Rectangle rect = getBoundingRect();
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }
}
