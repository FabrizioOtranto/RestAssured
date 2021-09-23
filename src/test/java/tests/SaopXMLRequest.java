package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class SaopXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException{
		
		baseURI = "http://www.dneonline.com/";
		
		File file = new File("./SoapRequest/Add.xml");
		
		if(file.exists()) {
			System.out.println(" >> File ");
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream,"UTF-8");
		
		given()
		.contentType("text/xml")
		.accept(ContentType.XML)
			.body(requestBody)
		.when()
			.post("calculator.asmx")
		.then()
			.statusCode(200)
			.log().all()
			.and()
			.body("//AddResult.text()", equalTo("8"));
		
	}

	@Test
	public void SoapCountryL() throws IOException{
		
		baseURI = "http://webservices.oorsprong.org/";
		
		File file = new File("./SoapRequest/Country.xml");
		
		if(file.exists()) {
			System.out.println(" >> File ");
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream,"UTF-8");
		
		given()
		.contentType("text/xml")
		.accept(ContentType.XML)
			.body(requestBody)
		.when()
			.post("websamples.countryinfo/CountryInfoService.wso")
		.then()
			.statusCode(200)
			.log().all()
			.and()
			.body("//CapitalCityResult.text()", equalTo("Buenos Aires"));

		
		
		
	}
	
	
}
