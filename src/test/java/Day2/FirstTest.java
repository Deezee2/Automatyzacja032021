package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.nio.channels.SelectableChannel;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");  // headless, to robi bez GUI w pamięci (pomocne przy serwerach, gdzie jest tylko konsola)
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void testBrowserIsStarter(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");  // headless, to robi bez GUI w pamięci (pomocne przy serwerach, gdzie jest tylko konsola)
//        WebDriver driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com/");
        System.out.println("Załadowało się");

//        List<WebElement> listaElementow = driver
//                .findElements(By.cssSelector("takiego nie ma"));
//        WebElement element = driver
//                .findElement(By.cssSelector("takiego nie ma"));

        driver.findElement(By.id("contact-link")).click();
//        driver.findElements(By.id("contact-link"));
        WebElement element = driver
                .findElement(By.id("contact-link"));
        System.out.println(element.isDisplayed());
        element.click();

        Assert.assertTrue(driver
//                .findElement(By.cssSelector("form.contact-form-box"))
                .findElement(By.cssSelector("#submitMessage"))
                .isDisplayed());
        Select select = new Select(driver.findElement(By.id("id_contact")));
        select.selectByValue("2");
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("id_order")).sendKeys("None");
        driver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\a790930\\OneDrive - Atos\\Desktop\\Selenium Advanced\\Automatyzacja032021\\src\\test\\java\\Day2\\test.txt");
        driver.findElement(By.id("message")).sendKeys("Test Message");
        driver.findElement(By.id("submitMessage")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).isDisplayed());

//        driver.close();
//        System.out.println("Close");
//        driver.quit();
//        System.out.println("Quit");
    }

    @Test
    public void testWaiting(){
        //wejść na https://swiatroweru.com.pl/warsztat/seminariumStronka/
        //kliknąć na guzik sekcji 4 (tu będzie problem, bo guzik sekcji 4 nie jest od razu aktywny)
        //asercja na wyświetlenie zdjęcia

        //wait max time na findElement
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // ile czasu dajemy selenium na odnalezienie elementu
        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");

        WebElement guzik = driver.findElement(By.cssSelector("[data-section]+section button")); // czeka na konkretny stan elementu
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(guzik));
//        guzik.click();
        waitAndClick(guzik);


//        Assert.assertTrue(driver.findElement(By.tagName("img")).isDisplayed());
        WebElement obrazek = driver.findElement(By.tagName("img"));
        wait.until(ExpectedConditions.visibilityOf(obrazek));
        Assert.assertTrue(obrazek.isDisplayed());


//        Assert.assertTrue(driver.findElement(By.xpath("//img//ancestor::section//button")).isDisplayed());
//        driver.findElement(By.xpath("//img//ancestor::section//button")).click();
        driver.close();
    }

    public void waitAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
//        wait.until(ExpectedConditions.stalenessOf()) //Czekanie na zniknięcie elementu
    }

    @Test
    public void testAlerts(){
        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");
        WebElement guzikS3 = driver.findElement(By.cssSelector("[data-section] button")); // czeka na konkretny stan elementu
        waitAndClick(guzikS3);
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // accept to OK, dissmiss to Cancel lub ESC
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement tekst = driver.findElement(By.className("row"));
//        wait.until(ExpectedConditions.visibilityOf(tekst));
//        Assert.assertTrue(tekst.isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("row")).isDisplayed());
        //sprawdzenie, czy dziwny wiersz się pojawił
    }

    @Test
    public void testAlertsMany(){
        //given
        int licznik = 10;
        //when
        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");
        WebElement guzikS3 = driver.findElement(By.cssSelector("[data-section] button")); // czeka na konkretny stan elementu
        for (int i = 0; i < licznik; i++) {
            waitAndClick(guzikS3);
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
            //then
            List<WebElement> rowy = driver.findElements(By.cssSelector(".row"));
            Assert.assertEquals(rowy.size(),licznik);
    }

    @Test
    public void testDragAndDrop() {
        //given
        Actions actions = new Actions(driver);
        //when
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
//        actions.keyDown(Keys.LEFT_CONTROL).click().click().click()
//                .keyUp(Keys.LEFT_CONTROL)
//                .build().perform();
        WebElement coPrzeciagamy = driver.findElement(By.cssSelector("#todrag span"));
        WebElement dokad = driver.findElement(By.cssSelector("#mydropzone"));

        WebElement From=driver.findElement(By.xpath("//*[@id='todrag']/span"));
        WebElement To=driver.findElement(By.xpath("//*[@id='mydropzone']/li"));

//        actions.dragAndDrop(coPrzeciagamy,dokad).build().perform();
        actions.clickAndHold(coPrzeciagamy).moveToElement(dokad).release().build().perform();

        //then
        Assert.assertTrue(driver.findElement(By.cssSelector("#droppedlist span")).isDisplayed());
    }

    @Test
    public void testDragAndDrop2() {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));
        Actions act = new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
//        Assert.assertTrue(driver.findElement(By.cssSelector("#droppedlist span")).isDisplayed());
    }
}
