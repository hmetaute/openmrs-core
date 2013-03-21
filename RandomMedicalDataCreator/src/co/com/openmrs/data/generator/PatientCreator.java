package co.com.openmrs.data.generator;

import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.User;

public class PatientCreator {
	
	private PersonCreator personCreator;
	
	public PatientCreator(User creator) {
		personCreator = new PersonCreator(creator);
	}
	
	public Patient getDummyPatient(boolean isMale){
		Person person = personCreator.getDummyPerson(isMale, true);
		Patient patient = new Patient(person);		
		return patient;
	}

}
