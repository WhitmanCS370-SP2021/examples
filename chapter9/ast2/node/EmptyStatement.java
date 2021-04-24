/*
 * File: EmptyStatement.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast2.node;

public class EmptyStatement
    implements Node
{
    public EmptyStatement()
    {
    }

    public String prettyPrint(String indent)
    {
        return indent + ";";
    }
}
