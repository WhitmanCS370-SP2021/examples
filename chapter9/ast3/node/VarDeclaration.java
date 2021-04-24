/*
 * File: VarDeclaration.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast3.node;

public class VarDeclaration
    implements Node
{
    private String type;
    private String name;

    public VarDeclaration(String type, String name)
    {
        this.type = type;
        this.name = name;
    }

    public String prettyPrint(String indent)
    {
        return indent + getType() + " " + getName() + ";";
    }

    public boolean findMethod(String methodName, String desiredClassName,
                              String currentClassName)
    {
        return false;
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

}
