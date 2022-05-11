package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties;
    private static final HashMap<String, String> map = new HashMap<>();

    private ConfigLoader() {

    }

    public static HashMap<String, String> getConfigLoader() {
        if (Objects.isNull(properties)) {
            properties = new Properties();

            try {
                properties.load(new FileInputStream("src/test/resources/config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            properties.forEach((key, value) -> map.put(String.valueOf(key), String.valueOf(value)));
        }

        return map;

    }

}
