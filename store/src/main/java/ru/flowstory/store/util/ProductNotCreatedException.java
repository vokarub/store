package ru.flowstory.store.util;

public class ProductNotCreatedException extends RuntimeException {
    public ProductNotCreatedException(String msg) {
        super(msg);
    }
}