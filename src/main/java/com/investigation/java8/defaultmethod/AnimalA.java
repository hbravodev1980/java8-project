package com.investigation.java8.defaultmethod;

@FunctionalInterface
public interface AnimalA {
    default public void eat() {
        System.out.println("Method default eat A");
    }

    void walk();
}