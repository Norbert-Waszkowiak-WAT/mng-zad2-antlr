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
    gradle test
Za całe zadanie przeiwidzane jest 