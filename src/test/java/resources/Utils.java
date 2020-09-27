package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification req;
	ResponseSpecification res;
	
	
	public String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Rishikesh\\eclipse-workspace\\API_Automation\\apiframework\\src\\test\\java\\resources\\global.properties");
	    prop.load(fis);
	    
	    return prop.getProperty(key);	
	}
	
	
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("Output.txt"));
		
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return req;
		}
		return req;
		
	}

	public ResponseSpecification responseSpecification()
	{
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		
		return res;
		
	}
	
	
	public String getJsonPath(Response resp, String key)
	{
		
        String s = resp.asString();
	    JsonPath jp = new JsonPath(s);
	    return jp.get(key).toString();
		
	}
	
	public String getDeleteBody(String place_id)
	{
		
		return "{\r\n" + 
				"    \"place_id\":\""+place_id+"\"  \r\n" + 
				"}";

	}
	
}
