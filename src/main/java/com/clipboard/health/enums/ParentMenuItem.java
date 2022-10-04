package com.clipboard.health.enums;

public enum ParentMenuItem {
    MOBILES_COMPUTERS("Mobiles, Computers"),
    TV_APPLIANCES("TV, Appliances, Electronics");

    private final String item;
    ParentMenuItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
