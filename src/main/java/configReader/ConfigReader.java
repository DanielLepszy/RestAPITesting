package configReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    FileInputStream input;
    Properties prop = new Properties();

    public  String readProperties(String property) {
        String value = null;

        try {
            input = new FileInputStream("src/test/resources/gradle.properties");
            // load a properties file
            prop.load(input);

            // get the property value and print it out
            value = prop.getProperty(property);
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
        if (property == null) System.out.println("Property name: " + property + "not exist in gradle.properties file");

        return value;
    }

}
