package configuration;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public abstract class ConfigurationTestBase {

    private static final String uri = "http://jsonplaceholder.typicode.com";

    public ConfigurationTestBase() {
        RestAssured.baseURI = uri;
    }

    protected Response lastResponse;

    public Response getLastResponse() {
        return lastResponse;
    }

    public int getLastStatusCode() {
        return lastResponse.getStatusCode();
    }

}
