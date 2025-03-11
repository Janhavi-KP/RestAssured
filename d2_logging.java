package restAssyred;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Headers;

public class d2_logging {
	@Test()
	void testLogs()
	{
		given()
		.when()
			.get("https://regres.in/api/users?page=2")
		
		.then()
			//.log().body(); it prints only body
			//.log().cookies();it prints only cookies from response
			//.log().headers();prints only Headers from response
			.log().all();//print everything from response
			}

}
