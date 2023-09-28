package com.investigation.java8.foreach;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<String> names;

    private void addElement() {
        names = new ArrayList<>();
        names.add("Peter");
        names.add("Mery");
        names.add("Louise");
        names.add("Sandy");
    }

    private void useForeach() {
        names.forEach(System.out::println);
    }

    private void useRemoveIf() {
        names.removeIf(name -> name.equals("Mery"));
    }

    private void useSort() {
        //names.sort((x, y) -> x.compareTo(y));
        names.sort(String::compareTo);
    }

    public static void main(String[] args) {
        App app = new App();
        app.addElement();
        //app.useSort();
        app.useRemoveIf();
        app.useForeach();
    }
}