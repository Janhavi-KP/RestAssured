package practice;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class create {
	@Test
	void create_test(ITestContext context)
	{
			JSONObject data=new JSONObject();
			data.put("id", "4");
			data.put("name", "Janu");
			data.put("phone_number", "9876543210");
			data.put("branch", "ECE");
			
			int id =given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getInt("id");
			System.out.println("Generated id is : "+id); 
			context.getSuite().setAttribute("user_id", id);//creating some environment variable called user_id and storing id to it and it can use globally
			
	}


}
