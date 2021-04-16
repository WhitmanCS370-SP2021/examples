package drawer1;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents JFrames with a tool bar across the top containing
 * three buttons labeled "Rect", "Square", and "Ellipse" and a canvas
 * below for drawing.  When the user clicks in the canvas, a rectangle,
 * square, or ellipse is drawn, depending on the selected button,
 * centered at the click.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public class DrawingFrame extends JFrame
{
    /**
     * constructs but does not display a new DrawingFrame
     */
    public DrawingFrame()
    {
        super("Drawing Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JComponent drawingCanvas = createDrawingCanvas();
        add(drawingCanvas, BorderLayout.CENTER);

        JToolBar toolbar = createToolbar(drawingCanvas);
        add(toolbar, BorderLayout.NORTH);
    }

    /**
     * creates the canvas (the part of the window below the tool bar)
     * with certain attributes (size, background color, and border)
     * @return the new JComponent that is the canvas
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
     * creates the tool bar with the three buttons and creates a
     * CanvasEditor that it registers as listener to the three buttons
     * @return the new tool bar
     * @param canvas the JComponent forming the drawing canvas
     */
    private JToolBar createToolbar(JComponent canvas)
    {
        JToolBar toolbar = new JToolBar();
        //add the buttons to the toolbar
        JButton ellipseButton = new JButton("Ellipse");
        toolbar.add(ellipseButton);
        JButton squareButton = new JButton("Square");
        toolbar.add(squareButton);
        JButton rectButton = new JButton("Rect");
        toolbar.add(rectButton);

        //add the CanvasEditor listener to the canvas and to the buttons,
        //with the ellipseButton initially selected
        CanvasEditor canvasEditor = new CanvasEditor(ellipseButton);
        ellipseButton.addActionListener(canvasEditor);
        squareButton.addActionListener(canvasEditor);
        rectButton.addActionListener(canvasEditor);
        canvas.addMouseListener(canvasEditor);

        return toolbar;
    }
}
