/*
 * File: ClassToken.java
 * Author: Dale Skrien
 * Date: Jun 6, 2006
 */
package ast6.token;

public class ClassToken extends Token
{
    public ClassToken(String s, int p)
    {
        super(s, p);
    }

    public Object accept(TokenVisitor v, Object o)
    {
        return v.visitClassToken(this, o);
    }
}
