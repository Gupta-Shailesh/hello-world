package RestAPITest.JsonPlaceHolderApiTest;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPlaceHolderApiMethods {
	
	Response response ;
	JsonPath jsonPath;
	
	
	public String getUserid(String userName)
	{
		System.out.println("I am in the getuserIdMethod");
		response =given().queryParam("username", userName).when().get("/users").then().statusCode(200).extract().response();
		jsonPath = ReusableMethods.rawToJson(response);
		String userid= jsonPath.getString("id").replaceAll("\\[","" ).replaceAll("\\]", "");
		
		return userid ;
	}


	public List<Integer> getPostIds(String userId) {
		response=given().queryParam("userid", userId).when().get("/posts").then().statusCode(200).extract().response();
		jsonPath = ReusableMethods.rawToJson(response);
		List<Integer> postIds= jsonPath.getList("id");
		
		return postIds ;
	}
	
	public ArrayList getCommentsForPostId(int postid)
	{
		response=given().queryParam("postId", postid).when().get("/comments").then().statusCode(200).extract().response();
		jsonPath = ReusableMethods.rawToJson(response);
		ArrayList<Map<String, ?>> allcommentsforPostId= jsonPath.get("");
		
		return allcommentsforPostId;
	}


	public Boolean checkEmailAddressValidity(String emailId) {
		
		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                 "[a-zA-Z0-9_+&*-]+)*@" + 
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                 "A-Z]{2,7}$"; 
		 Pattern pat = Pattern.compile(emailRegex); 
		 boolean valid=  pat.matcher(emailId).matches();
		return valid;
	}

}
