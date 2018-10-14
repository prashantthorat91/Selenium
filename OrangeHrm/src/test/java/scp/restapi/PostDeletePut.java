package scp.restapi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDeletePut {
	@Test
	public void test1() {
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "11");
		json.put("title", "Java");
		json.put("author", "nikhil");
		
		
		request.body(json.toJSONString());
		Response res = request.post("http://localhost:3000/posts/");
		//Response res = RestAssured.post("http://localhost:3000/posts");
		int code= res.getStatusCode();
		System.out.println("responce code is ---> "+code);
		Assert.assertEquals(code, 201);
	}

}
