package restAssyred;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
public class d2_parsingXMLresponse {
	@Test
	void testXMLresponse()
	{
		//Approach1
		given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type", "applivation/XML");
	}

}
