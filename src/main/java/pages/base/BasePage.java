package pages.base;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    private static Logger logger = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    public Random random;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("webElementTimeOut"))));
        this.driver = driver;
        random = new Random();
    }

    public BasePage(WebDriver driver, WebElement element) {
        this.driver = driver;
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("webElementTimeOut"))));
    }

    public void clickRandomElement(List<WebElement> elements) {
        int randomIndex = random.nextInt(elements.size());
        elements.get(randomIndex).click();
    }

    public void setQuantity(WebElement element, int minQuantityRange, int maxQuantityRange) {
        String quantity = String.valueOf(random.nextInt(minQuantityRange, maxQuantityRange));
        logger.info("Quantity value: " + quantity);
        element.sendKeys(quantity);
    }

    public void clearInput(WebElement element) {
        element.clear();
    }

    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click(WebElement element) {
        String webElementName = element.getText();
        logger.info("Clicked element: " + element.getText());
        element.click();
    }

    public void sendKeys(@NotNull WebElement element, String text) {
        logger.info("Element name: " + element.getText() + "sendtext: " + text);
        element.sendKeys(text);
    }

    public void waitForElementBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String getTextFromElement(WebElement element) {
        logger.info(element.getText());
        return element.getText();
    }

    public double getPrice(WebElement element, char currency) {
        return Double.parseDouble(element.getText().replace(String.valueOf(currency), "").trim());
    }

    public int getQauntity(WebElement element) {
        return Integer.parseInt(element.getText());
    }

}
