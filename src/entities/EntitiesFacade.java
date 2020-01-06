package entities;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class EntitiesFacade {

	private static Set <Contact> contactList = new LinkedHashSet<Contact>(); 

	public static void addContact(String name, String number) {
		Contact contact = new Contact(name, number);
		contactList.add(contact);
	}

	public static Contact findContact(String number) {

		Iterator<Contact> itrContact = contactList.iterator();

		while (itrContact.hasNext()) {
			Contact element = itrContact.next();

			if (element.getNumber().equals(number)) {
				return element;
			}

		}
		return null;
	}
	
	public static void showAllContacts() {
		Iterator<Contact> itrContact = contactList.iterator();

		while (itrContact.hasNext()) {
			Contact element = itrContact.next();
			
			return ;
			
		}
	}
}
