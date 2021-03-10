package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductMiniaturePO {
    Logger logger = Logger.getLogger(ProductMiniaturePO.class);
    protected WebDriver driver;

//    @FindBy(xpath = "//*[@class=\"product-container\"]")
//    private WebElement productContainer;
//    @FindBy(xpath = "//*[@class=\"product-price\"]")
//    private WebElement price;
    @FindBy(css = ".right-block [itemprop=\"price\"]")
    private WebElement price;

    @FindBy(xpath = "//*[@class=\"product-name\"]")
    private WebElement productName;

    // to poprawić
    @FindBy(css = ".ajax_add_to_cart_button")
    private WebElement addToCartButton;

//    public HomepagePO getPrice(WebElement e){}
//    public boolean isProductNameDisplayed(WebElement e){}
//    public boolean isProductPriceDisplayed(WebElement e){}
//    public boolean isProductAddToChartButtonDisplayed(WebElement e){}
//    public boolean isProductMoreButtonDisplayed(WebElement e){}

    public double getPrice(){
        return Double.parseDouble(price.getText().replace("$","").replace(" ",""));
    }

    public String getProductName(){
        return productName.getText();
    }
    public void addToCart(){
        Actions actions = new Actions(driver);
        actions.moveToElement(productName);
        addToCartButton.click();
    }

    public ProductMiniaturePO(WebElement productContainer, WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new DefaultElementLocatorFactory(productContainer), this);
    }

}
