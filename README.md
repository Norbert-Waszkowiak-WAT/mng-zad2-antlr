# MNG/zad2/antlr

## Zadanie: Opracowanie gramatyki kalkulatora

Celem tego zadania jest stworzenie kalkulatora, który będzie potrafił wykonywać podstawowe operacje matematyczne. Do
tego celu użyjemy narzędzia ANTLR, które pozwala na generowanie lexerów i parserów na podstawie zdefiniowanej gramatyki.

### Krok 1: Zrozumienie pojęć Lexer i Parser

#### Lexer

Lexer, znany również jako skaner, to program, który analizuje ciąg wejściowy i dzieli go na tokeny. Tokeny to znaki lub
grupy znaków, które mają specjalne znaczenie dla języka programowania. Na przykład, w języku Java, tokeny mogą obejmować
słowa kluczowe takie jak `public`, `class`, `void`, identyfikatory (nazwy zmiennych lub metod),
operatory (`+`, `-`, `*`, `/`), nawiasy (`(`, `)`, `{`, `}`) i tak dalej. Lexer jest odpowiedzialny za identyfikację
tych tokenów i grupowanie ich w logiczne jednostki.

#### Parser

Parser to program, który bierze tokeny wygenerowane przez lexer i tworzy strukturę danych, zazwyczaj drzewo, które
reprezentuje strukturę gramatyczną tokenów. W tym drzewie, węzły reprezentują konstrukcje gramatyczne, a krawędzie
reprezentują relacje między nimi. Na przykład, w języku Java, parser może stworzyć drzewo, które reprezentuje cały
program, z węzłami reprezentującymi klasy, metody, instrukcje, wyrażenia i tak dalej. Parser jest odpowiedzialny za
sprawdzenie, czy tokeny tworzą poprawne konstrukcje gramatyczne zgodnie z regułami języka programowania.

#### Znaczenie Lexer i Parser w kontekście ANTLR

W kontekście ANTLR, zarówno lexer jak i parser są generowane automatycznie na podstawie zdefiniowanej gramatyki.
Gramatyka to zestaw reguł, które definiują, jakie sekwencje tokenów są poprawne w danym języku programowania. ANTLR
analizuje te reguły i generuje kod lexer i parser, które mogą być użyte do analizy kodu źródłowego napisanego w tym
języku.

### Krok 2: Definiowanie gramatyki w ANTLR

Definiowanie gramatyki w ANTLR odbywa się poprzez stworzenie pliku `.g4`, który zawiera zestaw reguł opisujących
strukturę języka, który chcesz analizować. Plik ten składa się z dwóch głównych sekcji: reguł lexer-a i reguł parser-a.

Reguły lexer-a definiują, jak ciąg wejściowy powinien być podzielony na tokeny. Każda reguła lexer-a składa się z nazwy
reguły i wzorca, który powinien być dopasowany. Na przykład, reguła lexer-a dla identyfikatorów w języku Java może
wyglądać tak:

```antlr
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
```

Ta reguła mówi, że identyfikator to dowolny ciąg znaków, który zaczyna się od litery lub podkreślenia, a następnie
zawiera dowolną ilość liter, cyfr lub podkreśleń.

Reguły parser-a definiują, jak tokeny powinny być grupowane w konstrukcje gramatyczne. Każda reguła parser-a składa się
z nazwy reguły i sekwencji tokenów i innych reguł, które powinny być dopasowane. Na przykład, reguła parser-a dla
instrukcji przypisania w języku Java może wyglądać tak:

```antlr
assign : ID '=' expr ';' ;
```

Ta reguła mówi, że instrukcja przypisania składa się z identyfikatora, znaku równości, wyrażenia i średnika.

### Krok 3: Testowanie gramatyki w ANTLR

Aby przetestować gramtykę wykonaj:

```bash
java -jar ./antlr-4.11.1-complete.jar -listener Calculator.g4 -o src/main/java/org/example/ -package "org.example"
javac -cp .:antlr-4.11.1-complete.jar -d build src/main/java/org/example/*.java
java -cp .:build:antlr-4.11.1-complete.jar org.antlr.v4.gui.TestRig org.example.Calculator expression -tree -ps output.ps example.txt
```
To polecenie wydrukuje drzewo parsowania w konsoli i zapisze w postaci `output.ps` w katalogu głównym projektu.
Plik `output.ps` jest w formacie PostScript. Sposób podglądu zostawia się użytkownikowi. Można użyć narzędzi takich jak
`gv`, `evince`, `okular`, `gs` lub inne.

