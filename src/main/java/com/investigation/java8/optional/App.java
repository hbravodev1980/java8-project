package com.investigation.java8.optional;

import java.util.Optional;

public class App {
    private void testOptional(String value) {
        Optional<String> optional = Optional.of(value);
        String x = optional.get();
        System.out.println(x);
    }

    private void orElse(String value) {
        Optional<String> optional = Optional.ofNullable(value);
        String x = optional.orElse("Default");
        System.out.println(x);
    }

    private void orElseThrow(String value) {
        Optional<String> optional = Optional.ofNullable(value);
        String x = optional.orElseThrow(NumberFormatException::new);
        System.out.println(x);
    }

    private void isPresent(String value) {
        Optional<String> optional = Optional.ofNullable(value);
        System.out.println(optional.isPresent());
    }

    public static void main(String[] args) {
        App app = new App();
        //app.testOptional(null);
        //app.orElse(null);
        //app.orElseThrow("hello");
        app.isPresent("hello");
    }
}