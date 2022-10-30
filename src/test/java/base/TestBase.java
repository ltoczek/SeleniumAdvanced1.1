package base;

import configuration.AppProperties;
import configuration.DriverHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    protected static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    public WebDriver driver;
    protected static AppProperties appProperties;
    public static DriverHandle driverHandle;

    @BeforeAll
    static void beforeAll() {
        appProperties = AppProperties.getInstance();
    }

    @BeforeEach
    void setUp(){
        driverHandle = new DriverHandle();
        driver = driverHandle.getDriver();
        driver.get(System.getProperty("appURL"));
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
