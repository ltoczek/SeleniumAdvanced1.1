package models;

import org.apache.commons.math3.util.Precision;
import pages.basket.ProductInBasketPage;

public class Product {

    private String name;
    private double price;
    private int quantity;
    private double totalPrice;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = this.quantity * this.price;
    }

    public Product(ProductInBasketPage productInBasketPage) {
        this.name = productInBasketPage.getName();
        this.price = productInBasketPage.getPrice();
        this.quantity = productInBasketPage.getQuantity();
        this.totalPrice = productInBasketPage.getTotalPrice();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = Precision.round(this.price * this.quantity, 2);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = Precision.round(this.price * this.quantity, 2);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
