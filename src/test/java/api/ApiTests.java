package api;

import com.sun.xml.bind.v2.TODO;
import configReader.ConfigReader;
import data.CountriesName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ApiTests extends ConfigReader {

    String uri = readProperties("URI");

    //    @Test
//    public void
//    get_resource_and_check_status_200() {
//        when().
//                get("https://restcountries.eu/").
//                then().
//                statusCode(200);
//    }
//
//    @Test
//    public void
//    get_all_endpoint_resource_and_check_status_200() {
//
//        when().get(uri+"/all").
//                then().
//                statusCode(200);
//    }
//
//    @Test
//    public void
//    get_country_name_endpoint_resource_and_check_JSON_Schema() {
//
//        when().get("https://restcountries.eu/rest/v2/name/poland").
//                then().assertThat().body(matchesJsonSchemaInClasspath("country_name.json"));
//
//    }
//
    //TODO Repair UTF-8 with symbols.Last endpoint is wrong
    @Test
    public void
    get_country_name_endpoint_resource_and_check_if_currencies_name_is_proper() {
        HashSet<String> countriesName = new CountriesName().getCountriesName();
        List<String> list = new ArrayList<String>(countriesName);
        String url = "";

        for (int x = 0; x < countriesName.size(); x++) {

            url = "https://restcountries.eu/rest/v2/name/" + list.get(x);
            System.out.println(url);
            when().
                    get(url).
                    then().
                    statusCode(200);

        }
    }

//
//    @Test
//    public void
//    get_country_name_endpoint_resource_and_check_if_borders_contain_proper_amount() {
//
//        String[] borders = {"BLR", "CZE", "DEU", "LTU", "RUS", "SVK"};
//        when().
//                get("https://restcountries.eu/rest/v2/name/poland").
//                then().assertThat().statusCode(200).and().
//                body("[0].borders", hasItems(borders));
//
//    }
//    @Test
//    public void
//    get_country_full_name_endpoint_resource_and_check_if_borders_contain_proper_amount() {
//
//        String[] borders = {"BLR", "CZE", "DEU", "LTU", "RUS", "SVK"};
//        when().
//                get("https://restcountries.eu/rest/v2/name/{name}?fullText=true").
//                then().assertThat().statusCode(200).and().
//                body("[0].borders", hasItems(borders));
//
//    }
//    @Test
//    public void
//    get_all_country_name_endpoint_resource_and_check_if_amount_is_equal() {
//
//        when().
//                get("https://restcountries.eu/rest/v2/all").
//                then().assertThat().statusCode(200).and().
//                body("findAll{it->it.name}.size()", is(250));
//
//    }
}
