package test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

public class RestAPIExamples {

    public static String baseUri = "https://reqres.in/";
    public static String getEndPoint = "/api/users?page=2";
    public static String postEndPoint = "/api/users";
    public static String putEndPoint = "/api/users/2";
    public static String deleteEndPoint = "/api/users/2";
    RequestPayload request = new RequestPayload();
    ResponsePayload response = new ResponsePayload();

    JsonPath jsonPath;
    public static JSONObject json1, json2 = new JSONObject();

    public void postJSON(){
        request.setName("Gaurav");
        request.setJob("Test Engineer");
        request.toString();
        response.getName();
        response.getJob();
        response.getId();
        response.getCreatedAt();
        response.toString();
    }

    public void putJSON(){
        json1.put("name","Morpheus");
        json1.put("job","Zion Resident");
    }

    @Test(priority = 0)
    public void getRequest()
    {
        Response response1 = RestAssured.given().baseUri(baseUri).basePath(getEndPoint).get();
        System.out.println("Get() Method Response is- "+response1.getStatusCode());
    }

    @Test(priority = 1)
    public void postRequest()
    {
       Response response2 = RestAssured.given().contentType("application/json").body(request).baseUri(baseUri).basePath(postEndPoint).post().then().extract().response();
       System.out.println("Post() Method Response is- "+response2.getStatusCode());
       System.out.println("Get() Method ResponseBody is- "+response2.getBody().prettyPrint());
       Assert.assertEquals(201,201);
       System.out.println(RestAssured.given().baseUri(baseUri).basePath(getEndPoint).get().getBody().prettyPrint());
       jsonPath = response2.jsonPath();
       String id = jsonPath.get("id").toString();
       System.out.println("Generated ID is-"+id);
       String users = "/api/users/";
       String printMe = users + id;
       System.out.println(RestAssured.given().baseUri(baseUri).basePath(printMe).get().getBody().prettyPrint());
    }

    @Test(priority = 2)
    public void putRequest()
    {
        Response response3 = RestAssured.given().contentType("application/json").body(json2).baseUri(baseUri).basePath(putEndPoint).given().put();
        System.out.println("Put() Method ResponseBody is- "+response3.getBody().prettyPrint());
        System.out.println("Put() Method Response is- "+response3.getStatusCode());
        Assert.assertEquals(200,200);
    }

    @Test(priority = 3)
    public void deleteRequest(){
        Response response4 = RestAssured.given().baseUri(baseUri).basePath(deleteEndPoint).given().delete();
        System.out.println("Delete() Method ResponseBody is- "+response4.getBody().prettyPrint());
        System.out.println("Delete() Method Response is- "+response4.getStatusCode());
        Assert.assertEquals(204,204);
    }


}
