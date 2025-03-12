package ru.flowstory.store.util;

/**
 * Заказ не может быть оформлен: корзина пуста.
 */
public class EmptyCartException extends CustomNotValidException {

	public EmptyCartException() {
		super("NotEmpty", "cart", "items");
	}
}
