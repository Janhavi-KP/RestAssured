package restAssyred;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


@Test
public class d1_postRequestBody {
	
//using Hashmap
	//@Test(priority=1)
	 void testPostUsingHasmap()
	 {
		 HashMap data=new HashMap();
		 data.put("id","4");
		 data.put("name", "John Doe");
		 data.put("phone_number", "9876543210");
		 data.put("branch","Computer Science");
		 
		 String courseArr[]= {"python","java"};
		 data.put("courses",courseArr);
		 
		 given()
		 .contentType("application/json")
		 .body(data)
		 
		 .when()
		 	.post("http://localhost:3000/students")
		 	
		 .then()
		 	.statusCode(201)
		 	.body("name", equalTo("John Doe"))
		 	.body("phone_number", equalTo("9876543210"))
		 	.log().all();
		 			
	 }
		 	
	 // @Test(priority=2)
	 void testDeelete()
	 {
		 given()
		 .when()
		 .delete("http://localhost:3000/students/4")
		 
		 .then()
		 	.statusCode(200);
	 }
//using Json Object
	 		//@Test
		 	void createuser1()
		{
		 	JSONObject data=new JSONObject();
		 	 data.put("id","4");
			 data.put("name", "John Doe");
			 data.put("phone_number", "9876543210");
			 data.put("branch","Computer Science");
			 
			 String courseArr[]= {"python","java"};
			 data.put("courses",courseArr);
			 
			 given()
			 .contentType("application/json")
			 .body(data.toString())
			 
			 .when()
			 	.post("http://localhost:3000/students")
			 	
			 .then()
			 	.statusCode(201)
			 	.body("name", equalTo("John Doe"))
			 	.body("phone_number", equalTo("9876543210"))
			 	.log().all();	 		 
		}
//using POJO class
	@Test
	 void createuser()
	 {
		 POJO_CLASS data=new POJO_CLASS();
		 data.setId(5);
		 data.setName("Kapil");
		 data.setPhone_number("1234567890");
		 data.setBranch("CSE");
		 given()
		 .contentType("application/json")
		 .body(data)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.log().all();
	 }
	 void jsonFile() throws FileNotFoundException 
	 {
		 File obj=new File("C:\\Users\\91910\\OneDrive\\Desktop\\rest Assured\\RestAssured\\src\\test\\java\\restAssyred\\body.json");
		 FileReader obj1=new FileReader(obj);
		 JSONTokener TC=new JSONTokener(obj1);
		 JSONObject data=new JSONObject(TC);
		 
		 given()
		 .contentType("application/json")
		 .body(data.toString())
		 
		 .when()
		 	.post("http://localhost:3000/students")
		 	
		 .then()
		 	.statusCode(201)
		 	.body("name", equalTo("John Doe"))
		 	.body("phone_number", equalTo("9876543210"))
		 	.log().all();	
		 
		 
	 }
}
/*
Different ways to create a post request body
1. using hasmap
2. using org.json
3. pojo class
4.json file data
*/
	 
	 

