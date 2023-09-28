package com.investigation.java8.rxjava;

import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {
    private List<Integer> numbers1;
    private List<Integer> numbers2;

    public App() {
        numbers1 = new ArrayList<>();
        numbers2 = new ArrayList<>();
        fillLists();
    }

    public void fillLists() {
        for (int i = 0; i < 10; i++) {
            numbers1.add(i);
            numbers2.add(i);
        }
    }

    public void find() {
        Observable<Integer> observable1 = Observable.from(numbers1);
        Observable<Integer> observable2 = Observable.from(numbers2);

        Observable.merge(observable1, observable2)
                .filter(number -> number == 1)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter", "Robert", "Harry", "Louise", "Sandy", "Charles");

        Observable<String> observable = Observable.from(names);
        observable.subscribe(System.out::println);

        App app = new App();
        app.find();
    }
}