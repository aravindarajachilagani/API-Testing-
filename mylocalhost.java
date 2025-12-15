package newRestAssured;



import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class mylocalhost {

	//GET Request 
//	@Test
	public void Test_get()
	{
		baseURI = "http://localhost:3000/";
		
		given()
		.param("name", "Automation")
		.get("/subjects")
		
		.then()
		.statusCode(200)
		.log().all();
				
	}
	
	// POST Request

//	@Test
	public void Test_Post()
	{
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "jerry");
		request.put("lastName", "Tommy");
		request.put("SubjectID", 1);
		
		baseURI = "http://localhost:3000/";
		
		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json")
		.body(request.toJSONString()).
		
		when()
		.post("/users")
		
		.then()
		.statusCode(201)
		.log().all();
	}
	
	// PATCH Request
	
//	@Test
	public void Test_patch()
	{
		
		JSONObject request = new JSONObject();
		
		//request.put("firstName", "jerry");
		request.put("lastName", "lovedaa");
	//	request.put("SubjectID", 1);
		
		baseURI = "http://localhost:3000/";
		
		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json")
		.body(request.toJSONString()).
		
		when()
		.patch("/users/5")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	// PUT Request
	
//	@Test
	public void Test_put()
	{
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Ironman");
		request.put("lastName", "wonderwomen");
		request.put("SubjectID", 1);
		
		baseURI = "http://localhost:3000/";
		
		given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.header("Content-Type", "application/json")
		.body(request.toJSONString()).
		
		when()
		.put("/users/5")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test
	
	public void test_delete()
	{
		baseURI = "http://localhost:3000/";
		
		when()
		.delete("/users/5")
		
		.then()
		.statusCode(200);
		
	}
	
	
	
	
}
