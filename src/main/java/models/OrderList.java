package models;

import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.basket.BasketPage;
import pages.basket.ProductInBasketPage;

import java.util.ArrayList;
import java.util.List;

public class OrderList {

    private static Logger logger = LoggerFactory.getLogger(OrderList.class);
    private List<Product> orderedProducts = new ArrayList<>();

    public OrderList() {
    }

    public OrderList(BasketPage basketPage) {
        for (ProductInBasketPage productInBasketPage : basketPage.getProductsFromBasket()) {
            orderedProducts.add(new Product(productInBasketPage));
        }
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void addProduct(Product product) {
        if (isProductInList(product.getName())) {
            setNewQuantity(product);
        } else {
            orderedProducts.add(product);
        }
    }

    private boolean isProductInList(String name) {
        return orderedProducts.stream().anyMatch(product -> product.getName().equals(name));
    }

    private void setNewQuantity(Product product) {
        for (Product productInList : orderedProducts) {
            if (productInList.getName().equals(product.getName())) {
                productInList.addQuantity(product.getQuantity());
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : getOrderedProducts()) {
            totalPrice += product.getTotalPrice();
        }
        return Precision.round(totalPrice, 2);
    }

    public boolean isOrderedProductsListEmpty() {
        return orderedProducts.isEmpty();
    }


}
