package resources;

public enum Enumresource {

	AddPlaceAPI("/maps/api/place/add/json"),
	DeletePlaceAPI("/maps/api/place/delete/json"),
	getPlaceAPI("/maps/api/place/get/json");
	
	private String abc;

	Enumresource(String API) {
		this.abc=API;
	}
	
	public String getResource()
	{
		return abc;
	}
	
}
