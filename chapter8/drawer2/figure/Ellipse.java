package drawer2.figure;

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

    public void draw(Graphics g)
    {
        int width = getWidth();
        int height = getHeight();
        g.drawOval(getCenterX() - width / 2, getCenterY() - height / 2,
                width, height);
    }
}
