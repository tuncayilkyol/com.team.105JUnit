package zodevv;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odv3 {

    //1. Launch browser
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }
        @Test
        public void test() {
            //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");
            //3. Scroll to bottom of page

            //4. Verify 'RECOMMENDED ITEMS' are visible
            WebElement recomendeditems = driver.findElement(By.id("recommended-item-carousel"));
            recomendeditems.isDisplayed();
            //5. Click on 'Add To Cart' on Recommended product

            //6. Click on 'View Cart' button
            driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")).click();
            //7. Verify that product is displayed in cart page
            WebElement urunDisplay = driver.findElement(By.id("cart_info_table"));
            urunDisplay.isDisplayed();
        }

}


