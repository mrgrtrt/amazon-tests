package com.clipboard.health.elements;

import com.clipboard.health.enums.FilterCategory;
import com.clipboard.health.enums.FilterItem;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.lang.String.format;

public class FilterPanel {
    private final Page page;

    private static final String FILTER_PANEL = "#s-refinements";
    private static final String FILTER_CATEGORY = "//div[@id='s-refinements']//div[div/span = '%s']";
    private static final String ITEM_CHECKBOX_ICON = "//a[span='%s']//i";
    //different locator for checkbox, because original checkbox is under the icon
    private static final String ITEM_CHECKBOX = "//a[span='%s']//input[@type='checkbox']";
    private static final String CATEGORY_CLEAR = "//a[contains(@class, 's-navigation-clear-link')]";

    public FilterPanel(Page page) {
        this.page = page;
        assertThat(page.locator(FILTER_PANEL)).isVisible();
    }

    @Step
    public void checkFilterCheckbox(FilterCategory category, FilterItem item) {
        page.locator(format(FILTER_CATEGORY + ITEM_CHECKBOX_ICON, category.getCategory(), item.getFilterItem()))
                .click();

        assertThat(page.locator(format(FILTER_CATEGORY + ITEM_CHECKBOX, category.getCategory(), item.getFilterItem())))
                .isChecked();
        assertThat(page.locator(format(FILTER_CATEGORY + CATEGORY_CLEAR, category.getCategory())))
                .isVisible();
    }
}
