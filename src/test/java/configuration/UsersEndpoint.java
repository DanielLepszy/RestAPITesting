package configuration;

import model.comments.Comments;
import model.posts.Post;

import static io.restassured.RestAssured.get;

public class PostsEndpoint extends ConfigurationTestBase {


    protected final String endPoint = "/posts";

    public Post getPost(int id) {
        lastResponse = get(endPoint + "/" + id);
        return lastResponse.as(Post.class);
    }
}
