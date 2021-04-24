/*
 * File: ClassDeclaration.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast4.node;

import java.util.List;

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


    public Object accept(Visitor visitor, Object o)
    {
        return visitor.visitClassDeclaration(this, o);
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
