package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();
    private static final String env;

    static {
        env = System.getProperty("env", "local"); // default = local
        String fileName = "config/" + env + ".properties";

        try (InputStream is = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (is == null) {
                throw new RuntimeException(fileName + " not found in resources");
            }

            properties.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load " + fileName, e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
