package com.investigation.java8.defaultmethod;

@FunctionalInterface
public interface AnimalB {
    default public void eat() {
        System.out.println("Method default eat B");
    }

    void walk();
}
