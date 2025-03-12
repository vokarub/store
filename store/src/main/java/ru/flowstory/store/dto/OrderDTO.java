package ru.flowstory.store.dto;

import ru.flowstory.store.dto.CartItemDTO;

import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class OrderDTO {

    @NotEmpty
    private String customerName;

    @NotEmpty
    private String customerMobile;

    private String receiverName;
    private String receiverMobile;

    private String postcardText;
    private String commentsToOrder;

    private String deliveryAddress;
    private String deliveryDate;
    private String deliveryTime;

    private int totalPrice;

    private boolean deliveryIncluded;

    private List<CartItemDTO> cartItems;

    public boolean containsProductId(long targetProductId) {
        return cartItems.stream()
                .map(CartItemDTO::getProductId)
                .anyMatch(id -> id == targetProductId);
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

    public String getDeliveryDate() {        return deliveryDate;    }

    public void setDeliveryDate(String deliveryDate) {        this.deliveryDate = deliveryDate;    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getTotalPrice() {        return totalPrice;    }

    public void setTotalPrice(int totalPrice) {        this.totalPrice = totalPrice;    }

    public List<CartItemDTO> getCartItems() {        return cartItems;    }

    public void setCartItems(List<CartItemDTO> cartItems) {        this.cartItems = cartItems;    }

    public boolean isDeliveryIncluded() {        return deliveryIncluded;    }

    public void setDeliveryIncluded(boolean deliveryIncluded) {        this.deliveryIncluded = deliveryIncluded;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return totalPrice == orderDTO.totalPrice && deliveryIncluded == orderDTO.deliveryIncluded &&
                Objects.equals(customerName, orderDTO.customerName) &&
                Objects.equals(customerMobile, orderDTO.customerMobile) &&
                Objects.equals(receiverName, orderDTO.receiverName) &&
                Objects.equals(receiverMobile, orderDTO.receiverMobile) &&
                Objects.equals(postcardText, orderDTO.postcardText) &&
                Objects.equals(commentsToOrder, orderDTO.commentsToOrder) &&
                Objects.equals(deliveryAddress, orderDTO.deliveryAddress) &&
                Objects.equals(deliveryDate, orderDTO.deliveryDate) &&
                Objects.equals(deliveryTime, orderDTO.deliveryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, customerMobile, receiverName, receiverMobile, postcardText, commentsToOrder, deliveryAddress, deliveryDate, deliveryTime, totalPrice, deliveryIncluded);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                ", customerName='" + customerName + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                '}';
    }
}
