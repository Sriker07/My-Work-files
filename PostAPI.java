import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAPI {
	@Test
	void getclimatdetails() {
		//Base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object
		RequestSpecification req=RestAssured.given();
		
		
		//Response object
	      JSONObject reqbody= new JSONObject();
	      reqbody.put("id","7");
	      reqbody.put("first_name","Janu");
	      reqbody.put("last_name","World");
	      reqbody.put("email","janu.wolrd@reqres.in");
	      
	      req.header("Content-Type","application/json");
		  req.body(reqbody.toJSONString());
		  
		//Response object
			Response res=req.request(Method.POST,"/users");
		  
		  
		//Reponse result
		String resbody=res.getBody().asString();
		System.out.println("Responce body is: "+resbody);
		
		//request code status
		int status=res.getStatusCode();
		System.out.println("Status result is :" +status);
	    Assert.assertEquals(status,201);
	    
	    String result=res.jsonPath().get("createdAt");
	    System.out.println(result);
	    
	  
		
	}

}

