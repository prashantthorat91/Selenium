package restapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Sample {
	@Test
	public void getData() {
		RestAssured.baseURI="http://localhost:3000";
		given().
				param("key","3")
				.when()
				.get("/posts/3");
				//.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and();
				/*.body("result[0].name",equalTo("Sydney"));*/
				
		
	}
}
