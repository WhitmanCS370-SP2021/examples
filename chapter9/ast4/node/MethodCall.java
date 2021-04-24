/*
 * File: MethodCall.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */
package ast4.node;

public class MethodCall
    implements Node
{
    private String name;

    public MethodCall(String name)
    {
        this.name = name;
    }


    public Object accept(Visitor visitor, Object o)
    {
        return visitor.visitMethodCall(this, o);
    }

    public String getName()
    {
        return name;
    }

}
