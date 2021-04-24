/*
 * File: Parser.java
 * Author: Dale Skrien
 * Date: May 29, 2006
 */
package ast5;

import ast5.node.*;

import java.util.List;
import java.util.ArrayList;

public class Parser
{
    private Scanner scanner;
    private Token currentToken;
    private DefaultBuilder builder;

    public Parser()
    {
        this.builder = null;
        this.scanner = null;
        this.currentToken = null;
    }

    public Node parse(String code, DefaultBuilder builder)
    {
        this.builder = builder;
        this.scanner = new Scanner(code);
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
        if( currentToken.getKind() == Token.SEMICOLON) {
            advance();
            return builder.buildVarDeclaration(type, name);
        }
        else if( currentToken.getKind() == Token.LEFTPAREN) {
            advance();
            matchAndAdvance(Token.RIGHTPAREN);
            Block body = parseBlock();
            return builder.buildMethodDeclaration(type, name, body);
        }
        else {
            matchAndAdvance(Token.LEFTBRACE);
            List<Node> children = new ArrayList<Node>();
            while( currentToken.getKind() != Token.RIGHTBRACE) {
                children.add(parseDeclaration());
            }
            advance();
            return builder.buildClassDeclaration(name, children);
        }
    }

    private Block parseBlock()
    {
        matchAndAdvance(Token.LEFTBRACE);
        List<Node> statements = new ArrayList<Node>();
        while( currentToken.getKind() != Token.RIGHTBRACE) {
            statements.add(parseStatement());
        }
        matchAndAdvance(Token.RIGHTBRACE);
        return builder.buildBlock(statements);
    }

    private Node parseStatement()
    {
        if( currentToken.getKind() == Token.WHILE ) {
            advance();
            matchAndAdvance(Token.LEFTPAREN);
            String cond = currentToken.getSpelling();
            advance();
            matchAndAdvance(Token.RIGHTPAREN);
            Block body = parseBlock();
            return builder.buildWhileStatement(cond, body);
        }
        else if (currentToken.getKind() == Token.SEMICOLON) {
            advance();
            return builder.buildEmptyStatement();
        }
        else if( currentToken.getKind() == Token.SYMBOL) {
            String name = currentToken.getSpelling();
            advance();
            if(currentToken.getKind() == Token.LEFTPAREN) {
                advance();
                matchAndAdvance(Token.RIGHTPAREN);
                matchAndAdvance(Token.SEMICOLON);
                return builder.buildMethodCall(name);
            }
            else if(currentToken.getKind() == Token.EQUALS) {
                advance();
                IntLiteral value = parseIntLiteral();
                matchAndAdvance(Token.SEMICOLON);
                return builder.buildAssignStatement(name, value);
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
        } catch(NumberFormatException e) {
            error("Illegal integer value: " + currentToken);
        }
        return builder.buildIntLiteral(value);
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
