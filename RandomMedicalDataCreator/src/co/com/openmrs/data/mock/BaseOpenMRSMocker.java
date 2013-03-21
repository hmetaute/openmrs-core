package co.com.openmrs.data.mock;

import java.util.Date;

import org.openmrs.BaseOpenmrsData;
import org.openmrs.User;

public class BaseOpenMRSMocker {
	public User personCreator;

	public User getPersonCreator() {
		return personCreator;
	}

	public void setPersonCreator(User personCreator) {
		this.personCreator = personCreator;
	}

	public BaseOpenMRSMocker(User creator) {
		personCreator = creator;
	}
	
	public BaseOpenmrsData setBaseOpenmrsData(BaseOpenmrsData object) {
		object.setCreator(personCreator);
		object.setDateCreated(new Date());
		object.setChangedBy(personCreator);
		return object;
	}
}