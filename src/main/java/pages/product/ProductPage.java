package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = ".product-message")
    private WebElement productMessege;

    @FindBy(name = "submitCustomizedData")
    private WebElement saveCustomizationButton;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;

    public void setQuantityInput(int minQauntityRange, int maxQuantityRange) {
        clearInput(quantityInput);
        setQuantity(quantityInput, minQauntityRange, maxQuantityRange);
    }

    public void customizeIfPossible(String text) {
        if (isDisplayed(By.cssSelector(".product-customization"))) {
            sendKeys(productMessege, text);
            click(saveCustomizationButton);
        }
    }

    public void addToBasket() {
        click(addToCartButton);
        new PopupOrderDetailsPage(driver).waitForAddedToBasketProductPopup();
    }
}
