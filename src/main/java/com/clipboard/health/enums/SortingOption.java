package com.clipboard.health.enums;

public enum SortingOption {
    FEATURED("Featured"),
    PRICE_LOW_TO_HIGH("Price: Low to High"),
    PRICE_HIGH_TO_LOW("Price: High to Low"),
    CUSTOMER_REVIEW("Avg. Customer Review"),
    NEWEST_ARRIVALS("Newest Arrivals");

    private final String option;

    SortingOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
