package com.clipboard.health.pages;

import com.clipboard.health.elements.FilterPanel;
import com.clipboard.health.enums.FilterCategory;
import com.clipboard.health.enums.FilterItem;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CategoryPage extends BasePage {

    private final static String CHOSEN_CATEGORY = "//span[@class='a-list-item']/span[contains(@class,'a-text-bold')]";

    protected FilterPanel filterPanel;

    public CategoryPage(Page page, String chosenCategory) {
        this.page = page;
        this.filterPanel = new FilterPanel(page);
        verifyCategoryPageShown(chosenCategory);
    }

    @Step
    public ResultsPage filterResults(FilterCategory category, FilterItem item) {
        filterPanel.checkFilterCheckbox(category, item);

        return new ResultsPage(page);
    }

    @Step
    private void verifyCategoryPageShown(String chosenCategory) {
        assertThat(page.locator(CHOSEN_CATEGORY)).containsText(chosenCategory);
    }
}
