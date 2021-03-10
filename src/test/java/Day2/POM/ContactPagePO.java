package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ContactPagePO extends HomepagePO {
    Logger logger = Logger.getLogger(ContactPagePO.class);

    @FindBy(css = "body[id*=\"contact\"]") private WebElement contactPage;

    @FindBy(css = "label[for*=\"id_contact\"]")  private WebElement dropBoxLabel;
    @FindBy(css = "select[id*=\"id_contact\"]")  private WebElement dropBoxSelector;
    @FindBy(css = "div[id*=\"uniform-id_contact\"]")  private WebElement dropBox;

    @FindBy(css = "label[for*=\"email\"]")  private WebElement emailBoxLabel;
    @FindBy(css = "input[id*=\"email\"]")  private WebElement emailBox;

    @FindBy(xpath = "//input[@id=\"id_order\"]//..//label")  private WebElement referenceLabel;
    @FindBy(xpath = "//input[@id=\"id_order\"]")  private WebElement reference;

    @FindBy(css = "input[id*=\"fileUpload\"]")  private WebElement fileUploadButton;
    @FindBy(css = "label[for*=\"fileUpload\"]")  private WebElement fileUploadLabel;
    @FindBy(css = "div[id*=\"uniform-fileUpload\"]")  private WebElement fileUpload;

    @FindBy(css = "label[for*=\"message\"]")  private WebElement messageBoxLabel;
    @FindBy(css = "textarea[id*=\"message\"]")  private WebElement messageBox;

    @FindBy(css = "#submitMessage")  private WebElement sendMessageButton;
    @FindBy(css = ".alert-success")  private WebElement messageSentSucess;

    public boolean contactPageisDisplayed() {
        logger.debug("check if contactPage is displayed");
        logger.trace("Status of contactPage displayed: "+contactPage.isDisplayed());
        return contactPage.isDisplayed();
    }

    public boolean dropBoxisDisplayed() {
        logger.debug("check if dropBox is displayed");
        logger.trace("Status of dropBox displayed: "+dropBox.isDisplayed());
        logger.trace("Status of dropBoxLabel displayed: "+dropBoxLabel.isDisplayed());
        return dropBox.isDisplayed() && dropBoxLabel.isDisplayed();
    }

    public boolean emailBoxisDisplayed() {
        logger.debug("check if emailBox is displayed");
        logger.trace("Status of emailBox displayed: "+emailBox.isDisplayed());
        logger.trace("Status of emailBoxLabel displayed: "+emailBoxLabel.isDisplayed());
        return emailBox.isDisplayed() && emailBoxLabel.isDisplayed();
    }

    public boolean referenceisDisplayed() {
        logger.debug("check if reference is displayed");
        logger.trace("Status of reference displayed: "+reference.isDisplayed());
        logger.trace("Status of referenceLabel displayed: "+referenceLabel.isDisplayed());
        return reference.isDisplayed() && referenceLabel.isDisplayed();
    }

    public boolean fileUploadisDisplayed() {
        logger.debug("check if fileUpload is displayed");
        logger.trace("Status of fileUpload displayed: "+fileUpload.isDisplayed());
        logger.trace("Status of fileUploadLabel displayed: "+fileUploadLabel.isDisplayed());
        logger.trace("Status of fileUploadButton displayed: "+fileUploadButton.isDisplayed());
        return fileUpload.isDisplayed() && fileUploadLabel.isDisplayed() && fileUploadButton.isDisplayed();
    }

    public boolean messageBoxisDisplayed() {
        logger.debug("check if messageBox is displayed");
        logger.trace("Status of messageBox displayed: "+messageBox.isDisplayed());
        logger.trace("Status of messageBoxLabel displayed: "+messageBoxLabel.isDisplayed());
        return messageBox.isDisplayed() && messageBoxLabel.isDisplayed();
    }

    public void sentTestMessage(String subjectHeading, String emailAddressTo, String orderReference, String fileToUpload, String messageTest) {
        logger.debug("Trying to fill data to send test message");

        logger.trace("Data to fill - subjectHeading data: "+subjectHeading);
        Select select = new Select(dropBoxSelector);
        select.selectByValue(subjectHeading);

        logger.trace("Data to fill - emailAddressTo data: "+emailAddressTo);
        emailBox.sendKeys(emailAddressTo);

        logger.trace("Data to fill - orderReference data: "+orderReference);
        reference.sendKeys(orderReference);

        logger.trace("Data to fill - fileToUpload data: "+fileToUpload);
        fileUploadButton.sendKeys(fileToUpload);

        logger.trace("Data to fill - messageTest data: "+messageTest);
        messageBox.sendKeys(messageTest);

        logger.debug("Trying to sent test message");
        logger.trace("Waiting for send button available");
        wait.until(ExpectedConditions.elementToBeClickable(sendMessageButton));
        logger.trace("Clicking send button");
        sendMessageButton.click();
    }

    public boolean messageSendingStatus (){
        logger.debug("check if message is sent");
        logger.trace("Status of messageSentSucess : "+messageSentSucess.isDisplayed());
        return messageSentSucess.isDisplayed();
    }


    public ContactPagePO(WebDriver driver) {
        super(driver);
    }



}
