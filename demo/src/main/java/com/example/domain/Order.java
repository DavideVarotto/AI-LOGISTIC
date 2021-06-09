package com.example.domain;

import java.io.Serializable;

public class Order implements Serializable {
    private int idOrder;
    private Product[] products;

    private Order() {
    }

    public Order(int _idOrder, int length) {
        this.idOrder = _idOrder;
        this.products = new Product[length];
    }

    @Override
    public String toString() {
        String s = null;
        for (int i = 0; i < products.length; i++) {
            s = this.products[i].toString();
        }
        return "Order: " + idOrder + s;
    }

    // Setter method
    public void setId(int _idOrder) {
        this.idOrder = _idOrder;
    }

    // Getter method
    public int getId() {
        return this.idOrder;
    }
}
