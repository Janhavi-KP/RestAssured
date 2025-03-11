package restAssyred;
import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class d2_parsingJSONresponseData {
	//@Test
	//void parsingdata()
	//{
		//Approach1
		/*
		given()
		.when()
			.get("http://localhost:3000/students")
		.then()
			.statusCode(200)
			.header("Content-Type","application/json")
			.body("[3].branch",equalTo("CSE"));//ignore the x from json path finder
		*/
	
		//Approach2
		//we will capture the entire response into a variable
	/*	Response res= given()
			.contentType(ContentType.JSON)
			.when()
				.get("http://localhost:3000/students");
			Assert.assertEquals(res.getStatusCode(),200);
			Assert.assertEquals(res.header("Content-Type"),"application/json");
			String branchName=res.jsonPath().get("[3].branch").toString();
			System.out.println("the branch name is"+branchName);
			Assert.assertEquals(branchName,"CSE");
	*/
//	}
	
	@Test(priority=2)
	void testJSONresponseBodyData()
	{
		Response res=
				given()
				.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/students");
		//print all the name in the json and check particular name is present or not
		 //JSON OBJECT CLASS
		JSONArray jo=new JSONArray(res.asString());//converting response to json array type
		for(int i=0;i<jo.length();i++)
		{
			JSONObject obj =jo.getJSONObject(i);
			String Name=obj.get("name").toString();
			System.out.println(Name);
		}
		boolean status=false;
		for(int i=0;i<jo.length();i++)
		{
			String name=jo.getJSONObject(i).get("name").toString();
			if(name.equals("John Doe"))
				{
					status=true;
					break;
				}
		}
		Assert.assertEquals(status,true);
	}

}
