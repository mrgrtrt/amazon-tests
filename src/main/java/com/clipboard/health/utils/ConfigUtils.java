package com.clipboard.health.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigUtils {

    public static final Map<String, String> DEFAULTS = loadProperties("config.properties");

    private static Map<String, String> loadProperties(String resource) {
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            Properties properties = new Properties();
            properties.load(is);
            Map<String, String> config = new HashMap<>();
            properties.forEach((key, value) -> config.put(key.toString(), value.toString()));
            return config;
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid properties file.", e);
        }
    }

    public static class ConfigKeys {
        public static final String URL = "amazon.url";
        public static final String HEADLESS = "headless.mode";
    }
}
