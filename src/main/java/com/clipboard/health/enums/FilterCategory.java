package com.clipboard.health.enums;

public enum FilterCategory {
    BRANDS("Brands");
    private final String category;

    FilterCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
