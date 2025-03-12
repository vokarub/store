package ru.flowstory.store.util;

public class OrderNotCreatedException extends RuntimeException {
    public OrderNotCreatedException(String msg) {
        super(msg);
    }
}

