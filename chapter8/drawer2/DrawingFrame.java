package drawer2;

import drawer2.figure.Ellipse;
import drawer2.figure.Rect;
import drawer2.figure.Square;

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
     * creates the tool bar with the three buttons, a
     * CanvasEditor that it registers as MouseListener to the canvas,
     * and listeners for each button that notify the editor of
     * the selected button.
     * @param canvas the JComponent in which the drawings appear
     * @return the new tool bar
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

        //add the listeners to the buttons and canvas
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
        canvas.addMouseListener(canvasEditor);

        return toolbar;
    }
}
