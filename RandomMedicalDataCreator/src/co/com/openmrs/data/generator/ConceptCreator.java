package co.com.openmrs.data.generator;

import java.util.Date;

import org.openmrs.Concept;
import org.openmrs.ConceptClass;
import org.openmrs.ConceptDatatype;
import org.openmrs.User;

public class ConceptCreator {
	
	private User creator;
	
	public ConceptCreator(User creatorUser) {
		
	}
	
	public Concept getBooleanConcept(){
		Concept concept = new Concept();
		ConceptDatatype conceptDatatype = new ConceptDatatype();
		conceptDatatype.setUuid(ConceptDatatype.BOOLEAN_UUID);		
		concept.setDatatype(conceptDatatype);		
		ConceptClass conceptClass = new ConceptClass();
		conceptClass.setUuid(ConceptClass.QUESTION_UUID);
		concept.setConceptClass(conceptClass);		
		concept.setVersion("1.0");
		concept.setCreator(creator);
		concept.setDateCreated(new Date());
		return concept;		
	}
	
	public Concept getTextConcept(){
		Concept concept = new Concept();
		ConceptDatatype conceptDatatype = new ConceptDatatype();
		conceptDatatype.setUuid(ConceptDatatype.TEXT_UUID);		
		concept.setDatatype(conceptDatatype);		
		ConceptClass conceptClass = new ConceptClass();
		conceptClass.setUuid(ConceptClass.QUESTION_UUID);
		concept.setConceptClass(conceptClass);		
		concept.setVersion("1.0");
		concept.setCreator(creator);
		return concept;
	}
	
	public Concept getTextAreaConcept(){
		Concept concept = new Concept();
		ConceptDatatype conceptDatatype = new ConceptDatatype();
		conceptDatatype.setUuid(ConceptDatatype.DOCUMENT_UUID);		
		concept.setDatatype(conceptDatatype);		
		ConceptClass conceptClass = new ConceptClass();
		conceptClass.setUuid(ConceptClass.QUESTION_UUID);
		concept.setConceptClass(conceptClass);		
		concept.setVersion("1.0");
		concept.setCreator(creator);
		return concept;
	}
	
	private Concept getGenericFormFieldAssociatedConcept(String openMrsCoded){
		Concept genericConcept = new Concept();
		
		
		
		return genericConcept;
	}

}
