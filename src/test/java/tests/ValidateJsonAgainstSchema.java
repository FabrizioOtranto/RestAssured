package tests;


import static io.restassured.RestAssured.given;


import static io.restassured.RestAssured.*;


import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class ValidateJsonAgainstSchema {
	
	@Test
	public void testvalidateJsonSchema() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2")
		.then()
		.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
		.statusCode(200);
	}

}
