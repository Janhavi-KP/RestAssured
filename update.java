package practice;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class update {
	@Test
	void test_update(ITestContext context) {
	JSONObject data=new JSONObject();
	data.put("id", "4");
	data.put("name", "Navi");
	data.put("phone_number", "9876543210");
	data.put("branch", "ECE");
	int id= (int) context.getSuite().getAttribute("user_id");
		given()
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id", id)
		.when()
			.put("http://localhost:3000/students/{id}")
		.then()
			.statusCode(200)
			.log().all();
				
	} 

}
