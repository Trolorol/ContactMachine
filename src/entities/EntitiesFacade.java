package entities;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.GroupLayout;

public class EntitiesFacade {

	private static Set<Contact> contactList = new LinkedHashSet<Contact>();
	private static Set<Group> groupList = new LinkedHashSet<Group>();
	private static Set<GroupMessageTemplate> templateList = new LinkedHashSet<GroupMessageTemplate>();

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

	public static void addContactToGroup(String number, String groupName) { // Adicionar contacto existente a grupo

		Contact c = findContact(number);
		Group g = findGroup(groupName);

		Iterator<Group> itrGroup = c.listGroups().iterator();

		Contact c2 = new Contact(c.getName(), c.getNumber(), c.listGroups());
		c2.addToGroup(g);

		while (itrGroup.hasNext()) {
			Group element = itrGroup.next();
				element.removeContact(c);
				element.addContact(c2);
		}
		
		contactList.remove(c);
		contactList.add(c2); 

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

	public static void groupAddTemplate(String title, String body, Group group) {
		GroupMessageTemplate template = new GroupMessageTemplate(title, body, group);
		templateList.add(template);

	}

	public static void addTemplate(String title, String body) { // inicializa ponteiro de grupo a null
		GroupMessageTemplate template = new GroupMessageTemplate(title, body);
		templateList.add(template);

	}

	public static void removeTemplate(String title) {
		Iterator<GroupMessageTemplate> itrTemplate = templateList.iterator();

		while (itrTemplate.hasNext()) {
			GroupMessageTemplate element = itrTemplate.next();

			if (element.getTitle().equals(title)) {
				templateList.remove(element);
			}
		}

	}

	public static GroupMessageTemplate findTemplate(String title) {
		Iterator<GroupMessageTemplate> itrTemplate = templateList.iterator();

		while (itrTemplate.hasNext()) {
			GroupMessageTemplate element = itrTemplate.next();

			if (element.getTitle().equals(title)) {
				return element;
			}
		}
		return null;
	}

	public static Collection<GroupMessageTemplate> showAllTemplates() {
		return templateList;

	}
}
