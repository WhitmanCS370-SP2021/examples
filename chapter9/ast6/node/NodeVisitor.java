package ast6.node;
/*
 * File: NodeVisitor.java
 * Author: Dale Skrien
 * Date: May 28, 2006
 */

public interface NodeVisitor
{
    Object visitClassDeclaration(ClassDeclaration node, Object o);

    Object visitMethodDeclaration(MethodDeclaration node, Object o);

    Object visitVarDeclaration(VarDeclaration node, Object o);

    Object visitAssignStatement(AssignStatement node, Object o);

    Object visitBlock(Block node, Object o);

    Object visitEmptyStatement(EmptyStatement node, Object o);

    Object visitWhileStatement(WhileStatement node, Object o);

    Object visitMethodCall(MethodCall node, Object o);

    Object visitIntLiteral(IntLiteral node, Object o);
}
