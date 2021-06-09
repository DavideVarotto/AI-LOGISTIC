//Problem fact

package com.example.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private int idProduct; // Id del prodotto
    private int overlap; // Indice di sovrapponibilità
    private int quantity; // Quantità prodotto
    private int category; // Categoria di appartenenza in base alla frequenza

    private Product() {
    }

    public Product(int _idProduct, int _overlap, int _quantity, int _category) {
        this.idProduct = _idProduct;
        this.overlap = _overlap;
        this.quantity = _quantity;
        this.category = _category;
    }

    @Override
    public String toString() {
        return "Product: " + idProduct;
    }

    // ********************************
    // Getters and setters
    // ********************************
    public void setId(int _idProduct) {
        this.idProduct = _idProduct;
    }

    public void setOverlap(int _overlap) {
        this.overlap = _overlap;
    }

    public void setQuantity(int _quantity) {
        this.quantity = _quantity;
    }

    public void setCategory(int _category) {
        this.category = _category;
    }

    public int getId() {
        return this.idProduct;
    }

    public int getOverlap() {
        return this.overlap;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getCategory() {
        return this.category;
    }

}
