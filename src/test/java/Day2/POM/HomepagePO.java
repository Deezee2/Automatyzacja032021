package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomepagePO extends BasePO {
    Logger logger = Logger.getLogger(HomepagePO.class);

    @FindBy(css = ".logo")
    private WebElement logo;

    @FindBy(css = "a[title*=\"Women\"]")
    private WebElement womenTopMenu;

    @FindBy(xpath = "//a[@title='Dresses'][1]")
    private WebElement menuWomanDisplayed;

    @FindBy(css = "#homefeatured .product-container")
    private List<WebElement> allFeaturedProducts;

    @FindBy(css = "#contact-link a[title=\"Contact Us\"]")
    private WebElement contactLink;

    private List<ProductMiniaturePO> getProductMiniatures(){
        List<ProductMiniaturePO> list = new ArrayList<>();
        for (WebElement e:allFeaturedProducts) {
            list.add(new ProductMiniaturePO(e,driver));
        }
        return list;
    }

    public double getNthPrice(int n){
        ProductMiniaturePO pm = getProductMiniatures().get(n-1);
        logger.info("Product "+pm.getProductName()+" costs &"+pm.getPrice());
        return getProductMiniatures().get(n-1).getPrice();
    }

    private String myURL = "http://automationpractice.com/";

    public HomepagePO openMe() {
        logger.debug("Trying to open URL: " + myURL);
        driver.get(myURL);
        logger.info("Opened URL: " + myURL);
        return this;
    }

    public boolean isDisplayed() {
        logger.debug("check if logo is displayed");
        return logo.isDisplayed();
    }

    public HomepagePO openWomenTopMenu() {
        logger.debug("Will try to move to " + womenTopMenu.getText());
        actions.moveToElement(womenTopMenu).build().perform();
        logger.debug("Moved to element " + womenTopMenu.getText());
        logger.debug("Will wait for visibility of " + menuWomanDisplayed.getText());
        wait.until(ExpectedConditions.visibilityOf(menuWomanDisplayed));
        logger.debug("Opened top menu " + menuWomanDisplayed.getText());
        return this;
    }

    public boolean isWomenMenuDisplayed() {
        logger.debug("Will check if " + womenTopMenu.getText() + " is displayed");
        return menuWomanDisplayed.isDisplayed();
    }

    public ContactPagePO goToContactPage() {
        logger.debug("Trying to open Contact page");
        wait.until(ExpectedConditions.elementToBeClickable(contactLink));
        contactLink.click();
        return new ContactPagePO(driver);
    }

    public HomepagePO(WebDriver driver) {
        super(driver);
    }
}
