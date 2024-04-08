package org.example;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {

    @Test
    void test1() {
        //given
        String expression = "2 + 2 * 2";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == 6;
    }
    @Test
    void test2() {
        //given
        String expression = "2 + -2 * 2";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == -2;
    }
    @Test
    void test3() {
        //given
        String expression = "2.05 + 2 * -2";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result + 1.95 < 0.0000001;
    }

    @Test
    void test4() {
        //given
        String expression = "-2 - 3.5 * 2 + -1 - 3.43434 * -2";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert  result + 3.131319 < 0.0001;
    }

    @Test
    void test5() {
        //given
        String expression = "-2 + -2 - 0 / 2 + -1 - 3 * -2";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == 1;
    }

    @Test
    void test6() {
        //given
        String expression = "-40 * 1 / 2 * 1 / 5";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == -4;
    }

    @Test
    void test7() {
        //given
        String expression = "4 ^ 3 ^ 2 + 1";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == 262145;
    }

    @Test
    void test8() {
        //given
        String expression = "-2 - ln(1) * sin(0.75) + 2";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result + 0.8660 < 0.0001;
    }

    @Test
    void test9() {
        //given
        String expression = "-2 * (-2 + -5)";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == 14;
    }
    @Test
    void test10() {
        //given
        String expression = "-2 + (-40 * 1 / 2 * 1 / 5) + 6";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == 0;
    }

    @Test
    void test11() {
        //given
        String expression = "2 ^ 3 - 2 * 2";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == 4;
    }

    @Test
    void test12() {
        //given
        String expression = "sqrt(4) + 2 * 2";
        //then
        Double result = MyCalculator.calc(expression);
        //expect
        assert result == 6;
    }
}