/*
 * File: IntLiteral.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast2.node;

public class IntLiteral
    implements Node
{
    private int value;

    public IntLiteral(int value)
    {
        this.value = value;
    }

    public String prettyPrint(String indent)
    {
        return indent + getValue();
    }

    public int getValue()
    {
        return value;
    }
}
