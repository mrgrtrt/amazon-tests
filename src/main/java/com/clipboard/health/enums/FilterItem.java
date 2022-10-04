package com.clipboard.health.enums;

public enum FilterItem {
    SAMSUNG("Samsung");

    private final String filterItem;

    FilterItem(String filterItem) {
        this.filterItem = filterItem;
    }

    public String getFilterItem() {
        return filterItem;
    }
}
