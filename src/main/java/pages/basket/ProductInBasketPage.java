package pages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductInBasketPage extends BasePage {


    public ProductInBasketPage(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    @FindBy(css = ".product-line-info a")
    private WebElement name;

    @FindBy(css = ".current-price span")
    private WebElement price;

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement quantity;

    @FindBy(css = ".product-price strong")
    private WebElement totalPrice;

    public String getName() {
        return name.getText();
    }

    public double getPrice() {
        return getPrice(price, '$');
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }

    public double getTotalPrice() {
        return getPrice(totalPrice, '$');
    }
}
