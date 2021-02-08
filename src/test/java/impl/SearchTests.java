package impl;

import api.BaseTest;
import com.epam.locators.pages.HomePage;
import com.epam.locators.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchTests extends BaseTest {

    private String searchWord;
    public static final String PATH_TO_DATA_FILE = "src/test/resources/searchWords.data";

    @DataProvider(name = "searchWords")
    public static Object[] searchWords() {
        return new Object[]{"lg", "apple", "red"};
    }

    public SearchTests(String searchWord) {
        this.searchWord = searchWord;
    }

    @DataProvider(name = "loadSearchWordsFromFile")
    public static Object[] loadSearchWordsFromFile() throws IOException {
        List<String> searchWordsList = new ArrayList<>();
        try (Scanner text = new Scanner(new File(PATH_TO_DATA_FILE ))) {
            while (text.hasNext()) {
                String print = text.nextLine();
                searchWordsList.add(print);
            }
        }
        return searchWordsList.toArray();
    }

    @Test(dataProvider = "searchWords")
    public void SearchResultItemsContainSearchWord(String searchWord) {
        storage.getPage(HomePage.class)
                .open()
                .setTextToSearchInput(searchWord)
                .clickResultLink();
        Assert.assertTrue(storage.getPage(ResultPage.class).checkSearchWordsInResults(searchWord));
    }
}
