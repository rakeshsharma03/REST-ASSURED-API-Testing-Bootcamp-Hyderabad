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

public class GetMethod {
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	}
	@Test
	public void getAllEmployees() {
		given()
		.when()
			.get("/employees")
			
			.then()
				.log().all()
				.statusCode(200)
				.body("status", equalTo("success"))
				.body("data",notNullValue());
	}
	}