/*
 * File: Parser.java
 * Author: Dale Skrien
 * Date: May 29, 2006
 */
package ast2;

import ast2.node.*;

import java.util.List;
import java.util.ArrayList;

public class Parser
{
    private Scanner scanner;
    private Token currentToken;

    public Parser()
    {
        this.scanner = null;
        this.currentToken = null;
    }

    public Node parse(String code)
    {
        scanner = new Scanner(code);
        advance(); //get the first token

        Node root = parseDeclaration();  //build the whole AST

        //do final error checking
        if (! (root instanceof ClassDeclaration))
            error("A program must consist of a class declaration.");
        else if (currentToken.getKind() != Token.EOF)
            //There are leftover tokens
            error("The end of the program expected at position: " +
                    currentToken.getPosition());
        return root;
    }

    private Node parseDeclaration()
    {
        if (currentToken.getKind() != Token.SYMBOL &&
                currentToken.getKind() != Token.CLASS) {
            error("The wrong kind of token (" + currentToken +
                    ") was found at position " +
                    currentToken.getPosition());
        }
        String type = currentToken.getSpelling();
        advance();
        String name = currentToken.getSpelling();
        matchAndAdvance(Token.SYMBOL);
        if (currentToken.getKind() == Token.SEMICOLON) {
            advance();
            return new VarDeclaration(type, name);
        }
        else if (currentToken.getKind() == Token.LEFTPAREN) {
            advance();
            matchAndAdvance(Token.RIGHTPAREN);
            Block body = parseBlock();
            return new MethodDeclaration(type, name, body);
        }
        else {
            matchAndAdvance(Token.LEFTBRACE);
            List<Node> children = new ArrayList<Node>();
            while (currentToken.getKind() != Token.RIGHTBRACE) {
                children.add(parseDeclaration());
            }
            advance();
            return new ClassDeclaration(name, children);
        }
    }

    private Block parseBlock()
    {
        matchAndAdvance(Token.LEFTBRACE);
        List<Node> statements = new ArrayList<Node>();
        while (currentToken.getKind() != Token.RIGHTBRACE) {
            statements.add(parseStatement());
        }
        matchAndAdvance(Token.RIGHTBRACE);
        return new Block(statements);
    }

    private Node parseStatement()
    {
        if (currentToken.getKind() == Token.WHILE) {
            advance();
            matchAndAdvance(Token.LEFTPAREN);
            String cond = currentToken.getSpelling();
            advance();
            matchAndAdvance(Token.RIGHTPAREN);
            Block body = parseBlock();
            return new WhileStatement(cond, body);
        }
        else if (currentToken.getKind() == Token.SEMICOLON) {
            advance();
            return new EmptyStatement();
        }
        else if (currentToken.getKind() == Token.SYMBOL) {
            String name = currentToken.getSpelling();
            advance();
            if (currentToken.getKind() == Token.LEFTPAREN) {
                advance();
                matchAndAdvance(Token.RIGHTPAREN);
                matchAndAdvance(Token.SEMICOLON);
                return new MethodCall(name);
            }
            else if (currentToken.getKind() == Token.EQUALS) {
                advance();
                IntLiteral value = parseIntLiteral();
                matchAndAdvance(Token.SEMICOLON);
                return new AssignStatement(name, value);
            }
            else {
                error("Incorrect Token: " + currentToken);
                return null;
            }
        }
        else {
            error("Incorrect Token: " + currentToken);
            return null;
        }
    }

    private IntLiteral parseIntLiteral()
    {
        int value = 0;
        try {
            value = Integer.parseInt(currentToken.getSpelling());
            advance();
        } catch (NumberFormatException e) {
            error("Illegal integer value: " + currentToken);
        }
        return new IntLiteral(value);
    }

    private void advance()
    {
        currentToken = scanner.getNextToken();
    }

    private void matchAndAdvance(int kind)
    {
        if (currentToken.getKind() != kind)
            error("The wrong kind of token (" + currentToken +
                    ") was found at position " +
                    currentToken.getPosition());
        advance();
    }

    private void error(String message)
    {
        throw new ParseException("Parse error: " + message);
    }

    private class ParseException extends RuntimeException
    {
        public ParseException(String message)
        {
            super(message);
        }
    }
}
