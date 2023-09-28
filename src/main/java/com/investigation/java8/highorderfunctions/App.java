package com.investigation.java8.highorderfunctions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    private Function<String, String> convertUpper = text -> text.toUpperCase();
    private Function<String, String> convertLower = text -> text.toLowerCase();

    private void print(Function<String, String> function, String text) {
        System.out.println(function.apply(text));
    }

    private Function<String, String> show(String text) {
        return x -> text + " " + x;
    }

    private void filter(List<String> names, Consumer<String> consumer, String subtext) {
        names.stream().filter(containsSubtext(subtext)).forEach(consumer);
    }

    private Predicate<String> containsSubtext(String subtext) {
        return text -> text.contains(subtext);
    }

    public static void main(String[] args) {
        App app = new App();
        app.print(app.convertUpper, "hello");
        app.print(app.convertLower, "HELLO");

        String result = app.show("Hello").apply("Harry");
        System.out.println(result);

        List<String> names = Arrays.asList("Peter", "James", "Harry", "Lisa", "Robert", "Charles");
        app.filter(names, System.out::println, "e");
    }
}