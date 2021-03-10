package Day2;

import Day2.POM.ContactPagePO;
import Day2.POM.HomepagePO;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTests extends BaseTest {

    // homepage -> contac us - sprawdzenie załadowania potrzebnych elementów
    // homepage -> contac us - wysanie wiadomości
    // homepage -> contac us - wysłanie wiadomości drugiego typu (Cust service / Webmaster)

    @Test
    public void testOpenContactMessage() {
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactPagePO contactPagePO = new ContactPagePO(driver);

        //when
        homepagePO.openMe().goToContactPage();

        //then
        Assert.assertTrue(contactPagePO.contactPageisDisplayed());
        Assert.assertTrue(contactPagePO.dropBoxisDisplayed());
        Assert.assertTrue(contactPagePO.emailBoxisDisplayed());
        Assert.assertTrue(contactPagePO.referenceisDisplayed());
        Assert.assertTrue(contactPagePO.fileUploadisDisplayed());
        Assert.assertTrue(contactPagePO.messageBoxisDisplayed());
    }

    @Test
    public void testSendContactMessage1() {
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactPagePO contactPagePO = new ContactPagePO(driver);
        String subjectHeading = "1";
        String emailAddressTo = "test@example.com";
        String orderReference = "None";
        String fileToUpload = "C:\\Users\\a790930\\OneDrive - Atos\\Desktop\\Selenium Advanced\\Automatyzacja032021\\src\\test\\java\\Day2\\test.txt";
        String messageTest = "Test Message";

        //when
        homepagePO.openMe().goToContactPage();
        contactPagePO.sentTestMessage(subjectHeading, emailAddressTo, orderReference, fileToUpload, messageTest);

        //then
        Assert.assertTrue(contactPagePO.contactPageisDisplayed());
        Assert.assertTrue(contactPagePO.messageSendingStatus());
    }

    @Test
    public void testSendContactMessage2() {
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactPagePO contactPagePO = new ContactPagePO(driver);
        String subjectHeading = "2";
        String emailAddressTo = "test@example.com";
        String orderReference = "None";
        String fileToUpload = "C:\\Users\\a790930\\OneDrive - Atos\\Desktop\\Selenium Advanced\\Automatyzacja032021\\src\\test\\java\\Day2\\test.txt";
        String messageTest = "Test Message";

        //when
        homepagePO.openMe().goToContactPage();
        contactPagePO.sentTestMessage(subjectHeading, emailAddressTo, orderReference, fileToUpload, messageTest);

        //then
        Assert.assertTrue(contactPagePO.contactPageisDisplayed());
        Assert.assertTrue(contactPagePO.messageSendingStatus());
    }
}
