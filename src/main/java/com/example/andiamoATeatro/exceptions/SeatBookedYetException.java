package com.example.andiamoATeatro.exceptions;

public class SeatBookedYetException extends Exception {

    @Override
    public String getMessage() {
        return "this seat is booked!";
    }
}
