package restAssyred;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class d2_testCookies {
	//@Test()
	void testCookies()
	{
		given()
		.when()
			.get("https://www.google.com")
		.then()
		.cookie("AEC","AVcja2dnCPbsjgeSq35Y47qCDMUFx4DanY92Ec4P0wAgKuHT-zXzkSzxbA")//the test has to be failed coz everytime cookie value has to be changed
			.log().all();
		}
	//@Test(priority=2)
	void testCookieInfo()
	{
		Response res=given()
		.when()
			.get("https://www.google.com");
		//to get single cookie info
		String cookie_value=res.getCookie("AEC");
		System.out.println("the value of cookie is:"+cookie_value);
	}
	
	@Test(priority=3)
	void getAllcookiesInfo()
	{
		Response res1=given()
		.when()
			.get("https://www.google.com");
		//to get all cookie info
		Map<String,String>cookies_value=res1.getCookies();
		System.out.println(cookies_value.keySet());
		for(String k:cookies_value.keySet())
		{
			String cookie_value=res1.getCookie(k);
			System.out.println(k+"     "+cookie_value) ;
		}
	}

}
