package com.investigation.java8.repeatannotation;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //Language[] languages = ProgrammingLanguage.class.getAnnotationsByType(Language.class);
        //Arrays.stream(languages).forEach(System.out::println);

        Languages languages1 = ProgrammingLanguage.class.getAnnotation(Languages.class);
        for (Language language: languages1.value()) {
            System.out.println(language.value());
        }
    }
}
