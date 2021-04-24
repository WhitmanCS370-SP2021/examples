/*
 * File: MethodDeclaration.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast3.node;

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

    public boolean findMethod(String methodName, String desiredClassName,
                              String currentClassName)
    {
        return desiredClassName.equals(currentClassName) &&
               getName().equals(methodName);
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
