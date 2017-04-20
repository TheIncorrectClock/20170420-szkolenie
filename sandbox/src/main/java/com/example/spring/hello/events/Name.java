package com.example.spring.hello.events;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Name {

    @NotEmpty
    @Size(min = 3)
    public final String word;

    public Name(String word) {
        this.word = word;
    }
}
