package ru.flowstory.store.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Primary key of the {@link CartItem}.
 */
@Embeddable
public class CartItemId implements Serializable {

	private int orderId;
	private int productId;

	public CartItemId() {
	}

	public CartItemId(int orderId, int productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getOrderId() {		return orderId;	}

	public void setOrderId(int orderId) {		this.orderId = orderId;	}

	public int getProductId() {		return productId;	}

	public void setProductId(int productId) {		this.productId = productId;	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CartItemId that = (CartItemId) o;
		return orderId == that.orderId &&
			productId == that.productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}
}
