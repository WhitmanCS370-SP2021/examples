package drawer0;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents JFrames with a tool bar across the top containing
 * three buttons labeled "Rect", "Square", and "Ellipse" , which do
 * nothing when clicked.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class DrawingFrame extends JFrame
{
    /**
     * constructor that creates but does not display the frame
     */
    public DrawingFrame()
    {
        super("Drawing Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JComponent drawingCanvas = createDrawingCanvas();
        add(drawingCanvas, BorderLayout.CENTER);

        JToolBar toolbar = createToolbar();
        add(toolbar, BorderLayout.NORTH);
    }

    /**
     * creates the canvas (the part of the window below the tool bar)
     * with certain attributes (size, background color, and border)
     * @return the new JComponent making up the canvas
     */
    private JComponent createDrawingCanvas()
    {
        JComponent drawingCanvas = new JPanel();
        drawingCanvas.setPreferredSize(new Dimension(400, 300));
        drawingCanvas.setBackground(Color.white);
        drawingCanvas.setBorder(BorderFactory.createEtchedBorder());
        return drawingCanvas;
    }

    /**
     * creates the tool bar with the three buttons
     * @return the new tool bar
     */
    private JToolBar createToolbar()
    {
        JToolBar toolbar = new JToolBar();
        JButton ellipseButton = new JButton("Ellipse");
        toolbar.add(ellipseButton);
        JButton squareButton = new JButton("Square");
        toolbar.add(squareButton);
        JButton rectButton = new JButton("Rect");
        toolbar.add(rectButton);
        return toolbar;
    }

    /**
     * creates and displays a DrawingFrame object
     * @param args the unused command line arguments
     */
    public static void main(String[] args)
    {
        DrawingFrame drawFrame = new DrawingFrame();
        drawFrame.pack();
        drawFrame.setVisible(true);
    }
}
