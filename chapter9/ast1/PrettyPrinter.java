/*
 * File: PrettyPrinter.java
 * Author: Dale Skrien
 * Date: May 26, 2006
 */
package ast1;

/**
 * This class can take VSSJ code (as a String) and pretty print it
 * (returning the new code as a String).
 * The following output is an example of pretty-printed code:
 *
 * class A {
 *     int x;
 *     void foo() {
 *         ;
 *         x = 3;
 *         while(x) {
 *             foo();
 *         }
 *     }
 *     class B {
 *         int y;
 *         void bar() { }
 *     }
 * }
 */
public class PrettyPrinter
{
    /**
     * constructs a string of tab characters of the given number
     * @param numTabs the number of tabs to be included
     * @return the string of tabs that was constructed
     */
    private String indent(int numTabs)
    {
        String indentString = "";
        for (int i = 0; i < numTabs; i++)
            indentString += "\t";
        return indentString;
    }

    /**
     * constructs a new copy of the program with proper formatting
     * according to Java conventions.
     * @param program the program to be reformatted
     * @return the properly formatted version of the program
     */
    public String prettyPrint(String program)
    {
        Scanner scanner = new Scanner(program);
        String result = "";
        int indentLevel = 0;
        Token currentToken = scanner.getNextToken();
        int currentTokenKind = currentToken.getKind();

        while (currentTokenKind != Token.EOF &&
                currentTokenKind != Token.ERROR) {

            //print current token
            result += currentToken.getSpelling();

            //print spaces, indent, and newlines before the following token.
            //To figure it out, we need to know the following token
            Token nextToken = scanner.getNextToken();
            int nextTokenKind = nextToken.getKind();

            if (currentTokenKind == Token.CLASS ||
                currentTokenKind == Token.EQUALS ) {
                    result += " ";
            }
            else if (currentTokenKind == Token.SYMBOL) {
                if (nextTokenKind != Token.LEFTPAREN &&
                    nextTokenKind != Token.RIGHTPAREN &&
                    nextTokenKind != Token.SEMICOLON)
                        result += " ";
            }
            else if (currentTokenKind == Token.RIGHTPAREN) {
                if (nextTokenKind != Token.SEMICOLON)
                    result += " ";
            }
            else if (currentTokenKind == Token.SEMICOLON ||
                     currentTokenKind == Token.RIGHTBRACE) {
                result += "\n";
                if (nextTokenKind == Token.RIGHTBRACE)
                    indentLevel--;
                result += indent(indentLevel);
            }
            else if (currentTokenKind == Token.LEFTBRACE) {
                if (nextTokenKind == Token.RIGHTBRACE)
                    result += " ";
                else {
                    indentLevel++;
                    result += "\n" + indent(indentLevel);
                }
            }
            //update the currentToken for the next time through the loop
            currentToken = nextToken;
            currentTokenKind = nextTokenKind;
        }
        return result;
    }
}
