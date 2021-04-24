/*
 * File: ErrorToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class ErrorToken extends Token
{
    public ErrorToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitErrorToken(this, o);
    }
}
