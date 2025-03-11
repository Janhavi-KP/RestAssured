package restAssyred;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class d2_pathQueryParam {
	@Test
	void pathandQueryParam()
	{
		//https://regres.in/api/users?page=2&id=5
		given()
			.pathParam("path", "users")//path parameter
			.queryParam("page", 2)//query param1
			.queryParam("id", 5)//query param2
		.when()
			.get("https://regres.in/api/{path}")
			
		.then()
			.statusCode(200)
			.log().all();
	}

}
