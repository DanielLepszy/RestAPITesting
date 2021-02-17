package configuration;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.posts.Post;
import model.users.Address;
import model.users.Company;
import model.users.Geo;
import model.users.Users;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;

public class UsersEndpoint extends ConfigurationTestBase {


    protected final String endPoint = "/users";

    public Users getUser(int id) {
        lastResponse = get(endPoint + "/" + id);
        return lastResponse.as(Users.class);
    }


}
