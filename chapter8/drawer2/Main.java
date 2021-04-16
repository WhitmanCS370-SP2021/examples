package drawer2;

/**
 * This class has a main method that creates and displays a new DrawingFrame.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class Main
{
    /**
     * creates and displaying a DrawingFrame.
     * @param args the unused command line arguments
     */
    public static void main(String[] args)
    {
        DrawingFrame drawFrame = new DrawingFrame();
        drawFrame.pack();
        drawFrame.setVisible(true);
    }
}
