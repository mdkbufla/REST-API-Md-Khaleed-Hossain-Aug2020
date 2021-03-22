package testCases;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POST_Create_A_Product {
	
	
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void create_A_Product() {
		
		//http://techfios.com/api-prod/api/product/read.php/create.php
	
		HashMap payload = new HashMap();
		payload.put("name", "Khaleed Desktop Pro-9");
		payload.put("description", "Super fast laptop");
		payload.put("price", "1199" );
		payload.put("category_name", "Electronics");
		payload.put("category_id", "2");
		
		Response response =
		given()
			.baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","application/json; charset=UTF-8")
			.body(payload)
		.when()
			.post("/create.php")
		.then()
			.extract().response();
				
		String  responseBody = response.getBody().asString();
		System.out.println("response body: "+ responseBody);
		
		JsonPath js = new JsonPath(responseBody);
		String message = js.getString("message");
		Assert.assertEquals(message, "Product was created.");
		
//		//parsign response body to jason
	//	JsonPath js = new JsonPath(responseBody);
	//	Assert.assertEquals("message", "Product was created");
		//String message = js.getString(message);
//		String productId = js.getString("id");
//		String productname = js.getString("name");
//		String productDescription = js.getString("Description");
//		
//		Assert.assertEquals(productId, "1209");
//		Assert.assertEquals(productname, "Hp lapotop");
//		Assert.assertEquals(productDescription, "super fast laptop");
//		System.out.println(productId);
//		
		
		//int statusCode = response.getStatusCode();
		//System.out.println("Status Code" + statusCode);
		//String responseBody = response.getBody().prettyPrint();
		//System.out.println("response body "+ responseBody);
		//Assert.assertEquals(statusCode, 200);
		//softAssert.assertEquals(statusCode, 201, statusCode +"not match" + "201");
		//softAssert.assertEquals(statusCode, 201, "not match");
	//	String responseBody = response.getBody().prettyPrint();
		//response.getBody().prettyPrint();
		//String  responseBody = response.getBody().asString();
	//	System.out.println("response body "+ responseBody);
		
	//	long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
	//	System.out.println("Response Time" + responseTime);
	//	if (responseTime<=1000) {
	//		System.out.println("in range");
	//	}else {
	//		System.out.println("not aceptable");
		}
	}

