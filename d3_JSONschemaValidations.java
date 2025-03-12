package restAssyred;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;


//json to jsonschema converter
//https://jsonformatter.org/json-to-jsonschema

public class d3_JSONschemaValidations {
	@Test
	void jsonValidation()
	{
		given()
		.when()
			.get("http://localhost:3000/students")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
			//.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("")); use this for xml schema validations every step remains same
	}

}
