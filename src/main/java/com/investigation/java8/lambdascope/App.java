package com.investigation.java8.lambdascope;

import com.investigation.java8.lambda.Operation;

public class App {
    private static double number4 = 8;
    private double number5 = 8;

    public static void main(String[] args) {
        scopeLocalVariable();
        scopeInstanceVariable();
        scopeStaticVariable();
    }

    public static void scopeLocalVariable() {
        final double number3 = 8;
        Operation operation = ((number1, number2) -> number1 + number2 + number3);
        System.out.println("Scope local variable: " + operation.average(5, 3));
    }

    public static void scopeStaticVariable() {
        Operation operation = ((number1, number2) -> number1 + number2 + number4);
        System.out.println("Scope static variable: " + operation.average(5, 3));
    }

    public static void scopeInstanceVariable() {
        Operation operation = ((number1, number2) -> number1 + number2 + new App().number5);
        System.out.println("Scope instance variable: " + operation.average(5, 3));
    }
}