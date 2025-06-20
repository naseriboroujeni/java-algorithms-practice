package com.saeed.stream;

import java.text.MessageFormat;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {
        MathOperation addition = (a, b) -> a + b;
        MathOperation substraction = (a, b) -> a - b;
        MathOperation division = (a, b) -> a / b;
        MathOperation multiplication = (a, b) -> a * b;

        int a = 10;
        int b = 5;

        System.out.println(MessageFormat.format("{0} plus {1} equals to: {2}", a, b, addition.operate(a, b)));
        System.out.println(MessageFormat.format("{0} minus {1} equals to: {2}", a, b, substraction.operate(a, b)));
        System.out.println(MessageFormat.format("{0} divided by {1} equals to: {2}", a, b, division.operate(a, b)));
        System.out.println(MessageFormat.format("{0} multiply {1} equals to: {2}", a, b, multiplication.operate(a, b)));
    }
}
