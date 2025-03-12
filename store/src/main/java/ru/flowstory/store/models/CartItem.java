package ru.flowstory.store.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cart_item")
public class CartItem implements Serializable {

    @EmbeddedId
    private CartItemId pk = new CartItemId();

    @MapsId("orderId")
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne
    private Order order;

    @MapsId("productId")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public CartItem() {
    }

    public CartItem(Order order, Product product, int quantity) {
        this.pk = new CartItemId(order.getId(), product.getId());
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public int calculateCost() {
        return quantity * product.getPrice();
    }

    public CartItemId getPk() {        return pk;    }

    public void setPk(CartItemId pk) {        this.pk = pk;    }

    public Order getOrder() {        return order;    }

    public void setOrder(Order order) {        this.order = order;    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        pk.setProductId(product.getId());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartItem that = (CartItem) o;
        return Objects.equals(pk, that.pk);
    }

    @Override
    public int hashCode() {
        return (pk != null ? pk.hashCode() : 0);
    }
}
