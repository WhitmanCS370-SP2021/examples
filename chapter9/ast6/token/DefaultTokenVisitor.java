/*
 * File: DefaultTokenVisitor.java
 * Author: Dale Skrien
 * Date: Jun 7, 2006
 */
package ast6.token;

public class DefaultTokenVisitor implements TokenVisitor
{
    public Object visitClassToken(ClassToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitEOFToken(EOFToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitErrorToken(ErrorToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitIntLiteralToken(IntLiteralToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitSymbolToken(SymbolToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitLeftBraceToken(LeftBraceToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitRightBraceToken(RightBraceToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitLeftParenToken(LeftParenToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitRightParenToken(RightParenToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitSemicolonToken(SemicolonToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitWhileToken(WhileToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitEqualsToken(EqualsToken token, Object o)
    {
        return visitToken(token, o);
    }

    public Object visitToken(Token token, Object o) //default behavior
    {
        return null;
    }

}
