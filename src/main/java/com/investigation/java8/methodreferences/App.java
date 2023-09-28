package com.investigation.java8.methodreferences;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    private static void staticMethod() {
        System.out.println("Static method");
    }

    private static void instanceMethodToArbitraryObject() {
        List<Integer> numbers = Arrays.asList(30, 50, 20, 10, 4, 34, 2, 0, 54);
        Collections.sort(numbers, (number1, number2) -> number1.compareTo(number2));
        System.out.println(numbers);

        List<Integer> numbers2 = Arrays.asList(30, 50, 20, 10, 4, 34, 2, 0, 54);
        Collections.sort(numbers2, Integer::compareTo);
        System.out.println(numbers2);
    }

    private void instanceMethodToParticularObject() {
        System.out.println("Instance method to particular object");
    }

    public static void main(String[] args) {
        // Referenciar metodo estatico
        Reference reference1 = () -> App.staticMethod();
        reference1.print();

        Reference reference2 = App::staticMethod;
        reference2.print();

        // Referenciar metodo de instancia de objeto arbitrario
        instanceMethodToArbitraryObject();

        // Referenciar metodo de instancia de objeto particular
        App app = new App();
        Reference reference3 = () -> app.instanceMethodToParticularObject();
        reference3.print();

        Reference reference4 = app::instanceMethodToParticularObject;
        reference4.print();

        // Referenciar a constructor
        IPerson iPerson1 = (id, name) -> new Person(id, name);
        Person person1 = iPerson1.create(1, "Harry");
        System.out.println(person1);

        IPerson iPerson2 = Person::new;
        Person person2 = iPerson1.create(1, "Harry");
        System.out.println(person2);
    }
}