package scp.restapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Basics2 {
	@Test
	public void postData()
	{
		RestAssured.baseURI="http://216.10.245.166";
	}
}
