import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAPI {
	
	@Test
	void getclimatdetails() {
		//Base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object
		RequestSpecification req=RestAssured.given();
		
		
		//Response object
		Response res=req.request(Method.GET,"/users?page=2");
		
		//Reponse result
		String resbody=res.getBody().asString();
		System.out.println("Responce body is: "+resbody);
		
		//request code status
		int status=res.getStatusCode();
		System.out.println("Status result is :" +status);
	    Assert.assertEquals(status,200);
	    
	  
		
	}

}
