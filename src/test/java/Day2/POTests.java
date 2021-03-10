package Day2;

import Day2.POM.HomepagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POTests extends BaseTest {

    @Test
    public void firstPOTest() {
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        //when
        homepagePO.openMe();

        //then
        Assert.assertTrue(homepagePO.isDisplayed());
    }

    @Test
    public void firstPOTestZPomiaremCzasu() {
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        //when
        long czas = System.currentTimeMillis();
        homepagePO.openMe();
        long ladowanie = System.currentTimeMillis() - czas;
        logger.fatal("Czas ładowania = " + ladowanie);
        //then
        Assert.assertTrue(homepagePO.isDisplayed());
    }

    //Zadanie:
    //Najechać na Woman
    //Sprawdzić, że wyświetla się podmenu
    @Test
    public void firstWomanTest() {
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        //when
        homepagePO.openMe();
        homepagePO.openWomenTopMenu();
        //then
        Assert.assertTrue(homepagePO.isWomenMenuDisplayed());
    }

    @Test
    public void womenMenuTest(){
        HomepagePO homepagePO = new HomepagePO(driver);

        boolean wynik = homepagePO
                .openMe()
                .openWomenTopMenu()
                .isWomenMenuDisplayed();
        Assert.assertTrue(wynik);
    }

    @Test
    public void priceOfFirstProductTest(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        double expectedPrice = 16.51;

        //when
        double result = homepagePO.openMe().getNthPrice(1);

        //then
        Assert.assertEquals(result,expectedPrice);
    }

}
