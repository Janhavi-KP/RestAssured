package restAssyred;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;


import io.restassured.http.Header;
import io.restassured.http.Headers;

import io.restassured.response.Response;

public class d2_headersTest {
	@Test()
		void testHeaders()
		{
			given()
			.when()
				.get("https://www.google.com")
			.then()
				.header("Content-Type","text/html; charset=ISO-8859-1")
				.and()
				.header("content-Encoding", "gzip")
				.and()//if we have multiple validations then we will separate by and method
				.header("Server", "gws");
			}
	@Test(priority=2)
	void getHeaders()
	{
		Response res=given()
		.when()
			.get("https://www.google.com");
			//single header info
			
			String headervalue=res.getHeader("Content-Type");
			System.out.println("the content type header is"+headervalue);
			
			//get all header info
			Headers myheader=res.getHeaders();
			for(Header hd:myheader)
			{
				System.out.println(hd.getName()+"="+hd.getValue());
			}
		}

}
