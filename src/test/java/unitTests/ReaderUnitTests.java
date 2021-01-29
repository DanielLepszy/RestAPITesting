package unitTests;

import configReader.ConfigReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReaderUnitTests extends ConfigReader {

    /**
     * Test if reader return proper value of property
     **/
    @Test
    public void testReadPropertyFromFile() {
        String property = readProperties("hostName");
        assertEquals(property, "restcountries.eu");
    }
    /**
     * Test if reader return proper value of property
     **/
    @Test
    public void testReadURIPropertyFromFile() {
        String property = readProperties("URI");
        assertEquals(property, "https://restcountries.eu/rest/v2");
    }
    /**
     * Test if reader return null value from non existed property
     **/
    @Test
    public void testReadNonExistedProperty() {
        String property = readProperties("XXX");
        assertNull(property);
    }
}
