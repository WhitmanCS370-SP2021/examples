package ast6.token;
/*
 * File: TokenVisitor.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */

public interface TokenVisitor
{
    Object visitClassToken(ClassToken classToken, Object o);

    Object visitEOFToken(EOFToken eofToken, Object o);

    Object visitErrorToken(ErrorToken errorToken, Object o);

    Object visitIntLiteralToken(IntLiteralToken intLiteralToken, Object o);

    Object visitSymbolToken(SymbolToken symbolToken, Object o);

    Object visitLeftBraceToken(LeftBraceToken lBraceToken, Object o);

    Object visitRightBraceToken(RightBraceToken rBraceToken, Object o);

    Object visitLeftParenToken(LeftParenToken lParenToken, Object o);

    Object visitRightParenToken(RightParenToken rParenToken, Object o);

    Object visitSemicolonToken(SemicolonToken semicolonToken, Object o);

    Object visitWhileToken(WhileToken whileToken, Object o);

    Object visitEqualsToken(EqualsToken equalsToken, Object o);

    Object visitToken(Token token, Object o); //default visit
}
