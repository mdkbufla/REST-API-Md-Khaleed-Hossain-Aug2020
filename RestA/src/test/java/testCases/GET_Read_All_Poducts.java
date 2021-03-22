package testCases;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
//import io.restassured.response.Response;
//import static org.hamcrest.matchers.*;
import org.testng.annotations.Test;
//import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_Read_All_Poducts {
	
	@Test
	public void read_all_Products() {
		
		Response response =
			
		given()
			//.log().all()
			.log().uri()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","applicayion/json; charset=UTF-8")
		.when()
			.get("/read.php")
		.then()
			.extract().response();
		int statusCode = response.getStatusCode();
		System.out.println("Status Code" +response);
		Assert.assertEquals(statusCode, 200);
		
		String  responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}

}
