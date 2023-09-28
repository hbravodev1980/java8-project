package com.investigation.java8.repeatannotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Languages {
    Language[] value() default {};
}