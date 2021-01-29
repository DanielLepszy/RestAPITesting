package unitTests;

import configReader.ConfigReader;
import data.CountriesName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfigReaderTest extends ConfigReader {

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

    /**
     * Test if reader return full endpoint with proper value
     **/
    @Test
    public void testSetValueToEndpoint() {
        String fullEndpoint = setValueToEndpoint("Name","poland");
        assertEquals(fullEndpoint,"https://restcountries.eu/rest/v2/name/poland");
    }
    /**
     * Test if reader return full endpoint with proper value
     **/

    @Test
    public void getNames() {
        CountriesName names= new CountriesName();

        System.out.println(names.getCountriesName());
    }
}