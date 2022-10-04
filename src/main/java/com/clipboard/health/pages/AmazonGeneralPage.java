package com.clipboard.health.pages;

import com.clipboard.health.elements.HamburgerMenu;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class AmazonGeneralPage extends BasePage {

    private static final String AMAZON_LOGO = "#nav-logo";

    private final HamburgerMenu hamburgerMenu;

    public AmazonGeneralPage(Page page) {
        this.page = page;
        checkElementVisible(AMAZON_LOGO);
        this.hamburgerMenu = new HamburgerMenu(this.page);
    }

    @Step
    public HamburgerMenu getHamburgerMenu() {
        return hamburgerMenu;
    }
}
