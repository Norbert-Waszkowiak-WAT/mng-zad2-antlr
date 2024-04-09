# MNG/zad2/antlr

Opracuj gramatykę kalkulatora, wygeneruj Lexer i Parser, a następnie zaimplementuj jego działanie, rozszerzając wybraną implementując klase MyCalculatorListener.

Wymagana funkcjonalności to: 
- dodawanie, 
- odejmowanie,
- mnożenie, 
- dzielenie,
- potęgowanie,
- pierwiastkowanie
- logarytmowanie
- funkcje trygonometryczne

Edytuj wyłącznie plik `MyCalculatorListener.java`.

# Aby wygenerować klasy z gramatyki należy wykonać poniższą komendę
    java -jar ./antlr-4.11.1-complete.jar -listener Calculator.g4 -o src/main/java/org/example/ -package "org.example"

# Aby urchomić testy należy wykonać poniższą komendę:
    gradle test --tests org.example.MyCalculatorTest.test1
    gradle test --tests org.example.MyCalculatorTest.test2
    gradle test --tests org.example.MyCalculatorTest.test3
    gradle test --tests org.example.MyCalculatorTest.test4
    gradle test --tests org.example.MyCalculatorTest.test5
    gradle test --tests org.example.MyCalculatorTest.test6
    gradle test --tests org.example.MyCalculatorTest.test7
    gradle test --tests org.example.MyCalculatorTest.test8
    gradle test --tests org.example.MyCalculatorTest.test9
    gradle test --tests org.example.MyCalculatorTest.test10
    gradle test --tests org.example.MyCalculatorTest.test11
    gradle test --tests org.example.MyCalculatorTest.test12
Każdy test jest warty 10 pkt.