package com.example.andiamoATeatro.exceptions;

public class ShowInThePastException extends Exception {

    @Override
    public String getMessage() {
        return "the show is in the past!";
    }
}
