package com.investigation.java8.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry;

public class App {
    private Map<Integer, String> map;

    public App() {
        map = new HashMap<>();
        map.put(1, "Peter");
        map.put(2, "Mary");
        map.put(3, "Lisa");
        map.put(4, "Robert");
        map.put(5, "Charles");
    }

    private void printMapV7() {
        for (Entry<Integer, String> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " - value: " + entry.getValue());
        }
    }

    private void printMapV8() {
        //map.forEach((key, value) -> System.out.println("Key: " + key + " - value: " + value));
        map.entrySet().forEach(System.out::println);
    }

    private void insertIfAbsent() {
        map.putIfAbsent(2, "John");
    }

    private void operateIfPresent() {
        map.computeIfPresent(3, (key, value) -> key + value);
    }

    private void getOrDefault() {
        String value = map.getOrDefault(6, "Value for default");
        System.out.println(value);
    }

    private void recollect() {
        Map<Integer, String> recollectMap = map.entrySet().stream()
                .filter(entry -> entry.getValue().contains("ar"))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

        recollectMap.entrySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        App app = new App();
        //app.printMapV7();
        //app.insertIfAbsent();
        //app.operateIfPresent();
        //app.getOrDefault();
        app.recollect();
        //app.printMapV8();
    }
}