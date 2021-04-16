package drawer2.figure;

import java.awt.*;

/**
 * This abstract class is the superclass of all figures drawn in
 * the drawing canvas.
 * It implements all the methods for dealing with width, height,
 * size and center.
 * It has an abstract draw method.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public abstract class Figure
{
    private int centerX, centerY; //the center coordinates
    private int width;
    private int height;

    public Figure(int centerX, int centerY, int w, int h)
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = w;
        this.height = h;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setCenter(int centerX, int centerY)
    {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public int getCenterX()
    {
        return centerX;
    }

    public int getCenterY()
    {
        return centerY;
    }

    public abstract void draw(Graphics g);

}
