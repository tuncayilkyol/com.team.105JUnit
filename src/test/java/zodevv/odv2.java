package zodevv;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class odv2 {
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
        // 1- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        // 2- cookies uyarisini kabul ederek kapatin
        // 3- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertTrue("Google ifadesini iceriyor", actualTitle.contains(expectedTitle));
        // 4- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);
        // 5- Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.id("result-stats"));
        System.out.println("Sonuc sayisi : " + sonuc.getText());
        // 6- Sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucYazisiStr = sonuc.getText();

        String[] sonucSayisiArr = sonucYazisiStr.split(" ");
        System.out.println(Arrays.toString(sonucSayisiArr));
        String ilkin = sonucSayisiArr[1];
        System.out.println(ilkin);
        String index1Noktasiz=ilkin.replace(".","");//veya replaceALL(\\D,"")
       int actualSonucInt=Integer.parseInt(index1Noktasiz);
        System.out.println(actualSonucInt);
        /* ***************************uzun yol*********************
        /*
        String sonstr = "";

        for (int i = 0; i < ilkin.length(); i++) {

            if (Character.isDigit(ilkin.charAt(i))) {
                sonstr += (ilkin.charAt(i) + "");
            }
        }
        System.out.println("Rakam : " + sonstr);

        int actualSonucInt = Integer.parseInt(sonstr);
        */
        int karsilastirmaSayisi = 10000000;
        Assert.assertTrue(actualSonucInt > karsilastirmaSayisi);

    }
}
