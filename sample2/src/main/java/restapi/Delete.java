package restapi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Delete {
	@Test
	public void deleteData() {
		given().queryParam("key","qaclick123")
		.body("{\r\n" + 
				"    \"place_id\":\"3f881c02e49d1af46aa1684886439de2\" r\n" + 
				"}\r\n" + 
				"")
		.when()
		.post("http://216.10.245.166/maps/api/place/delete/json?key=qaclick123")
		.then().assertThat().statusCode(200);
		
	}

}
