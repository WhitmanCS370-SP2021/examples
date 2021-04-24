/*
 * File: IntLiteral.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast6.node;

public class IntLiteral
    implements Node
{
    private int value;

    public IntLiteral(int value)
    {
        this.value = value;
    }

    public Object accept(NodeVisitor visitor, Object o)
    {
        return visitor.visitIntLiteral(this, o);
    }

    public int getValue()
    {
        return value;
    }
}
