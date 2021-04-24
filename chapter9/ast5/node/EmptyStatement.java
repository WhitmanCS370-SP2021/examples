/*
 * File: EmptyStatement.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast5.node;

public class EmptyStatement
    implements Node
{
    public EmptyStatement()
    {
    }

    public Object accept(Visitor visitor, Object o)
    {
        return visitor.visitEmptyStatement(this, o);
    }
}
