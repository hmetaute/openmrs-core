package co.com.openmrs.data.mock;

import java.util.Date;


import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.User;


/**
 * Clase completamente inutil que hace exactamente lo mismo que el baseopenmrsmocker
 * @author hernan.metaute
 *
 */
public class BaseOpenMRSMetadataMocker {
	
	public User personCreator;

	public User getPersonCreator() {
		return personCreator;
	}

	public void setPersonCreator(User personCreator) {
		this.personCreator = personCreator;
	}

	public BaseOpenMRSMetadataMocker(User creator) {
		personCreator = creator;
	}
	
	public BaseOpenmrsMetadata setBaseOpenmrsMetadata(BaseOpenmrsMetadata object) {
		object.setCreator(personCreator);
		object.setDateCreated(new Date());
		object.setChangedBy(personCreator);
		return object;
	}

}
