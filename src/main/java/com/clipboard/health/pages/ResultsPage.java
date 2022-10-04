package com.clipboard.health.pages;

import com.clipboard.health.elements.SortSelector;
import com.clipboard.health.enums.SortingOption;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ResultsPage extends BasePage {

    private static final String RESULTS_BAR = "span[data-component-type='s-result-info-bar']";
    private static final String RESULTS_HEADER = ".s-messaging-widget-results-header";
    private static final String PRODUCT_CARD_TITLE = ".s-main-slot>.s-result-item[data-uuid] span.a-text-normal";

    private final SortSelector sortSelector;

    public ResultsPage(Page page) {
        this.page = page;
        this.sortSelector = new SortSelector(page);
        verifyResultsBarShown();
    }

    @Step
    public void sortBy(SortingOption option) {
        sortSelector.sortBy(option);
    }

    @Step
    public ProductPage openProductPage(Integer productIndex) {
        Locator locator = page.locator(PRODUCT_CARD_TITLE).nth(--productIndex);
        String productTitle = locator.innerText();
        Page newPage = page.context().waitForPage(locator::click);
        newPage.waitForLoadState();

        return new ProductPage(newPage, productTitle);
    }

    @Step
    private void verifyResultsBarShown() {
        assertThat(page.locator(RESULTS_BAR)).isVisible();
        assertThat(page.locator(RESULTS_HEADER)).isVisible();
    }
}
