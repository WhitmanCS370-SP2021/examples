package drawer3;

import drawer3.figure.Ellipse;
import drawer3.figure.Rect;
import drawer3.figure.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    //constructor
    public DrawingFrame()
    {
        super("Drawing Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create and add the canvas
        DrawingCanvas drawingCanvas = new DrawingCanvas();
        add(drawingCanvas, BorderLayout.CENTER);

        JToolBar toolbar = createToolbar(drawingCanvas);
        add(toolbar, BorderLayout.NORTH);

    }


    /**
     * creates the tool bar with the three buttons, a
     * CanvasEditor that it registers as MouseListener to the canvas,
     * and listeners for each button that notify the editor of
     * the selected button.
     * @param drawingCanvas the DrawingCanvas in which the drawings appear
     * @return the new tool bar
     */
    private JToolBar createToolbar(DrawingCanvas drawingCanvas)
    {
        JToolBar toolbar = new JToolBar();
        JButton ellipseButton = new JButton("Ellipse");
        toolbar.add(ellipseButton);
        JButton squareButton = new JButton("Square");
        toolbar.add(squareButton);
        JButton rectButton = new JButton("Rect");
        toolbar.add(rectButton);
        add(toolbar, BorderLayout.NORTH);

        //create the editor and add listeners
        final CanvasEditor canvasEditor =
                new CanvasEditor(new Ellipse(0, 0, 60, 40));

        ellipseButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvasEditor.setCurrentFigure(new Ellipse(0, 0, 60, 40));
            }
        });
        squareButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvasEditor.setCurrentFigure(new Square(0, 0, 50));
            }
        });
        rectButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvasEditor.setCurrentFigure(new Rect(0, 0, 60, 40));
            }
        });
        drawingCanvas.addMouseListener(canvasEditor);

        return toolbar;
    }
}
