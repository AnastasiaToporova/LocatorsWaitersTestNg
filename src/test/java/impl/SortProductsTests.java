package impl;

import api.BaseTest;
import com.epam.locators.pages.HomePage;
import com.epam.locators.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SortProductsTests extends BaseTest {
    @BeforeMethod
    public void chooseGoods() {
        storage
                .getPage(HomePage.class)
                .open()
                .setTextToSearchInput("lg")
                .clickResultLink();
    }
    @Test
    public void checkSortProductByPriceDescending() {
        storage.getPage(HomePage.class).clickSortProductsByDescending();
        Assert.assertTrue(storage.getPage(ResultPage.class).checkPriseDescendingOrder());
    }
    @Test
    public void checkSortProductByPriceAscending() {

        storage.getPage(HomePage.class).clickSortProductsByAscending();
        Assert.assertTrue(storage.getPage(ResultPage.class).checkPriseAscendingOrder());
    }


}
