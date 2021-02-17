package configuration;

import model.comments.Comments;

import static io.restassured.RestAssured.get;

public class CommentEndpoint extends ConfigurationTestBase {

    protected final String endPoint = "/comments";

    public Comments getComment(int id){
        lastResponse = get(endPoint+"/"+id);
        return lastResponse.as(Comments.class);
    }


}
