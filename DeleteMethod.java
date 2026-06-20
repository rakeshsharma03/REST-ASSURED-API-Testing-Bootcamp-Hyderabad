package gitpush;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteMethod {
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	}
	@Test
	public void getAllEmployees() {
		given()
		.when()
			.delete("/delete/2")
			
			.then()
				.log().all()
				.statusCode(200)
				.body("status", equalTo("success"));
	}
}