package co.com.openmrs.data.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import org.openmrs.Person;
import org.openmrs.PersonAddress;
import org.openmrs.PersonName;
import org.openmrs.User;

import co.com.openmrs.data.mock.BaseOpenMRSMocker;
import co.com.openmrs.data.random.RandomUtilities;


public class PersonCreator {

	private BaseOpenMRSMocker baseOpenMRSMocker;	

	public PersonCreator(User creator) {
		baseOpenMRSMocker = new BaseOpenMRSMocker(creator);		
	}

	public ArrayList<Person> getRandomPeopleCollection(int peopleCount) {
		ArrayList<Person> people = new ArrayList<Person>();
		for (int i = 0; i < peopleCount; i++) {
			Person person = getDummyPerson(true, true);
			people.add(person);
		}
		return people;
	}
	

	public Person getDummyPerson(boolean male, boolean isPatient) {
		Person dummyPerson = new Person();
		
		dummyPerson = (Person) baseOpenMRSMocker.setBaseOpenmrsData(dummyPerson);
		TreeSet<PersonAddress> set = new TreeSet<PersonAddress>();
		PersonAddress personAddress = RandomUtilities.createRandomAddress(true);
		personAddress = (PersonAddress) baseOpenMRSMocker.setBaseOpenmrsData(personAddress);
		set.add(personAddress);
		dummyPerson.setAddresses(set);
		TreeSet<PersonName> namesSet = new TreeSet<PersonName>();
		PersonName personName = RandomUtilities.randomColombianPersonName(male);
		personName = (PersonName) baseOpenMRSMocker.setBaseOpenmrsData(personName);
		namesSet.add(personName);
		dummyPerson.setNames(namesSet);
		dummyPerson.setGender(male?"Masculino":"Femenino");
		dummyPerson.setBirthdate(RandomUtilities.getRandomDate());
		dummyPerson.setBirthdateEstimated(false);
		dummyPerson.setPersonCreator(baseOpenMRSMocker.getPersonCreator());
		dummyPerson.setPersonDateCreated(new Date());
		
		return dummyPerson;
	}

	
	

	public static void main(String[] args) {
		User u = new User();
		PersonCreator pc = new PersonCreator(u);
		Person dummyPerson = pc.getDummyPerson(true, true);
		
		for (int i = 0; i < 100; i++) {
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			System.out.println(RandomUtilities.getRandomDate());
		}
	}
}