package drawer5;

import drawer5.figure.Ellipse;
import drawer5.figure.Rect;
import drawer5.figure.Square;
import drawer5.tool.CreationTool;
import drawer5.tool.SelectionTool;

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
 * square, or ellipse is drawn, depending on the selected button,
 * centered at the click.
 * If the "Select" button is selected, then clicks and drags in the
 * canvas are used for selecting and dragging figures in the canvas.
 * The window also has a File menu with an exit menu item for quitting
 * and and Edit menu with group and ungroup actions that affect the
 * currently selected figures.
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

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        addMenusAndMenuItems(menubar, drawingCanvas);

        JToolBar toolbar = new JToolBar();
        addToolsAndEditors(toolbar, drawingCanvas);

        add(drawingCanvas, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * creates and adds the menus and menu items for this frame.
     * The menus are the File and Edit menus.  The File menu has just
     * an "Exit" menu item.  The Edit menu has "Group" and "Ungroup" menu items.
     * Appropriate action listeners are added to each menu item.
     * @param menubar the menubar to which the menus are to be added
     * @param canvas the drawing canvas in which the figures are to be grouped
     */
    private void addMenusAndMenuItems(JMenuBar menubar,
                                      final DrawingCanvas canvas)
    {
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        JMenu editMenu = new JMenu("Edit");
        menubar.add(editMenu);
        JMenuItem groupMenuItem = new JMenuItem("Group");
        groupMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvas.groupSelectedFigures();
            }
        });
        editMenu.add(groupMenuItem);
        JMenuItem unGroupMenuItem = new JMenuItem("Ungroup");
        unGroupMenuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                canvas.ungroupSelectedFigures();
            }
        });
        editMenu.add(unGroupMenuItem);
    }

    /**
     * creates the buttons for the toolbar, the listeners for the buttons,
     * and the CanvasEditor as MouseListener to the canvas
     * @param toolbar the toolbar for this frame
     * @param canvas the drawing canvas in which figures are drawn
     */
    private void addToolsAndEditors(JToolBar toolbar,
                                    final DrawingCanvas canvas)
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

        //add a listener to the buttons that highlights the selected button
        ellipseButton.setBorder(new LineBorder(Color.red, 2)); //initially selected
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
        final CreationTool ellipseTool =
                new CreationTool(new Ellipse(0, 0, 60, 40));
        final CreationTool squareTool = new CreationTool(new Square(0, 0, 50));
        final CreationTool rectTool = new CreationTool(new Rect(0, 0, 60, 40));
        final SelectionTool selectTool = new SelectionTool();
        final CanvasEditor canvasEditor = new CanvasEditor(ellipseTool);

        //set up the button and mouse listeners
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
