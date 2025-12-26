package utils;

import java.io.InputStream;
import java.util.Properties;
public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream is = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (is == null) {
                throw new RuntimeException("config.properties not found");
            }
            properties.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
    String env = properties.getProperty("env");
    return properties.getProperty(env + "." + key);
}
}