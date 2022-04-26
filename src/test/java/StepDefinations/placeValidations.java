package StepDefinations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Enumresource;
import resources.TestDataBuild;
import resources.Utils;
import POJO.AddPlace;
import POJO.AddPlaceLocation;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class placeValidations{
	
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response1;
	TestDataBuild tdb = new TestDataBuild();
	Utils u = new Utils();
	static String place_ID;
	JsonPath js;
	
	@Given("Add place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String address, String language) throws IOException {
		res= given().spec(u.requestspecification())
				.body(tdb.addPlacePayload(name,address,language));
	}
	
	@When("user calls {string} with {string} Http request")
	public void user_calls_with_http_request(String API, String httpmethod){
		Enumresource es= Enumresource.valueOf(API);
		System.out.println(es.getResource());
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(httpmethod.equalsIgnoreCase("Post"))
		{
			response1 =res.when().post(es.getResource());
		}
		else if(httpmethod.equalsIgnoreCase("Get"))
		{
			response1 =res.when().get(es.getResource());
		}
		 
		
	}
	
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		response1.then().spec(resspec).extract().response();
		assertEquals(response1.getStatusCode(),200);	
	}
	
	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String key, String value) {
	    String resp=response1.asString();
	    js = new JsonPath(resp);
	    
	    System.out.println("Check key : "+js.getString("status"));
	   // assertEquals(js.get(key).toString(),value);
	        
	}
	
	@Then("verify place_ID created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String API) throws IOException {
		place_ID = js.get("place_id");
		res= given().spec(u.requestspecification()).queryParam("place_id", place_ID);
		user_calls_with_http_request(API,"GET");
		String resp=response1.asString();
		JsonPath js1 = new JsonPath(resp);
		String actualname1 = js1.get("name");
		System.out.println(actualname1);
		assertEquals(actualname1,expectedname);
	}

	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
		res=given().spec(u.requestspecification())
		.body(tdb.deletePlacePayload(place_ID));
		
	}

}
