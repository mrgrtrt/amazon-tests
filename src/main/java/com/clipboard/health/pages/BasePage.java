package com.clipboard.health.pages;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public abstract class BasePage {

    protected Page page;

    @Step
    protected void checkElementVisible(String locator) {
        assertThat(page.locator(locator)).isVisible();
    }
}
