package ast3.node;
/*
 * File: Node.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */

public interface Node
{
    String prettyPrint(String indent);
    boolean findMethod(String methodName, String desiredClassName,
                       String currentClassName);
}
