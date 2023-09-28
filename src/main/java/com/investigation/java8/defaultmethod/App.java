package com.investigation.java8.defaultmethod;

public class App implements AnimalA, AnimalB {
    public static void main(String[] args) {
        App app = new App();
        app.eat();
        app.walk();
    }

    @Override
    public void eat() {
        AnimalA.super.eat();
        //AnimalB.super.eat();
    }

    @Override
    public void walk() {
        System.out.println("Animal walking");
    }
}