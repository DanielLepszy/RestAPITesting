package unitTests;

import data.CountriesName;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CountriesNameTest {
    static HashSet<String> countriesName;

    @BeforeAll
    public static void setCountriesNameSet() {
        countriesName = new CountriesName().getCountriesName();
    }

    @Test
    public void getCountriesName() {

        String countryNameWithSpecialSymbol = countriesName.stream().
                filter(x -> x.equals("Åland Islands")).collect(Collectors.joining());

        assertEquals(countryNameWithSpecialSymbol, "Åland Islands");
    }

    @Test
    void getCountriesNameArray() {

        //TODO Improve UTF-8. String not provide some symbols ex. 'é'
        String rawString = "Réunion";
        byte[] bytes = rawString.getBytes(StandardCharsets.UTF_16);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);


        ArrayList<String> countriesNameArray = new ArrayList<>(countriesName);

        String countryNameWithSpecialSymbol = countriesNameArray.stream().
                filter(x -> x.equals("Réunion")).collect(Collectors.joining());

        assertEquals(countryNameWithSpecialSymbol, "Réunion");
    }
}