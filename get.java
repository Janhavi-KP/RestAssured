package practice;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class get {
	@Test
	void Test_get(ITestContext context)
	{
		int id=(int)context.getSuite().getAttribute("user_id");
		given()
		.pathParam("id", id)
		
		.when()
			.get("http://localhost:3000/students?{id}")  
		.then()
			.statusCode(200)
			.log().all();
	}

}
