/*
 * File: MethodCall.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast2.node;

public class MethodCall
    implements Node
{
    private String name;

    public MethodCall(String name)
    {
        this.name = name;
    }


    public String prettyPrint(String indent)
    {
        return indent + getName() + "()" + ";";
    }

    public String getName()
    {
        return name;
    }

}
