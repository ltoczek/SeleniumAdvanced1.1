package pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-item")
    private List<WebElement> products;
    @FindBy(css = "#cart-subtotal-products .value")
    WebElement totalPrice;
    @FindBy(css = ".remove-from-cart")
    private List<WebElement> removeButtons;

    public List<ProductInBasketPage> getProductsFromBasket() {
        return products.stream().map(product -> new ProductInBasketPage(driver, product)).toList();
    }

    public double getTotalPrice() {
        return getPrice(totalPrice, '$');
    }

    public void removeProduct() {
        click(removeButtons.get(0));
        waitForElementBeInvisible(removeButtons.get(0));
    }
}
