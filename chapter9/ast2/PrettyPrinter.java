/*
 * File: PrettyPrinter.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast2;

import ast2.node.Node;

/**
 * This class takes code (in the form of an AST) and pretty prints it
 * (returning the new code as a String).  The following output is an
 * example of what is desired:
 * class A {
 *    int x ;
 *
 *    void foo ( ) {
 *        x = 3 ;
 *        while ( x )
 *            x = 4 ;
 *        while ( x ) {
 *            x = true ;
 *        }
 *    }
 *
 *    void main ( ) {
 *    }
 *}
 *
 */
public class PrettyPrinter
{
    /**
     * constructs a new copy of the program with proper formatting
     * according to Java conventions.
     * @param root the root Node of the ASt representing the program to
     *             be reformatted
     * @param indent the String of whitespace with which the whole program
     *             is to be indented
     * @return the properly formatted version of the program
     */
    public String prettyPrint(Node root, String indent)
    {
        return root.prettyPrint(indent);
    }
}
