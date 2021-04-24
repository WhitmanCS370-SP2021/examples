/*
 * File: EOFToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class EOFToken extends Token
{
    public EOFToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitEOFToken(this, o);
    }
}
