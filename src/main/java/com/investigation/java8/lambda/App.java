package com.investigation.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        averageWithAnonymousClass();
        averageWithLambda();
        sortListWithLambda();
    }

    public static void averageWithAnonymousClass() {
        Operation operation = new Operation() {
            @Override
            public double average(double number1, double number2) {
                return (number1 + number2) / 2;
            }
        };
        System.out.println("Average with anonymous class: " + operation.average(5, 3));
    }

    public static void averageWithLambda() {
        Operation operation = (number1, number2) -> (number1 + number2) / 2;
        System.out.println("Average with lambda: " + operation.average(5, 3));
    }

    public static void sortListWithLambda() {
        List<Integer> numbers = Arrays.asList(13, 29, 15, 93, 5, 2, 0, 20);
        Collections.sort(numbers, (o1, o2) -> o1.compareTo(o2));
        System.out.println("numbers sort with lambda: " + numbers);
    }
}