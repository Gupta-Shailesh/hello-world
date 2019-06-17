package RestAPITest.JsonPlaceHolderApiTest;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;

	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;

	public class JsonPlaceHolderAPITest {
		JsonPlaceHolderApiMethods jpha = new JsonPlaceHolderApiMethods() ; 

		
		@Test
		@Parameters({"userName"})
		public void testJsonPlaceHolderApi(String userName)
		{
			RestAssured.baseURI=(String)"https://jsonplaceholder.typicode.com";
			ArrayList <Map<String,?>>allCommentsforpostId ;

		String  userId= jpha.getUserid(userName);
		List<Integer> postIds= jpha.getPostIds(userId);
		
		
		for(int postId: postIds)
		{
			allCommentsforpostId = jpha.getCommentsForPostId(postId); 
			
			for(Map<String,?>commentBlock :allCommentsforpostId)
			{
				String commentBody = (String) commentBlock.get("body");
				String emailId= (String) commentBlock.get("email");
				int commentid = (Integer) commentBlock.get("id");
				System.out.println("*****The Email ID and Comment for CommentID: " + commentid+ "****** is: \n"+ "Emaild :"+emailId +"\n"+ "Comment :" +commentBody);
				System.out.println("******check for emailAdress Validity started*****");
				 Boolean isEmailAddressVaild= jpha.checkEmailAddressValidity(emailId);
				 if(isEmailAddressVaild)
				 {
					 System.out.println(" ***** The "+emailId+" :********** is a valid email ID**************");
				 }
				 else {
					 System.out.println("The "+emailId+" is a Invalid email ID");
				 }
				
				
			}
			
		}

	}
	}
