package practice;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReqresAssertions {

    // Base URL for API
    private static final String BASE_URL = "https://reqres.in/api";

    // 1️⃣ GET Request - Fetch User List
    @Test(priority = 1)
    public void testGetUserList() {
        Response response = RestAssured.get(BASE_URL + "/users?page=2");

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code is not 200");
        int totalUsers = response.jsonPath().getInt("total");
        Assert.assertEquals(totalUsers, 12, "Total users mismatch");

        System.out.println("GET User List - Response: " + response.getBody().asString());
    }

    // 2️⃣ POST Request - Create a New User
    @Test(priority = 2)
    public void testCreateUser() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Alice");
        requestBody.put("job", "QA Engineer");

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(BASE_URL + "/users");

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 201, "Status Code is not 201");
        String id = response.jsonPath().getString("id");
        Assert.assertNotNull(id, "ID was not generated");

        System.out.println("POST Create User - Response: " + response.getBody().asString());
    }

    // 3️⃣ DELETE Request - Delete a User
    @Test(priority = 3)
    public void testDeleteUser() {
        Response response = RestAssured.delete(BASE_URL + "/users/2");

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 204, "Status Code is not 204");
        Assert.assertEquals(response.getBody().asString(), "", "Response body is not empty");

        System.out.println("DELETE User - User deleted successfully");
    }
}

