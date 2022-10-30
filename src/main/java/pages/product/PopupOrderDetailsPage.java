package pages.product;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class PopupOrderDetailsPage extends BasePage {
    public PopupOrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "myModalLabel")
    private WebElement popupHeaderLabel;
    @FindBy(css = ".btn-secondary")
    private WebElement continueShoppingButton;
    @FindBy(css = ".product-name")
    private WebElement productName;
    @FindBy(xpath = "//div[@class='col-md-6']/p")
    private WebElement productPrice;
    @FindBy(css = ".product-quantity strong")
    private WebElement productQuantity;

    public void waitForAddedToBasketProductPopup() {
        waitForElementBeVisible(popupHeaderLabel);
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
    }

    public String getProductName() {
        return getTextFromElement(productName);
    }

    public Product toProduct() {
        return new Product(getProductName(), getPrice(productPrice, '$'), getQauntity(productQuantity));
    }
}
