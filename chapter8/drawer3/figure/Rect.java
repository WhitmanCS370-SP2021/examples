package drawer3.figure;

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

    public void draw(Graphics g)
    {
        int width = getWidth();
        int height = getHeight();
        g.drawRect(getCenterX() - width / 2, getCenterY() - height / 2,
                width, height);
    }
}
