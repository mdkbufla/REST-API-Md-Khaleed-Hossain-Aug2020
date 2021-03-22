package testCases;
import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
//import io.restassured.response.Response;
//import static org.hamcrest.matchers.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
//import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_Read_A_Product {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void read_A_Product(String QueryIdValue) {
		
		//http://techfios.com/api-prod/api/product/read.php?id=1209
	Response response = given().baseUri("https://techfios.com/api-prod/api/product")
			.header("Content-Type","applicayion/json; charset=UTF-8").queryParam("id", QueryIdValue)
			.when().get("/read_one.php").then()
			.extract().response();
	
		String  responseBody = response.getBody().asString();
		System.out.println("response body "+ responseBody);
		//parsign response body to jason
		//JsonPath js = new JsonPath(responseBody);
		
//		String productId = js.getString("id");
//		String productname = js.getString("name");
//		String productDescription = js.getString("Description");
//		
//		Assert.assertEquals(productId, "1384");
//		Assert.assertEquals(productname, "Hp lapotop");
//		Assert.assertEquals(productDescription, "super fast laptop");
//		System.out.println(productId);
		
		
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

