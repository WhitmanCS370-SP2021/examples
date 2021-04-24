/*
 * File: MethodDeclaration.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast2.node;

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

    public String prettyPrint(String indent)
    {
        String result = indent + getType() + " " + getName() +
                "() ";
        result += getBody().prettyPrint(indent);
        return result;
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
