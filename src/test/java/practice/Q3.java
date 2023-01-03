package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Q3 {
    /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Europa
    choose your command  -> Browser Commands
    click submit button
 */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().deleteAllCookies();
        driver.findElement(By.id("ez-accept-all")).click();
        driver.findElement(By.id("cookieChoiceDismiss")).click();
        driver.findElement(By.name("firstname")).sendKeys("Hikmet"+ Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Akyol" + Keys.ENTER);
        WebElement genderRadioButton = driver.findElement(By.id("sex-0"));
        genderRadioButton.click();
        genderRadioButton.sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.xpath("//input[@id='exp-0']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("24.12.2022"+Keys.ENTER);
        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-2")).click();
        driver.findElement(By.id("continents")).sendKeys("Europa" + Keys.ENTER);
        driver.findElement(By.xpath("//option[text()='Browser Commands']")).click();
        driver.findElement(By.id("submit")).click();
    }
}
