package ru.flowstory.store.util;

/**
 * Пользователь с указанным адресом уже существует.
 */
public class EmailExistsException extends CustomNotValidException {

	public EmailExistsException(Class<?> clazz) {
		super("Exists", clazz.getSimpleName(), "email");
	}
}
