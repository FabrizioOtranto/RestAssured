package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDelete {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPut() {
		
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
			.put("/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPutProject() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "bathroom");
		request.put("category", "bathroom");
		
		
		baseURI = "https://renderingdos.herokuapp.com/api";
		given()
			.header("Authorization" ,"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE2MjY4MTM0MTl9.4MbLTmGuX-yzbwk3qd8uRStVO3Rckv4IslT5G7QHDJU")
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/project/61099181e86fab00158e25d0")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPatch() {
		
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
			.patch("/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in/api";
		given()
		.when()
			.delete("/users/2")
		.then()
			.statusCode(204)
			.log().all();
	}


}
