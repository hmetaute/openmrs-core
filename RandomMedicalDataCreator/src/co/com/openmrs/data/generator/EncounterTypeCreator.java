package co.com.openmrs.data.generator;

import java.util.ArrayList;
import java.util.Random;

import org.openmrs.EncounterType;
import org.openmrs.User;

import co.com.openmrs.data.mock.BaseOpenMRSMetadataMocker;

public class EncounterTypeCreator {

	
	//encounterTypeNames.length should == encounterTypeDescriptions.length  
	private String encounterTypeNames[] = { "Consulta médica general",
			"Consulta oftalmologo", "Examen ocular", "Examen cardiaco",
	"Resonancia" };
	
	private String encounterTypeDescriptions[] = {
			"Consulta con un médico general",
			"Consulta con un especialista ocular",
			"Examen de bastones en el ojo", "Resonancia magnética al corazón" };
	
	private BaseOpenMRSMetadataMocker baseOpenmrsMetadataMocker;
	
	
	public EncounterTypeCreator(User creator) {
		baseOpenmrsMetadataMocker = new BaseOpenMRSMetadataMocker(creator);
	}

	/**
	 * Creates a list of encounterTypes with the default values on top of the page
	 * 
	 * @return
	 */
	public ArrayList<EncounterType> getDefaultDummyEncounterTypes() {				
		return getEncounterTypes(this.encounterTypeNames, this.encounterTypeDescriptions);
	}
	
	public ArrayList<EncounterType> getEncounterTypes(String[] lencounterTypeNames, String[] lencounterTypeDescriptions) throws IllegalArgumentException{
		if(lencounterTypeNames != lencounterTypeDescriptions){
			throw new IllegalArgumentException("The array of descriptions should have the same number of elements the names array has"); 
		}
		
		ArrayList<EncounterType> dummyEncounterTypes = new ArrayList<EncounterType>();
		for(int i = 0; i < lencounterTypeNames.length; i++){
			String encounterTypeName = lencounterTypeNames[i];
			String encounterTypeDescription = lencounterTypeDescriptions[i];
			EncounterType encounterType = createEncounterType(encounterTypeName, encounterTypeDescription);			
			dummyEncounterTypes.add(encounterType);
		}
		
		return dummyEncounterTypes;
	}
	
	public EncounterType getDefaultDummyEncounterType(){
		Random random = new Random();
		int randomEncounterTypeIndex = random.nextInt(encounterTypeNames.length); 
		String randomEncounterTypeName = encounterTypeNames[randomEncounterTypeIndex];
		String randomEncounterTypeDescription = encounterTypeDescriptions[randomEncounterTypeIndex];
		EncounterType encounterType = createEncounterType(randomEncounterTypeName, randomEncounterTypeDescription);		
		return encounterType;
	}
	
	private EncounterType createEncounterType(String name, String description){
		EncounterType encounterType = new EncounterType();
		encounterType.setName(name);
		encounterType.setDescription(description);
		encounterType = (EncounterType) baseOpenmrsMetadataMocker.setBaseOpenmrsMetadata(encounterType);
		return encounterType;
	}

}
