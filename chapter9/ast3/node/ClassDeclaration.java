/*
 * File: ClassDeclaration.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast3.node;

import java.util.List;
import java.util.Iterator;

/**
 * A class representing a whole class
 */
public class ClassDeclaration
        implements Node
{
    private String name;
    private List<Node> declarations;

    public ClassDeclaration(String name, List<Node> classDeclarations)
    {
        this.name = name;
        this.declarations = classDeclarations;
    }


    public String prettyPrint(String indent)
    {
        String result = indent + "class " + getName() + " {\n";
        for (Iterator it = getDeclarations().iterator(); it.hasNext();) {
            Node node = (Node) it.next();
            result += node.prettyPrint(indent + "    ") + "\n";
            if (it.hasNext())
                result += "\n"; //add blank line between declarations
        }
        result += indent + "}";
        return result;
    }

    public boolean findMethod(String methodName, String desiredClassName,
                              String currentClassName)
    {
        for (Node node : getDeclarations()) {
            if (node.findMethod(methodName, desiredClassName,
                                (currentClassName.equals("") ? getName() :
                                                 currentClassName + "." + getName())))
                return true;
        }
        return false;
    }

    public List<Node> getDeclarations()
    {
        return declarations;
    }

    public String getName()
    {
        return name;
    }
}
