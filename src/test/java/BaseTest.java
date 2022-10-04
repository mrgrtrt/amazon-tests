import com.clipboard.health.PlaywrightContext;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.clipboard.health.utils.ConfigUtils.ConfigKeys.URL;
import static com.clipboard.health.utils.ConfigUtils.DEFAULTS;

public class BaseTest {

    protected Browser browser;
    protected Page page;

    @BeforeSuite
    public void initBrowser() {
        this.browser = new PlaywrightContext().getChromeBrowser();
        this.page = browser.newPage();
        page.navigate(DEFAULTS.get(URL));
    }

    @AfterSuite
    public void tearDown() {
        browser.close();
    }
}
