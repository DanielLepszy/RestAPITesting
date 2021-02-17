package api;

import configuration.CommentEndpoint;
import configuration.UsersEndpoint;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.comments.Comments;
import model.users.Address;
import model.users.Company;
import model.users.Geo;
import model.users.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class UsersAPITests extends UsersEndpoint {

    @Test
    public void update_user_address()
    {
        Users user = getUser(1);
        user.getAddress().setCity("Warsaw");
        user.getAddress().setStreet("Olegarska");
        user.getAddress().setZipcode("22-104");
        user.getAddress().setSuite("Fake 123");
        user.getAddress().getGeo().setLat(111.22f);
        user.getAddress().getGeo().setLng(80.88f);

        lastResponse = given()
                .contentType("application/json")
                .body(user)
                .when()
                .put(endPoint+"/1");
        Users updatedUser = lastResponse.as(Users.class);

        Assertions.assertEquals(200,getLastStatusCode());
        Assertions.assertEquals(user.toString(),updatedUser.toString());
    }
    @Test
    public void post_new_user()
    {
        Users user = new Users(0,"FakeName","Fake","fake@as.pl",
                new Address("FakeStreet","FakeSuite","Warsaw","123",
                        new Geo(111.2f,2222.1f)),
                "+12 123 544 200","abc.de.pl",
                new Company("FakeCompany","FakePhrase","vs"));

        lastResponse = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(endPoint);

        Users updatedUser = lastResponse.as(Users.class);

        Assertions.assertEquals(201,getLastStatusCode());
        user.setId(updatedUser.id);
        Assertions.assertEquals(user.toString(),updatedUser.toString());
    }

}
