package gitpush;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PatchMethod {
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
	}
	@Test
	public void updateEmployees() {
		JSONObject request= new JSONObject();
		request.put("title", "Update Title");

		given()
			.header("Content-Type","application/json")
			.body(request.toString())
		.when()
			.put("/posts/1")
			
			.then()
				.log().all()
				.statusCode(200)
				.body("title", equalTo("Update Title"));
	}
	
}