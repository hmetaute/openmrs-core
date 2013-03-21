package co.com.openmrs.data.persistence;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.User;
import org.openmrs.api.PersonService;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.PersonServiceImpl;
import org.openmrs.api.impl.UserServiceImpl;
import org.openmrs.util.OpenmrsUtil;

import co.com.openmrs.data.generator.PersonCreator;

public class PersonPersistence {

	private PersonCreator personCreator;
	private User admin;

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public PersonPersistence() {
		// PersonService personService = Context.getPersonService();
		UserService userService = Context.getUserService();
		admin = userService.getUser(new Integer(1));
		personCreator = new PersonCreator(admin);
	}

	public void savePersonPostgres() {
		Person dummyPerson = personCreator.getDummyPerson(true, true);
		System.out.println("Voy a guardar la persona: " + dummyPerson.getPersonName().getFullName());
		PersonService personService = new PersonServiceImpl();
		personService.savePerson(dummyPerson);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File propsFile = new File(OpenmrsUtil.getApplicationDataDirectory(),
				"openmrs-runtime.properties");
		Properties props = new Properties();
		OpenmrsUtil.loadProperties(props, propsFile);
		try {
			Context.startup("jdbc:postgresql://localhost:5432/openmrs", "postgres", "admin", props);
 			Context.openSession();
			Context.authenticate("admin", "Openmrs*123");
			PersonPersistence personPersistence = new PersonPersistence();
			personPersistence.savePersonPostgres();

		}catch (Exception e){
			e.printStackTrace();
		} finally {
			Context.closeSession();
		}
	}
}
