package drawer5;

/**
 * This class has a main method for unit testing the drawer5 package.
 * It creates and displays a new DrawingFrame.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class Main
{
    public static void main(String[] args)
    {
        DrawingFrame drawFrame = new DrawingFrame();
        drawFrame.pack();
        drawFrame.setVisible(true);
    }
}
