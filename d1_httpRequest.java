package restAssyred;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class d1_httpRequest {
 int id;
	@Test(priority=1)
	void getUser()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();//to print in console window
	}
	
	@Test(priority=2)
	void createuser()
	{
		HashMap hm=new HashMap();
		hm.put("name" ,"morpheus");
		hm.put("job", "leader");
		
		 id= given()
			.contentType("application/json")
			.body(hm)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		//.then()
			//.statusCode(201)
			//.log().all();
		
	}
	
@Test(priority=3,dependsOnMethods= {"createuser"})
	void UpdateUser()
	{
		HashMap hm=new HashMap();
		hm.put("name" ,"john");
		hm.put("job", "teacher");
		
		given()
			.contentType("application/json")
			.body(hm)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority=4)
	void deleteUser()
	{
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204)
			.log().all();
	}

		private RequestSpecification contentType(String string) {
			// TODO Auto-generated method stub
			return null;
		}
}
/*
given()-contains pre requists like 
content type,set cookies,add auth,add param,set headers

when()-request
get,post,put,delete

then()-validations
validate status code,extract response,extract headers cookies..abstract*/