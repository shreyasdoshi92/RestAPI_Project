Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if place is being added using AddPlaceAPI
Given Add place Payload with "<name>" "<address>" "<language>"
When user calls "AddPlaceAPI" with "POST" Http request
Then the API call got success with status code 200
And "Status" in the response body is "OK"
And "Scope" in the response body is "APP"
And verify place_ID created maps to "<name>" using "getPlaceAPI"

Examples:
|	name		|	address					|	language	|
|Mannat House	|29, side layout, cohen 09	|  French-IN	|
|Shreyas House	|29, side layout, cohen 09	|  Gujrati	|


@DeletPlace
Scenario: Verify if place is being deleted using deletePlaceAPI
Given Delete place payload
When user calls "DeletePlaceAPI" with "POST" Http request
Then the API call got success with status code 200
And "Status" in the response body is "OK"

