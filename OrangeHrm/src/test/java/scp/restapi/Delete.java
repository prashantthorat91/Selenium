package scp.restapi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete {
	@Test(enabled = false)
	public void delete() {
		RequestSpecification request = RestAssured.given();
		
		Response res = request.delete("http://localhost:3000/posts/2");
		int code= res.getStatusCode();
		System.out.println("responce code is ---> "+code);
		Assert.assertEquals(code, 200);
	}
	
	@Test
	public void put() {
RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "11");
		json.put("title", "HTML");
		json.put("author", "nikhil");
		
		
		request.body(json.toJSONString());
		Response res = request.put("http://localhost:3000/posts/11");
		//Response res = RestAssured.post("http://localhost:3000/posts");
		int code= res.getStatusCode();
		System.out.println("responce code is ---> "+code);
		Assert.assertEquals(code, 200);
	}
	
	

}
