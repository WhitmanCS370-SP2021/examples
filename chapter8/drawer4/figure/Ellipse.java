package drawer4.figure;

import java.awt.*;

/**
 * This class represents an elliptical figure.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class Ellipse extends Figure
{
    public Ellipse(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }

    public void drawShape(Graphics g)
    {
        Rectangle rect = getBoundingRect();
        g.drawOval(rect.x, rect.y, rect.width, rect.height);
    }
}
