package com.clipboard.health.utils;

import io.qameta.allure.Allure;

public class AllureUtils {

    /**
     * Add custom message to Allure report within the step.
     *
     * @param message message text
     */
    public static void logToAllure(String message) {
        Allure.addAttachment("Log message: ", message);
    }
}