```bash
evince output.ps
```

W pliku `example.txt` znajdują się przykładowe wyrażenia, które będą analizowane przez ANTLR. Możesz zmienić zawartość
tego pliku, aby przetestować różne przypadki.

### Krok 4: Generowanie Lexer i Parser za pomocą ANTLR

Po zdefiniowaniu gramatyki, możemy użyć ANTLR do wygenerowania lexer-a i parser-a. Poniższe polecenie wykonuje to
zadanie:

```bash
    java -jar ./antlr-4.11.1-complete.jar -listener Calculator.g4 -o src/main/java/org/example/ -package "org.example"
```

Oto co oznaczają poszczególne części tego polecenia:

- `java -jar ./antlr-4.11.1-complete.jar` - uruchamia ANTLR. Musisz mieć zainstalowaną Javę, aby to zadziałało.
- `-listener` - to flaga, która mówi ANTLR, że chcemy wygenerować kod dla "listenera", który jest rodzajem parsera,
  który "słucha" na wydarzenia generowane podczas analizy drzewa składniowego.
- `Calculator.g4` - to plik z gramatyką, który chcemy przetworzyć.
- `-o src/main/java/org/example/` - to miejsce, gdzie ANTLR powinien umieścić wygenerowane pliki.
- `-package "org.example"` - to pakiet, w którym ANTLR powinien umieścić wygenerowane klasy.

#### Listener

"Listener" w kontekście ANTLR to rodzaj parsera, który "słucha" na wydarzenia generowane podczas analizy drzewa składniowego.

Podczas analizy kodu źródłowego, parser przechodzi przez drzewo składniowe, które zostało utworzone przez lexer. Na każdym etapie tej analizy, parser może generować różne wydarzenia, takie jak "rozpoczęcie analizy konstrukcji gramatycznej" lub "zakończenie analizy konstrukcji gramatycznej".

"Listener" to klasa, która implementuje metody, które są wywoływane, gdy te wydarzenia są generowane. Każda metoda w "listenerze" odpowiada na konkretne wydarzenie generowane przez parser. Na przykład, może być metoda, która jest wywoływana, gdy parser rozpoczyna analizę instrukcji if, i inna metoda, która jest wywoływana, gdy parser kończy analizę instrukcji if.

Dzięki temu, "listener" może reagować na te wydarzenia w dowolny sposób - na przykład, może zbierać informacje o strukturze kodu źródłowego, generować kod wynikowy, wykonywać analizę statyczną kodu, i tak dalej.

W przypadku ANTLR, "listener" jest generowany automatycznie na podstawie zdefiniowanej gramatyki. Możesz jednak rozszerzyć wygenerowaną klasę "listenera" i dodać własną logikę do metod, które są wywoływane na wydarzenia generowane przez parser.

### Krok 5: Implementacja działania kalkulatora

Po wygenerowaniu lexer i parser, musisz zaimplementować działanie kalkulatora. W tym celu musisz rozszerzyć
klasę `MyCalculatorListener`, która została wygenerowana przez ANTLR. Ta klasa zawiera metody, które są wywoływane, gdy
parser napotka odpowiednie konstrukcje gramatyczne.

Wymagane funkcjonalności to:

- dodawanie,
- odejmowanie,
- mnożenie,
- dzielenie,
- potęgowanie,
- pierwiastkowanie
- logarytmowanie
- funkcje trygonometryczne

### Krok 6: Testowanie kalkulatora

Po zaimplementowaniu działania kalkulatora, powinieneś przetestować jego działanie. Do tego celu służą testy
jednostkowe, które są dostępne w projekcie. Aby uruchomić testy, użyj poniższego polecenia:

```bash
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
```

Każdy test jest warty 10 pkt.

### Dodatkowe informacje

W `build.gradle` zwarta jest zależność do ANTLR. Kod źródłowy lexera i parsera nadal należy wygenerować samodzielnie.
Zależnośc pozwoala na uruchomienie testów jednostkowych i budowanie projektu w IDE.