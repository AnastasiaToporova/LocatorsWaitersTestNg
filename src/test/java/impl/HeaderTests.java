package impl;

import api.BaseTest;
import com.epam.locators.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HeaderTests extends BaseTest {

    public static final String COLOR_OF_HEADER_WHITE = "#ffffff";
    public static final String LANGUAGE_OF_PAGE_UK = "uk";

    @Test
    public void checkSwitchThemeOfHeader() {

        Assert.assertEquals(COLOR_OF_HEADER_WHITE, storage.getPage(HomePage.class)
                .open()
                .clickSwitcherThemeHeader()
                .getColorHeader());
    }

    @Test
    public void checkSwitchLanguageOfPage() {

        Assert.assertEquals(LANGUAGE_OF_PAGE_UK, storage.getPage(HomePage.class)
                .open()
                .clickSwitcherLanguageHeader()
                .getLanguageOfPage());
    }
}
