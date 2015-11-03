package com.fred.ejingtong;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.7
 * @since 2015/7/8
 */
public class PropertiesUtil {

    public static String clientId = null;

    static {
        clientId = getClientId();
    }

    private static String getClientId() {

        Properties properties = new Properties();
        try {
            properties.load(new BufferedInputStream(new FileInputStream("src/main/resources/client_id.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty("id");
    }

}
