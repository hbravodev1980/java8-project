package com.investigation.java8.parallelstream;

import java.util.ArrayList;
import java.util.List;

public class App {
    List<Integer> numbers;

    public App() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
    }

    private void testStream() {
        numbers.stream().forEach(System.out::println);
    }

    private void testParallelStream() {
        numbers.parallelStream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        App app = new App();
        //app.testStream();
        app.testParallelStream();
    }
}
