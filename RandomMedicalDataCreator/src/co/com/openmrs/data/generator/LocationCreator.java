package co.com.openmrs.data.generator;

import org.openmrs.Location;

import co.com.openmrs.data.random.RandomUtilities;

public class LocationCreator {
	
	public LocationCreator() {		
	}
	
	public Location getLocationDummy(){				
		Location location = new Location();
		location.setAddress1(RandomUtilities.createRandomColombianAddress());
		location.setCityVillage(RandomUtilities.getRandomCityVillage());
		location.setStateProvince(RandomUtilities.getRandomStateProvince());
		location.setCountry(RandomUtilities.COUNTRY);
		double lattitude = Math.random() * 100;
		double longitude = Math.random() * 100;
		location.setLatitude(Double.toString(lattitude));
		location.setLongitude(Double.toString(longitude));
		return location;
	}

}
