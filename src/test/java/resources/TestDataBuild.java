package resources;

import java.util.ArrayList;

import POJO.AddPlace;
import POJO.AddPlaceLocation;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String address, String language)
	{
		AddPlace ap = new AddPlace();
		ap.setAccuracy(100);
		ap.setAddress(address);
		ap.setLanguage(language);
		ap.setName(name);
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setWebsite("https://rahulshettyacademy.com");
		
		AddPlaceLocation l = new AddPlaceLocation();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		
		ArrayList<String> t = new ArrayList<String>();
		t.add("shoe park");
		t.add("shop");
		ap.setTypes(t);
		return ap;
	}
	
	public String deletePlacePayload(String PlaceID)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+PlaceID+"\"\r\n"
				+ "}";
	}

}
