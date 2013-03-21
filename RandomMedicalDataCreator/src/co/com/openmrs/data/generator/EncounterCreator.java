package co.com.openmrs.data.generator;

import org.openmrs.Encounter;
import org.openmrs.Patient;
import org.openmrs.User;

import co.com.openmrs.data.random.RandomUtilities;

public class EncounterCreator {
	
	public EncounterCreator() {	
	}
	
	public Encounter getDummyEncounter(Patient patient, User creator){
		Encounter encounter = new Encounter();
		LocationCreator locationCreator = new LocationCreator();
		FormCreator formCreator = new FormCreator();
		EncounterTypeCreator encounterTypeCreator = new EncounterTypeCreator(creator);
		
		encounter.setEncounterDatetime(RandomUtilities.getRandomDate());
		encounter.setPatient(patient);
		encounter.setLocation(locationCreator.getLocationDummy());
		encounter.setForm(formCreator.getDummyForm());
		encounter.setEncounterType(encounterTypeCreator.getDefaultDummyEncounterType());
		
		return encounter;
	}

}
