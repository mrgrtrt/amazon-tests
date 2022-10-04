package com.clipboard.health.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPage extends BasePage {

    private static final String PRODUCT_TITLE = "#productTitle";

    private static final String PRODUCT_DESCRIPTION = "#feature-bullets>ul";
    public ProductPage(Page page, String productTitle) {
        this.page = page;
        assertThat(page.locator(PRODUCT_TITLE)).hasText(productTitle);
    }

    @Step
    public String getProductDescription() {
        return page.locator(PRODUCT_DESCRIPTION).innerText();
    }
}
