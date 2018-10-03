package com.scp;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.api.scripting.JSObject;

public class RestAPI {
	@Test
	public void getData() {
		/*Response resp= get("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8888522,151.2888362&radius=500&key=AIzaSyA2AArll65KyaGCf4KtRy02Pw14cgJXYV8");
		int code = resp.getStatusCode();
		System.out.println(code);*/
		RequestSpecification request = RestAssured.given();
		request.header("Contebt-Type","application/json");
		JSONObject json = new JSONObject();
				
		
	}

}
