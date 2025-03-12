package ru.flowstory.store.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    @NotNull
    private int price;

//    @Column(name = "description")
//    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "in_stock")
    private boolean inStock = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int productPrice) {
        this.price = productPrice;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && price == product.price && inStock == product.inStock
                && Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, inStock);
    }
}
