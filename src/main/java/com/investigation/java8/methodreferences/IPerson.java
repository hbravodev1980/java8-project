package com.investigation.java8.methodreferences;

@FunctionalInterface
public interface IPerson {
    Person create(Integer id, String name);
}