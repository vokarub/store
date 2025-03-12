package ru.flowstory.store.dto;

public class ProductDTO {

    private String productName;

    private int productPrice;

    public String getProductName() {        return productName;    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

}
