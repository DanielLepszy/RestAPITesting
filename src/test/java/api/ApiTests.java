package api;

import configReader.ConfigReader;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ApiTests extends ConfigReader {

   String uri = readProperties("URI");

    @Test
    public void
    get_resource_and_check_status_200() {
        when().
                get("https://restcountries.eu/").
                then().
                statusCode(200);
    }

    @Test
    public void
    get_all_endpoint_resource_and_check_status_200() {

        when().get(uri+"/all").
                then().
                statusCode(200);
    }

    @Test
    public void
    get_country_name_endpoint_resource_and_check_JSON_Schema() {

        when().get("https://restcountries.eu/rest/v2/name/poland").
                then().assertThat().body(matchesJsonSchemaInClasspath("country_name.json"));

    }

    @Test
    public void
    get_country_name_endpoint_resource_and_check_if_currencies_name_is_proper() {

        when().
                get("https://restcountries.eu/rest/v2/name/poland").
                then().
                body("currencies[0].code", hasItems("PLN"));

    }

    @Test
    public void
    get_country_name_endpoint_resource_and_check_if_borders_contain_proper_amount() {

        String[] borders = {"BLR", "CZE", "DEU", "LTU", "RUS", "SVK"};
        when().
                get("https://restcountries.eu/rest/v2/name/poland").
                then().assertThat().statusCode(200).and().
                body("[0].borders", hasItems(borders));

    }
    @Test
    public void
    get_country_full_name_endpoint_resource_and_check_if_borders_contain_proper_amount() {

        String[] borders = {"BLR", "CZE", "DEU", "LTU", "RUS", "SVK"};
        when().
                get("https://restcountries.eu/rest/v2/name/{name}?fullText=true").
                then().assertThat().statusCode(200).and().
                body("[0].borders", hasItems(borders));

    }
}
