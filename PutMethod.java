package gitpush;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutMethod {
	@BeforeClass
	public void setup() {
		//Set base url
		RestAssured.baseURI="https://reqbin.com/echo/post/json";
	}
	
	@Test
	public void testPostRequestBDD() {
		System.out.println("---BDD APPROACH---");
		//Create JSON Object
		JSONObject requestBody=new JSONObject();
		requestBody.put("title," ,"Souvik Layek");
		requestBody.put("body","I am a working Professional");
		requestBody.put("userID" , "22053288");
		
		System.out.println("Request Body: "+requestBody.toString());
		
		//BDD Style Test- Given, When, Then
		given()
			.log().all() //Log response details
			.header("Content-Type","application/json")
			.body(requestBody.toString())
		.when()
			.post("/posts")
		.then()
			.log().all()
			.statusCode(201)
			.statusLine(containsString("201"))
			.contentType("application/json")
			.body("title", equalTo("Souvik Layek"))
			.body("body", equalTo("I am a working Professional"))
			.body("userID", equalTo("22053288"))
			.body("id", notNullValue())
			.time(lessThan(100000L));
			System.out.println("BDD Apporach Completed");                                                         
			
	}
}