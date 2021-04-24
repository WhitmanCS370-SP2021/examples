/*
 * File: EmptyStatement.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast3.node;

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

    public boolean findMethod(String methodName, String desiredClassName,
                              String currentClassName)
    {
        return false;
    }
}
