package com.investigation.java8.repeatannotation;

import java.lang.annotation.Repeatable;

@Repeatable(value = Languages.class)
public @interface Language {
    String value();
}