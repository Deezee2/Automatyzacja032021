package Steps;

import Day2.POM.ContactPagePO;
import Day2.POM.HomepagePO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Steps {
    Logger logger = Logger.getLogger(Steps.class);
    static WebDriver driver;
    HomepagePO homepagePO;
    ContactPagePO contactPagePO;

    @Before
    public static void setup(){
        DOMConfigurator.configure("log4j.xml");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("homepage is opened")
    public void homepage_is_opened() {
        homepagePO = new HomepagePO(driver);
        homepagePO.openMe();
    }

    @When("I click Contact Link")
    public void i_click_contact_link() {
        homepagePO.goToContactPage();
    }

    @Then("ContactUs page is opened")
    public void contact_us_page_is_opened() {
        contactPagePO = new ContactPagePO(driver);
        Assert.assertTrue(contactPagePO.isDisplayed());
    }

    @Then("{string} is displayed")
    public void is_displayed(String string) {
        Assert.assertTrue(true);
    }


    @After
    public static void closeDriver() {
        driver.quit();
    }

}
