package StepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletPlace")
	public void beforeDeletePlaceAPI() throws IOException
	{
		placeValidations pv = new placeValidations();
		if(placeValidations.place_ID == null)
		{
			pv.add_place_payload_with("Yatin","State BAnk Nagar","Marathi");
			pv.user_calls_with_http_request("AddPlaceAPI", "POST");
			pv.verify_place_id_created_maps_to_using("Yatin", "getPlaceAPI");			
		}

		
	}

}
