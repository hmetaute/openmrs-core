package co.com.openmrs.data.generator;

import org.openmrs.Field;
import org.openmrs.Form;
import org.openmrs.FormField;
import org.openmrs.User;

public class FormFieldCreator {
	private final Integer WEIGHT_FORM_FIELD_NUMBER = new Integer(1);
	private final Integer TEMPERATURE_FORM_FIELD_NUMBER = new Integer(2);
	private final Integer BLOOD_PRESSURE_FORM_FIELD_NUMBER = new Integer(3);
	private final Integer CANCER_HISTORY_FORM_FIELD_NUMBER = new Integer(4);
	private final String FIELDPART = "fieldPart";

	private FieldCreator fieldCreator;
	private ConceptCreator conceptCreator;
	
	
	public FormFieldCreator(User creator) {
		fieldCreator = new FieldCreator(creator);
		conceptCreator = new ConceptCreator(creator);
	}
	
	
	public FormField getDummyWeightFormField(Form parentForm){		
		FormField formField = new FormField();
		formField.setForm(parentForm);
		Field weightField = fieldCreator.getWeightFieldDummy();
		weightField.setConcept(conceptCreator.getTextConcept());				
		formField.setField(weightField);
		formField.setFieldNumber(WEIGHT_FORM_FIELD_NUMBER);
		formField.setFieldPart(FIELDPART);
		formField.setPageNumber(new Integer(1));
		formField.setMinOccurs(new Integer(1));
		formField.setMaxOccurs(new Integer(2));
		formField.setRequired(Boolean.TRUE);		
		return formField;
	}
	
	public FormField getDummyTemperatureFormField(Form parentForm){		
		FormField formField = new FormField();
		formField.setForm(parentForm);
		Field temperatureField = fieldCreator.getTemperatureFieldDummy();
		temperatureField.setConcept(conceptCreator.getTextConcept());
		formField.setField(temperatureField);
		formField.setFieldNumber(TEMPERATURE_FORM_FIELD_NUMBER);
		formField.setFieldPart(FIELDPART);
		formField.setPageNumber(new Integer(1));
		formField.setMinOccurs(new Integer(1));
		formField.setMaxOccurs(new Integer(2));
		formField.setRequired(Boolean.TRUE);				
		return formField;
	}
	
	public FormField getDummyBloodPressyreFormField(Form parentForm){
		FormField formField = new FormField();
		formField.setForm(parentForm);
		Field bloodPressureField = fieldCreator.getBloodPressureFieldDummy();
		bloodPressureField.setConcept(conceptCreator.getTextConcept());
		formField.setField(bloodPressureField);
		formField.setFieldNumber(BLOOD_PRESSURE_FORM_FIELD_NUMBER);
		formField.setFieldPart(FIELDPART);
		formField.setPageNumber(new Integer(1));
		formField.setMinOccurs(new Integer(1));
		formField.setMaxOccurs(new Integer(2));
		formField.setRequired(Boolean.TRUE);				
		return formField;
	}
	
	public FormField getDummyCancerHistorFormField(Form parentForm){		
		FormField formField = new FormField();
		formField.setForm(parentForm);
		Field cancerHistoryField = fieldCreator.getBloodPressureFieldDummy();
		cancerHistoryField.setConcept(conceptCreator.getBooleanConcept());
		formField.setField(cancerHistoryField);
		formField.setFieldNumber(CANCER_HISTORY_FORM_FIELD_NUMBER);
		formField.setFieldPart(FIELDPART);
		formField.setPageNumber(new Integer(1));
		formField.setMinOccurs(new Integer(1));
		formField.setMaxOccurs(new Integer(2));
		formField.setRequired(Boolean.TRUE);				
		return formField;
	}
		

}
