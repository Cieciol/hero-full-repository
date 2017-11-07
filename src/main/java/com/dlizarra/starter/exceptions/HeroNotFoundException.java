package com.dlizarra.starter.exceptions;

public class HeroNotFoundException extends Exception {
    public HeroNotFoundException(String message) {
        super(message);
    }

    public HeroNotFoundException() {
        super("Hero not found in the database");
    }
}
