package RestAPITest.JsonPlaceHolderApiTest;


import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class ReusableMethods {
	

	public static JsonPath rawToJson(Response res)
	{
		String response= res.asString();
		JsonPath js = new JsonPath(response);
		return js ;
		
	}

	public static XmlPath  rawToXml(Response res)
	{
		String response= res.asString();
		XmlPath xml = new XmlPath(response);
		return xml ;
		
	}
}
