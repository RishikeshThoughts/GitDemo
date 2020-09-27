package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlaceAPI;
import pojo.Location;

public class TestDataBuild {
	
	
	public AddPlaceAPI addPlace(String name, String language, String address)
	{
		
		AddPlaceAPI p = new AddPlaceAPI();
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		List<String> type = new ArrayList<String>();
		type.add("shoe");
		type.add("lase");
		
		p.setAccuracy(100);
		p.setAddress(address);
		p.setLanguage(language);
		p.setLocation(l);
		p.setName(name);
		p.setphone_number("(+91) 983 893 3937");
		p.setTypes(type);
		p.setWebsite("https://google.com");
		
		return p;
	}


}
