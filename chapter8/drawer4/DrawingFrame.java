package drawer4;

import drawer4.figure.Ellipse;
import drawer4.figure.Rect;
import drawer4.figure.Square;
import drawer4.tool.CreationTool;
import drawer4.tool.SelectionTool;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents JFrames with a tool bar across the top containing
 * four buttons labeled "Select", "Rect", "Square", and "Ellipse"
 * and a canvas below for drawing.
 * In the case that one of the latter three buttons is selected,
 * when the user clicks in the canvas, a rectangle,
 * square, or ellipse is drawn centered at the click.
 * If the "Select" button is selected, then clicks and drags in the
 * canvas are used for selecting and dragging figures in the canvas.
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

        DrawingCanvas drawingCanvas = new DrawingCanvas();
        add(drawingCanvas, BorderLayout.CENTER);

        JToolBar toolbar = new JToolBar();
        add(toolbar, BorderLayout.NORTH);

        addToolsAndEditors(toolbar, drawingCanvas);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * creates the buttons for the toolbar, the listeners for the buttons,
     * and the CanvasEditor as MouseListener to the canvas
     * @param toolbar the toolbar for this frame
     * @param canvas the drawing canvas in which figures are drawn
     */
    private void addToolsAndEditors(JToolBar toolbar, DrawingCanvas canvas)
    {
        //add the buttons to the toolbar
        final JButton selectionButton = new JButton("Select");
        toolbar.add(selectionButton);
        toolbar.addSeparator();
        final JButton ellipseButton = new JButton("Ellipse");
        toolbar.add(ellipseButton);
        final JButton squareButton = new JButton("Square");
        toolbar.add(squareButton);
        final JButton rectButton = new JButton("Rect");
        toolbar.add(rectButton);

        //add a listener to all the buttons that highlights the selected button
        ellipseButton.setBorder(new LineBorder(Color.red, 1)); //initially selected
        ActionListener selectionListener = new ActionListener()
        {
            private JButton currentButton = ellipseButton;

            public void actionPerformed(ActionEvent ae)
            {
                JButton newButton = (JButton) ae.getSource();
                if (newButton != currentButton) {
                    //swap borders
                    Border selectedBorder = currentButton.getBorder();
                    currentButton.setBorder(newButton.getBorder());
                    newButton.setBorder(selectedBorder);
                    currentButton = newButton;
                }
            }
        };

        //create the tools associated with the buttons and the editor
        final CreationTool ellipseTool = new CreationTool(new Ellipse(0, 0, 60, 40));
        final CreationTool squareTool = new CreationTool(new Square(0, 0, 50));
        final CreationTool rectTool = new CreationTool(new Rect(0, 0, 60, 40));
        final SelectionTool selectTool = new SelectionTool();
        final CanvasEditor canvasEditor = new CanvasEditor(ellipseTool);

        //set up the button and action listeners and mouse listeners
        selectionButton.addActionListener(selectionListener);
        selectionButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvasEditor.setCurrentTool(selectTool);
            }
        });
        ellipseButton.addActionListener(selectionListener);
        ellipseButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvasEditor.setCurrentTool(ellipseTool);
            }
        });
        squareButton.addActionListener(selectionListener);
        squareButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvasEditor.setCurrentTool(squareTool);
            }
        });
        rectButton.addActionListener(selectionListener);
        rectButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvasEditor.setCurrentTool(rectTool);
            }
        });
        canvas.addMouseListener(canvasEditor);
        canvas.addMouseMotionListener(canvasEditor);
    }
}
