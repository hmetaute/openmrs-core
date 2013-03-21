package co.com.openmrs.data.generator;

import org.openmrs.Field;
import org.openmrs.FieldType;
import org.openmrs.User;

import co.com.openmrs.data.mock.BaseOpenMRSMetadataMocker;

public class FieldCreator {
	
	BaseOpenMRSMetadataMocker baseOpenmrsMetadata;
	
	public FieldCreator(User creator) {
		baseOpenmrsMetadata = new BaseOpenMRSMetadataMocker(creator);
	}
	
	public Field getWeightFieldDummy(){
		Field field = createField("tableName", "Peso", "0", "El peso de un paciente", false);		
		return field;	
	}
	
	public Field getTemperatureFieldDummy(){
		Field field = createField("tableName1", "Temperatura", "0", "La temperatura de un paciente", false); 
		return field;		
	}
		
	public Field getBloodPressureFieldDummy(){
		Field field = createField("tableName2", "Presion Sanguinea", "0", "Presión sanguínea de un paciente", false); 
		return field;
	}
	
	public Field getCancerHistoryFieldDummy(){
		Field field = createField("tableName3", "Antecedentes Cancer", "No", "Factores de riesgo cancer", false);		
		return field;
	}
						
	
	private Field createField(String tableName, String attributeName, String defaultValue, String fieldDescription, boolean selectMultiple){
		Field field = new Field();		
		field = (Field) baseOpenmrsMetadata.setBaseOpenmrsMetadata(field);
		FieldType fieldType = new FieldType();
		fieldType = (FieldType) baseOpenmrsMetadata.setBaseOpenmrsMetadata(fieldType);
		fieldType.setIsSet(true);
		field.setFieldType(fieldType);
		//TODO: set the concept
		field.setTableName(tableName);
		field.setAttributeName(attributeName);
		field.setDefaultValue(defaultValue);
		field.setDescription(fieldDescription);
		field.setSelectMultiple(selectMultiple);
		
		return field;
	}
	

}
