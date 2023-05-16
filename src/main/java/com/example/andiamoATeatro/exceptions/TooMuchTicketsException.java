package com.example.andiamoATeatro.exceptions;

public class TooMuchTicketsException extends Exception {

    @Override
    public String getMessage() {
        return "You have bought too much tickets for this show yet";
    }
}
