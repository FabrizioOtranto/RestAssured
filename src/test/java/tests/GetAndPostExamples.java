package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;


public class GetAndPostExamples {
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[0].first_name", equalTo("Michael"))
		.body("data.first_name", hasItems("George","Michael"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPost() {

		JSONObject request = new JSONObject();
		
		request.put("name", "Fabrizio");
		request.put("job", "Tester");
		
		System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	
	@Test
	public void testmessages() {
		baseURI = "https://renderingdos.herokuapp.com/api";
		given()
		.header("Authorization" ,"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MjY4MTM0MTl9.4MbLTmGuX-yzbwk3qd8uRStVO3Rckv4IslT5G7QHDJU")
		.get("/formcontacts")
		.then()
		.statusCode(200)
		.log().all();
	}
	

}


