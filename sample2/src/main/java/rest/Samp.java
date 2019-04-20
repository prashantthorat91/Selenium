package rest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class Samp {
	@Test
	public void main() {
		Response responce = RestAssured.get("http://localhost:3000/posts/1");
		int code = responce.getStatusCode();
		System.out.println(code);
		Assert.assertEquals(code, 200);
 
	}

}
