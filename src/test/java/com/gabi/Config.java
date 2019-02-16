package com.gabi;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public interface Config {

    default void loadProps() {
        if (System.getProperty("env").equals("staging")) {
            try {
                Properties prop = System.getProperties();
                InputStream input = Config.class.getClassLoader().getResourceAsStream("envs/staging.properties");
                prop.load(input);
                System.setProperties(prop);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
