package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.io.Files;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ResourceAPII;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinitions extends Utils{
	
	RequestSpecification req;
	ResponseSpecification res;
	RequestSpecification response;
	Response resp;
	static String place_id;
	ResourceAPII resourceAPI;
	
	TestDataBuild testdata = new TestDataBuild();
	
	@Given("Add Place API with {string}  {string}  {string}")
	public void add_place_api_with(String name, String language, String address) throws IOException {
		
		response = given().spec(requestSpecification()).body(testdata.addPlace(name,language,address));	
	    
	}


	@When("I invoke the {string} with {string} HTTP request")
	public void i_invoke_the_api(String resource, String method)
	{
		resourceAPI = ResourceAPII.valueOf(resource);
		
		if(method.equalsIgnoreCase("POST"))
		resp = response.when().post(resourceAPI.getResource());
		
		else if(method.equalsIgnoreCase("GET"))
		resp = response.when().get(resourceAPI.getResource());
		
		else
			resp = response.when().put(resourceAPI.getResource());
		       
	}
	
	
	@Then("status code response should be {int}")
	public void status_code_response_should_be(Integer int1)
	{
	    System.out.println("Status Code for  "+resourceAPI.getResource()+resp.getStatusCode());
		
		assertEquals(resp.getStatusCode(),200);
	    
	    }
	
	
	@Then("{string} in response body should be {string}")
	public void in_response_body_should_be(String key, String string2) throws IOException 
	{
		System.out.println("Response for  "+resourceAPI.getResource()+" "+resp.asString());
		String value = getJsonPath(resp,key);
		assertEquals(value,string2);
	  
	   //byte[] responseAsStringByte = resp.asString().getBytes();
	   //File targetFileForString = new File("src/test/java/features/targetFileForString.txt");
	   
	  // Files.write(responseAsStringByte, targetFileForString);
		
	}
	
	@Then("verify {string} maps to {string} using {string}")
	public void verify_name_maps_to_using(String key,String expected, String resource) throws IOException {
	    
		
	
		place_id = getJsonPath(resp,"place_id");
		
		System.out.println("Place ID is "+place_id);
		
		req = given().spec(requestSpecification()).queryParam("place_id",place_id);
		
		resp = req.when().get();
		
		
		//assertEquals(getJsonPath(resp,key),expected);
		
	}
	
	
	@Then("I print the response")
	public void i_print_the_response() 
	{
		System.out.println("Response is " +resp.asString());
		
	}
	
	@Given("Delete API details")
	public void delete_api_details() throws IOException {
	    
		response = given().spec(requestSpecification()).body(getDeleteBody(place_id));
		
	}
		


}
