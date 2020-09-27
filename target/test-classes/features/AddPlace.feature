Feature: To validate the Add Place API

@demo
Scenario Outline: Verify the status code for Add API

Given Add Place API with "<name>"  "<language>"  "<address>"  
When I invoke the "addPlaceAPI" with "POST" HTTP request
Then status code response should be 200
And "status" in response body should be "OK" 
And verify "name" maps to "<name>" using "getPlaceAPI"

Examples: 
	|name		|language	|address				|
	|Rishi	|Kannada	|Jayanagar,Kolar|
#	|Vanaja	|English	|Nayakarahalli	|
#	|Vijaya	|Kannada	|Thamballi			|

@demo
Scenario: Check the response
Given Add Place API with "<name>"  "<language>"  "<address>"  
When I invoke the "addPlaceAPI" with "POST" HTTP request
Then status code response should be 200
And I print the response

@demo
Scenario: Delete the place added
Given Delete API details
When I invoke the "deletePlaceAPI" with "POST" HTTP request
Then status code response should be 200
And "status" in response body should be "OK"





