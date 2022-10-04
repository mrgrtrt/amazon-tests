package com.clipboard.health.elements;

import com.clipboard.health.enums.ChildMenuItem;
import com.clipboard.health.enums.ParentMenuItem;
import com.clipboard.health.pages.CategoryPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HamburgerMenu {

    private final Page page;
    private static final String HAMBURGER_MENU = "#nav-hamburger-menu";
    private final static String MENU_CLOSE = ".hmenu-close-icon";
    private final static String MENU_OPENED = "ul.hmenu-visible";
    private final static String PARENT_MENU_ITEM = "//*[@class='hmenu-item']/div[text()='%s']/parent::a";
    private final static String CHILD_MENU_ITEM = "//ul[contains(@class, 'hmenu-visible') and @data-menu-id='%s']" +
            "//*[@class='hmenu-item' and text()='%s']";
    private final static String BACK_TO_MAIN_MENU = "//ul[contains(@class, 'hmenu-visible') and @data-menu-id='%s']" +
            "//*[contains(@class, 'hmenu-back-button')]";
    private final static String UNIQUE_ELEMENT_ID = "data-menu-id";

    public HamburgerMenu(Page page) {
        this.page = page;
        assertThat(this.page.locator(HAMBURGER_MENU)).isVisible();
    }

    @Step
    public void closeMenu() {
        page.locator(MENU_CLOSE).click();
        assertThat(page.locator(MENU_OPENED)).not().isVisible();
    }

    @Step
    public CategoryPage chooseFromExpandableMenuItem(ParentMenuItem parentItem, ChildMenuItem childItem) {
        Locator parentMenuItemLocator = page.locator(String.format(PARENT_MENU_ITEM, parentItem.getItem()));
        String dataMenuId = parentMenuItemLocator.getAttribute(UNIQUE_ELEMENT_ID);
        parentMenuItemLocator.click();

        assertThat(page.locator(String.format(BACK_TO_MAIN_MENU, dataMenuId))).isVisible();

        page.locator(String.format(CHILD_MENU_ITEM, dataMenuId, childItem.getItem())).click();
        assertThat(page.locator(MENU_OPENED)).not().isVisible();

        return new CategoryPage(page, childItem.getItem());
    }

    @Step
    public HamburgerMenu expandHamburgerMenu() {
        page.locator(HAMBURGER_MENU).click();
        assertThat(page.locator(MENU_OPENED)).isVisible();
        return this;
    }
}
