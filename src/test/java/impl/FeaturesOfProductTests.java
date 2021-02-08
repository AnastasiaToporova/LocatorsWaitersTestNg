package impl;

import api.BaseTest;
import com.epam.locators.pages.HomePage;
import com.epam.locators.pages.MainInfoAboutProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FeaturesOfProductTests extends BaseTest {

    @Test
    public void checkChangeColorOfSelectedProduct() {
        storage.getPage(HomePage.class).open().clickSelectedColorLink();
        Assert.assertTrue(storage.getPage(MainInfoAboutProductPage.class).checkColorsProduct());
    }
}
