/*
 * File: MethodDeclaration.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast4.node;

public class MethodDeclaration
        implements Node
{
    private String type;
    private String name;
    private Block body;

    public MethodDeclaration(String type, String name, Block body)
    {
        this.type = type;
        this.name = name;
        this.body = body;
    }

    public Object accept(Visitor visitor, Object o)
    {
        return visitor.visitMethodDeclaration(this, o);
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public Block getBody()
    {
        return body;
    }
}
