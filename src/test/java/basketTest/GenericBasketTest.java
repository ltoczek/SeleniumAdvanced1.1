package basketTest;


import base.Pages;
import models.OrderList;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GenericBasketTest extends Pages {

    OrderList expectedOrderList = new OrderList();

    @RepeatedTest(10)
    @Test
    public void mainTest() {

        for (int i = 0; i < quantityProducts(); i++) {
            topMenuPage.selectRandomCategory();
            productGridPage.selectRandomProduct();
            productPage.setQuantityInput(0, 5);
            productPage.customizeIfPossible(System.getProperty("customizableMugText"));
            productPage.addToBasket();
            expectedOrderList.addProduct(popupOrderDetailsPage.toProduct());
            popupOrderDetailsPage.clickContinueShoppingButton();
        }

        driver.get(System.getProperty("basketUrl"));

        OrderList actualOrderList = new OrderList(basketPage);

        assertThat(actualOrderList).usingRecursiveComparison().isEqualTo(expectedOrderList);
        assertThat(actualOrderList.getTotalPrice()).isEqualTo(basketPage.getTotalPrice());

        int size = basketPage.getProductsFromBasket().size();

        for (int i = 0; i < size; i++) {
            basketPage.removeProduct();
            expectedOrderList.getOrderedProducts().remove(0);

            actualOrderList = new OrderList(basketPage);

            assertThat(actualOrderList).usingRecursiveComparison().isEqualTo(expectedOrderList);
            assertThat(actualOrderList.getTotalPrice()).isEqualTo(basketPage.getTotalPrice());
        }
    }

    public static int quantityProducts() {
        try {
            return Integer.parseInt(System.getProperty("howManyProductsAddToBasket"));
        } catch (NumberFormatException e) {
            return 1;
        }
    }
}
