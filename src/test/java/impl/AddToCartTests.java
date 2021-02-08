package impl;

import api.BaseTest;
import com.epam.locators.pages.CardPage;
import com.epam.locators.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTest {

    public static final String AMOUNT_OF_GOOGS_ONE = "1";
    public static final String AMOUNT_OF_GOODS_TWO = "2";

    @Test
    public void checkAmountOfProductInCard() {
        storage.getPage(HomePage.class)
                .open()
                .clickAddToCardButton();
        storage.getPage(CardPage.class)
                .clickComebackButton();
        Assert.assertEquals(AMOUNT_OF_GOOGS_ONE, storage.getPage(HomePage.class).getAmountOfGoodsInTheCardText());
        storage.getPage(HomePage.class)
                .clickAddToCardPhoneButton();
        storage.getPage(CardPage.class)
                .clickComebackButton();
        Assert.assertEquals(AMOUNT_OF_GOODS_TWO, storage.getPage(HomePage.class).getAmountOfGoodsInTheCardText());

    }

    @Test
    public void checkCardPopupElements() {
        storage.getPage(HomePage.class).open().clickAddToCardButton();
        Assert.assertTrue(storage.getPage(CardPage.class).checkoutOrderButtonIsDisplayed());
        Assert.assertTrue(storage.getPage(CardPage.class).priceTextIsDisplayed());
        Assert.assertTrue(storage.getPage(CardPage.class).closeIconIsDisplayed());
        Assert.assertTrue(storage.getPage(CardPage.class).HeaderTitleCardIsDisplayed());
        Assert.assertTrue(storage.getPage(CardPage.class).comebackToGoodsButtonIsDisplayed());
    }
}
