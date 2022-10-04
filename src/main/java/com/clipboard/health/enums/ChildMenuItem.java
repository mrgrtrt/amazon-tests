package com.clipboard.health.enums;

public enum ChildMenuItem {
    TELEVISIONS("Televisions");
    private final String item;
    ChildMenuItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
