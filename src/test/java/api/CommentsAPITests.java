package api;

import configuration.CommentEndpoint;
import io.restassured.response.ResponseBody;
import model.comments.Comments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class CommentsAPITests extends CommentEndpoint {

    @Test
    public void get_comment_with_id_1_and_check_model() {
        Comments model = new Comments(1, 1, "id labore ex et quam laborum",
                "Eliseo@gardner.biz",
                "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium");

        Comments comment = getComment(1);

        Assertions.assertEquals(comment.body, model.body);
        Assertions.assertEquals(comment.email, model.email);
    }

    @Test
    public void put_model_comment_and_check_data() {
        Comments model = getComment(1);
        model.setBody("New body descriptions");

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
                .body("body", is(model.body))
                .and()
                .assertThat()
                .body("id", is(1));

    }

    @Test
    public void post_new_comment_and_check_data() {
        Comments model = new Comments(0, 1, "New name for request",
                "newEmail@user.com",
                "New body descriptions");

        given()
                .contentType("application/json")
                .body(model)
                .when()
                .post(endPoint)
                .then()
                .assertThat()
                .statusCode(201)
                .and()
                .assertThat()
                .body("body", is(model.body))
                .and()
                .assertThat()
                .body("id", is(501));

    }

    @Test
    public void check_all_comments_of_sigle_post() {
        int postId = 1;

        List<Integer> id_comments  = given()
                .queryParam("postId", postId)
                .when()
                .get(endPoint)
                .jsonPath().get("id");

        int commentId = id_comments.get(0);

        Comments model = getComment(id_comments.get(0));

        String json = given()
                .queryParam("postId",postId)
                .queryParam("id",commentId)
                .when()
                .get(endPoint)
                .jsonPath().get("[0]").toString();

        Assertions.assertEquals(200,getLastStatusCode());
        Assertions.assertEquals(model.toString(),json);

    }
}
