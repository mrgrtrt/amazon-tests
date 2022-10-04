package com.clipboard.health.elements;

import com.clipboard.health.enums.SortingOption;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SortSelector {

    private static final String SELECTOR = "select#s-result-sort-select";
    private static final String SELECTED_OPTION = " option[selected]";
    private final Page page;

    public SortSelector(Page page) {
        this.page = page;
        assertThat(page.locator(SELECTOR)).isVisible();
    }

    @Step
    public void sortBy(SortingOption option) {
        SelectOption selectOption = new SelectOption().setLabel(option.getOption());
        page.locator(SELECTOR).selectOption(selectOption);

        assertThat(page.locator(SELECTOR + SELECTED_OPTION)).hasText(option.getOption());
    }
}
