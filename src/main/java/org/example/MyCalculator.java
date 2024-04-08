package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class MyCalculator {
    public static void main(String[] args) throws Exception {
        var charStreams = CharStreams.fromFileName("./example.txt");
        Double result = calc(charStreams);
        System.out.println("Result = " + result);
    }

    public static Double calc(String expression) {
        return calc(CharStreams.fromString(expression));
    }

    public static Double calc(CharStream charStream) {
        CalculatorLexer lexer = new CalculatorLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.expression();

        ParseTreeWalker walker = new ParseTreeWalker();
        MyCalculatorListener mainListener = new MyCalculatorListener();
        walker.walk(mainListener, tree);
        return mainListener.getResult();
    }
}