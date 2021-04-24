/*
 * File: MethodFinder.java
 * Author: Dale Skrien
 * Date: Jun 4, 2006
 */
package ast3;

import ast3.node.*;

/**
 * This class is able to search an AST representing a VSSJ program
 * for the existence of a particular method in a particular class.
 * If class A has an inner class named B, then the
 * MethodFinder refers to the inner class as "A.B".
 */
public class MethodFinder
{
    /**
     * determines whether a program contains a method by the given name
     * in a class with the given name.
     * If the class is an inner class, then its full name including the outer
     * class names separated by periods is used.  For example, if class A
     * contains class B which contains class C, then the innermost class is
     * referred to by "A.B.C".
     * @param methodName the name of the method we are searching for
     * @param className the full name of the class containing the desired method
     * @param root the root Node of the AST representing the program to be
     *             searched
     * @return true if a method with the desired name is found in the desired
     *              class in the program represented by the AST with the given
     *              root.
     */
    public boolean findMethod(String methodName, String className, Node root)
    {
        return root.findMethod(methodName, className, "");
    }
}
