package api;

import configuration.CommentEndpoint;
import configuration.PostsEndpoint;
import model.comments.Comments;
import model.posts.Post;
import model.users.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class PostsAPITests extends PostsEndpoint {

    @Test
    public void get_post_with_id_1_and_check_model() {

        Post model = getPost(1);

        Assertions.assertEquals(200,lastResponse.statusCode());
        Assertions.assertEquals(model.id,1);
    }

    @Test
    public void put_model_post_and_check_data() {
        Post model = getPost(1);
        model.setBody("New body descriptions");
        model.setBody("New title descriptions");

        given()
                .contentType("application/json")
                .body(model)
                .when()
                .put(endPoint + "/1")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("body",is(model.body))
                .and()
                .assertThat()
                .body("id",is(1));

    }
//    @Test
//    public void get_specific_post_of_single_user() {
//
//
//       Users user = given()
//                .body(model)
//                .when()
//                .post(endPoint)
//                .then()
//                .assertThat()
//                .statusCode(201)
//                .and()
//                .assertThat()
//                .body("body",is(model.body))
//                .and()
//                .assertThat()
//                .body("id",is(501));
//
//    }
//
}
