package co.com.openmrs.data.random;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openmrs.PersonAddress;
import org.openmrs.PersonName;


public class RandomUtilities {
	
	private static String maleNames[] = { "Alberto", "Antonio", "Andrés", "Arturo",
			"Carlos", "Daniel", "Ernesto", "Francisco", "Gustavo",
			"Hernán", "Ignacio", "Júbel", "Konan", "Luis", "Martín",
			"Mario", "Noel", "Santiago" };
	
	private static String femaleNames[] = { "Angela", "Andrea", "Beatriz", "Camila",
			"Diana", "Estefania", "Fernanda", "Gabriela", "Herlency",
			"Isabela", "Juliana", "Katerine", "Luisa", "Manuela", "Nadia",
			"Ortencia", "Patricia", "Rosa", "Sandra", "Tatiana", "Veronica" };

	private static String lastNames[] = { "Restrepo", "Perez", "Galindo", "Londoño",
			"Angel", "Marín", "Escobar", "Herrera", "Duque", "Vasco",
			"Gonzalez", "Sarmiento", "Ochoa", "Yepez", "Moreno", "Naranjo",
			"Fajardo" };
	
	private static String cityVillages[] = { "Medellín", "Bogotá", "Cali", "Pereira",
	"Manizales" };
	
	private static String stateProvinces[] = { "Antioquia", "Cundimarca",
	"Valle del cauca", "Risaralda", "Caldas" };
	
	private static String locations[] = { "CL", "CR", "CIR", "TV" }; //street, avenue, etc. name abreviations 
	
	private static String locationSubdivision[] = { "A", "B", "C", "D", "E", "AA", "S", "" }; //Street number alphabetical subdivision
	
	private static int MAX_YEARS_IN_PAST = 90; //determines how far back in time one can go with the random dates
	
	public static String COUNTRY = "Colombia";
	
	public RandomUtilities() {
	}
	
	public static Date getRandomDate(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Random random = new Random();
		Date randomDate = null;
		
		try {
			Date currentDate = formatter.parse("18/03/2013");
			Date aYearAgo = formatter.parse("18/03/2012");
			long lCurrentDate = currentDate.getTime();
			long lAYearAgo = aYearAgo.getTime();
			long yearDifference = lCurrentDate - lAYearAgo;
			int yearsInPast = random.nextInt(MAX_YEARS_IN_PAST);
			long lResultingDate = lCurrentDate - (yearsInPast * yearDifference);  
			randomDate = new Date(lResultingDate);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return randomDate;					
	}
	
	
	public static String createRandomColombianAddress() {
		String colombianAddress = "";
		

		int MAX_CL_NUMBER = 100; //Max street/avenue, etc. number that can be generated 
		Random random = new Random();

		int randomLocationIndex = random.nextInt(locations.length);
		int randomLocationSubdivisionIndex = random
				.nextInt(locationSubdivision.length);
		colombianAddress += locations[randomLocationIndex];
		colombianAddress += " " + random.nextInt(MAX_CL_NUMBER)
				+ locationSubdivision[randomLocationSubdivisionIndex] + " # "
				+ random.nextInt(MAX_CL_NUMBER) + "-"
				+ random.nextInt(MAX_CL_NUMBER);
		return colombianAddress;
	}

	public static String createRandomColombianName(boolean male) {
		String colombianName = "";
		Random random = new Random();

		int randomMaleNameIndex = random.nextInt(maleNames.length);
		int randomFemaleIndex = random.nextInt(femaleNames.length);
		int randomLastNameIndex = random.nextInt(lastNames.length);

		if (male) {
			colombianName += maleNames[randomMaleNameIndex] + " ";
			randomMaleNameIndex = random.nextInt(maleNames.length);
			colombianName += maleNames[randomMaleNameIndex] + " ";
		} else {
			colombianName += femaleNames[randomFemaleIndex] + " ";
			randomFemaleIndex = random.nextInt(femaleNames.length);
			colombianName += femaleNames[randomFemaleIndex] + " ";
		}

		colombianName += lastNames[randomLastNameIndex] + " ";
		randomLastNameIndex = random.nextInt(lastNames.length);
		colombianName += lastNames[randomLastNameIndex];

		return colombianName;
	}
	
	public static PersonName randomColombianPersonName(boolean male){
		PersonName personName = new PersonName();
		Random random = new Random();


		int randomMaleNameIndex = random.nextInt(maleNames.length);
		int randomFemaleIndex = random.nextInt(femaleNames.length);
		int randomLastNameIndex = random.nextInt(lastNames.length);
							
		if (male) {
			personName.setGivenName(maleNames[randomMaleNameIndex]);
			randomMaleNameIndex = random.nextInt(maleNames.length);
			personName.setMiddleName(maleNames[randomMaleNameIndex]);
		} else {
			personName.setGivenName(femaleNames[randomFemaleIndex]);
			randomFemaleIndex = random.nextInt(femaleNames.length);
			personName.setMiddleName(femaleNames[randomFemaleIndex]);
		}
		personName.setFamilyName(lastNames[randomLastNameIndex]);		
		randomLastNameIndex = random.nextInt(lastNames.length);
		personName.setFamilyName2(lastNames[randomLastNameIndex]);
		personName.setPreferred(true);
		
		return personName;		
	}
	
	public static PersonAddress createRandomAddress(boolean preferred) {

		Random random = new Random();
		int randomCityVillagesIndex = random.nextInt(cityVillages.length);
		String lattitude = (Math.random() * 100) + "";
		String longitude = (Math.random() * 100) + "";
		final String COUNTRY = "Colombia";

		PersonAddress personAddress = new PersonAddress(); // Should work with
															// the interface but
															// it doesn't extend
															// baseopenmrsdata
		personAddress.setPreferred(preferred);
		personAddress.setAddress1(RandomUtilities.createRandomColombianAddress());
		personAddress.setCountry(COUNTRY);
		personAddress.setCityVillage(cityVillages[randomCityVillagesIndex]);
		personAddress.setStateProvince(stateProvinces[randomCityVillagesIndex]);
		personAddress.setLatitude(lattitude);
		personAddress.setLongitude(longitude);
		personAddress.setStartDate(new Date());
		personAddress.setEndDate(new Date());

		return personAddress;
	}
	
	public static String getRandomCityVillage(){
		String randomCityVillage = "";
		Random random = new Random();
		int randomCityVillagesIndex = random.nextInt(cityVillages.length);
		randomCityVillage = cityVillages[randomCityVillagesIndex];
		
		return randomCityVillage;
	}
	
	public static String getRandomStateProvince(){
		String randomStateProvince = "";
		Random random = new Random();
		int randomStateProvinceIndex = random.nextInt(stateProvinces.length);
		randomStateProvince = stateProvinces[randomStateProvinceIndex];		
		return randomStateProvince;
	}
	
	
	public static void main(String[] args) {
		RandomUtilities randomUtilities = new RandomUtilities();
		
		for(int i = 0; i < 100; i++){
			System.out.println(randomUtilities.createRandomColombianName(i%2==0));
		}
		
	}

}
