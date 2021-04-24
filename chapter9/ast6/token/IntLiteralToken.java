/*
 * File: IntLiteralToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class IntLiteralToken extends Token
{
    public IntLiteralToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitIntLiteralToken(this, o);
    }
}
