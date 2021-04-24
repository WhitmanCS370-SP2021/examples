/*
 * File: VarDeclaration.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast5.node;

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

    public Object accept(Visitor visitor, Object o)
    {
        return visitor.visitVarDeclaration(this, o);
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
