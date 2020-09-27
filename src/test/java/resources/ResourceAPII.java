package resources;

public enum ResourceAPII {
	
   addPlaceAPI("/maps/api/place/add/json"),
   getPlaceAPI("/maps/api/place/get/json"),
   deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	ResourceAPII(String resource)
	{
		this.resource = resource;
	}
	
	
	public String getResource()
	
	{
		return resource;
	}

}
