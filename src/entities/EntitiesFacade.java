package entities;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class EntitiesFacade {

	private static Set<Contact> contactList = new LinkedHashSet<Contact>();
	private static Set<Group> groupList = new LinkedHashSet<Group>();

	/************************* Contacts management *************************/

	public static void addContact(String name, String number) {
		Contact contact = new Contact(name, number);
		contactList.add(contact);
	}

	public static void removeContact(String number) {

		Iterator<Contact> itrContact = contactList.iterator();

		while (itrContact.hasNext()) {
			Contact element = itrContact.next();

			if (element.getNumber().equals(number)) {
				contactList.remove(element);
			}
		}

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

	/*
	 * public static void showAllContacts() { Iterator<Contact> itrContact =
	 * contactList.iterator();
	 * 
	 * while (itrContact.hasNext()) { Contact element = itrContact.next();
	 * System.out.println("Nome: " + element.getName() + " | Numero: " +
	 * element.getNumber()); } }
	 */

	public static Collection<Contact> showAllContacts() {
		return contactList;
	}

	/************************* Groups management *************************/

	public static void addGroup(String name) {
		Group group = new Group(name);
		groupList.add(group);
	}

	public static void removeGroup(String name) {
		Iterator<Group> itrGroup = groupList.iterator();

		while (itrGroup.hasNext()) {
			Group element = itrGroup.next();

			if (element.getName().equals(name)) {
				contactList.remove(element);
			}
		}

	}

	public static Group findGroup(String name) {
		Iterator<Group> itrGroup = groupList.iterator();

		while (itrGroup.hasNext()) {
			Group element = itrGroup.next();

			if (element.getName().equals(name)) {
				return element;
			}
		}
		return null;
	}

	public static Collection<Group> showAllGroups() {
		return groupList;
	}

	/************************* Templates management *************************/


}

	