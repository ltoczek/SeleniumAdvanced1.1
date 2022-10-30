package base;

import org.junit.jupiter.api.BeforeEach;
import pages.basket.BasketPage;
import pages.product.PopupOrderDetailsPage;
import pages.product.ProductGridPage;
import pages.product.ProductPage;
import pages.topMenu.TopMenuPage;

public class Pages extends TestBase {
    public TopMenuPage topMenuPage;

    public ProductGridPage productGridPage;
    public ProductPage productPage;

    public PopupOrderDetailsPage popupOrderDetailsPage;

    public BasketPage basketPage;

    @BeforeEach
    public void pagesSetUp() {
        topMenuPage = new TopMenuPage(driver);
        productGridPage = new ProductGridPage(driver);
        productPage = new ProductPage(driver);
        popupOrderDetailsPage = new PopupOrderDetailsPage(driver);
        basketPage = new BasketPage(driver);
    }


}
