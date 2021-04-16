package drawer6.tool;

import drawer6.UndoRedoHandler;

import javax.swing.event.MouseInputAdapter;

/**
 * This abstract class is the superclass of all tools in the
 * toolbar.
 *
 * @author Dale Skrien
 * @version 1.0 August 2005
 */
public abstract class Tool extends MouseInputAdapter
{
    private UndoRedoHandler undoRedoHandler;

    public Tool(UndoRedoHandler handler)
    {
        undoRedoHandler = handler;
    }

    public void saveState()
    {
        undoRedoHandler.saveState();
    }
}
