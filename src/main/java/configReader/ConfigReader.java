package configReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop = new Properties();
    InputStream input = null;

    public void readProperties(String property) {

        try {
            input = new FileInputStream("src/test/resources/gradle.properties");
            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty(property));
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}