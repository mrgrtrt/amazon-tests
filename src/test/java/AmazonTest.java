import com.clipboard.health.pages.AmazonGeneralPage;
import com.clipboard.health.pages.ResultsPage;
import com.clipboard.health.utils.AllureUtils;
import org.testng.annotations.Test;

import static com.clipboard.health.enums.ChildMenuItem.TELEVISIONS;
import static com.clipboard.health.enums.FilterCategory.BRANDS;
import static com.clipboard.health.enums.FilterItem.SAMSUNG;
import static com.clipboard.health.enums.ParentMenuItem.TV_APPLIANCES;
import static com.clipboard.health.enums.SortingOption.PRICE_HIGH_TO_LOW;

public class AmazonTest extends BaseTest {

    @Test(description = "Filter results and log product description to Allure report")
    void verifyAboutThisItemTextTest() {
        ResultsPage resultsPage = new AmazonGeneralPage(page)
                .getHamburgerMenu()
                .expandHamburgerMenu()
                .chooseFromExpandableMenuItem(TV_APPLIANCES, TELEVISIONS)
                .filterResults(BRANDS, SAMSUNG);
        resultsPage
                .sortBy(PRICE_HIGH_TO_LOW);
        String productDescription = resultsPage.openProductPage(2)
                .getProductDescription();

        AllureUtils.logToAllure(productDescription);
    }
}
