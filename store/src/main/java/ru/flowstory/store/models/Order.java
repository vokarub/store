package ru.flowstory.store.models;


import ru.flowstory.store.models.CartItem;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "customer_name")
    private String customerName;

    @NotEmpty
    @Column(name = "customer_mobile")
    private String customerMobile;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_mobile")
    private String receiverMobile;

    @Column(name = "postcard_text")
    private String postcardText;

    @Column(name = "comments")
    private String commentsToOrder;

    @Column(name = "address")
    private String deliveryAddress;

    @Column(name = "delivery_date")
    private String deliveryDate;

    @Column(name = "delivery_time")
    private String deliveryTime;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "delivery_included", nullable = false)
    private boolean deliveryIncluded;

    @Column(name = "total_price")
    private int totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getPostcardText() {
        return postcardText;
    }

    public void setPostcardText(String postcardText) {
        this.postcardText = postcardText;
    }

    public String getCommentsToOrder() {
        return commentsToOrder;
    }

    public void setCommentsToOrder(String commentsToOrder) {
        this.commentsToOrder = commentsToOrder;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalPrice() {        return totalPrice;    }

    public void setTotalPrice(int totalPrice) {        this.totalPrice = totalPrice;    }

    public boolean isDeliveryIncluded() {
        return deliveryIncluded;
    }

    public void setDeliveryIncluded(boolean deliveryIncluded) {
        this.deliveryIncluded = deliveryIncluded;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                deliveryIncluded == order.deliveryIncluded && totalPrice == order.totalPrice &&
                Objects.equals(customerName, order.customerName) &&
                Objects.equals(customerMobile, order.customerMobile) &&
                Objects.equals(receiverName, order.receiverName) &&
                Objects.equals(receiverMobile, order.receiverMobile) &&
                Objects.equals(postcardText, order.postcardText) &&
                Objects.equals(commentsToOrder, order.commentsToOrder) &&
                Objects.equals(deliveryAddress, order.deliveryAddress) &&
                Objects.equals(deliveryDate, order.deliveryDate) &&
                Objects.equals(deliveryTime, order.deliveryTime) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(cartItems, order.cartItems);}

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, customerMobile, receiverName, receiverMobile, postcardText,
                commentsToOrder, deliveryAddress, deliveryDate, deliveryTime, orderDate, deliveryIncluded, totalPrice, cartItems);
    }
}
