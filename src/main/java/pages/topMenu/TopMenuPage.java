package pages.topMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "category-3")
    private WebElement clothes;
    @FindBy(id = "category-6")
    private WebElement accesories;
    @FindBy(id = "category-9")
    private WebElement art;

    private List<WebElement> categories = List.of(clothes,accesories,art);

    public void selectRandomCategory(){
        clickRandomElement(categories);
    }
}
