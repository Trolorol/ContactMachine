package pt.iade.contact.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
/*
 * EntitiesFacade Class is responsible for the encapsulation of the business model side of the program.
 * In this class are written all the control methods for Contacts, Groups and Templates, for Adding, Deleting, Editing, Finding and show.
 * This class is located in the same package as the Contact, Group and GroupMessageTemplate Classes, those same classes are in package protected mode
 * this ways it assures that this Class, EntitiesFacade can communicate with them and it's public methods can communicate with the outside world.
 * 
 * This Class implements Serializable in order to use Serializable action to store object state in /data/state.file
 */
public class EntitiesFacade implements Serializable {

	private static final long serialVersionUID = -480708598466181488L;
	private Set<Contact> contactList = new LinkedHashSet<Contact>();
	private Set<Group> groupList = new LinkedHashSet<Group>();
	private Set<GroupMessageTemplate> templateList = new LinkedHashSet<GroupMessageTemplate>();

	/**
	 * Add Contact Method
	 * @param name
	 * @param number
	 * 
	 * Creates a new variable form Contact type, and adds it to contactList Set.

	 */
	public synchronized void addContact(String name, String number) {
		Contact contact = new Contact(name, number);
		contactList.add(contact);
	}

	/**
	 * Edit Contact Method
	 * @param contactNumber
	 * @param newNumber
	 * @param newName
	 * 
	 * This method will edit an object from the type Contact.
	 * With ne contactNumber it will find its instance and delete it from
	 * the Contact Set in Facade, then it will create a new contact and add it to the Contact Set in Facade.
	 * Lastly will iterate over all groups to find instances of the old contact and replace them with the new contact.
	 */
	public void editContact(String contactNumber, String newNumber, String newName) {
		Contact c = findContact(contactNumber);
		contactList.remove(c);
		addContact(newNumber, newName);
		for (Group element : groupList) {
			element.removeContact(c);
			element.addContact(findContact(newNumber));
		}
	}

	/**Remove Contact Method
	 * @param number
	 * 
	 * This method will find the instance of the inputed number and delete it from contactList Set.
	 * Then it will iterate over all groups to find instances containing the number and delete it.
	 */
	public void removeContact(String number) {
		Contact c = findContact(number);
		contactList.remove(c);
		for (Group element : groupList) {
			element.removeContact(c);
		}
	}

	/**
	 * @param number
	 * @return
	 */
	public Contact findContact(String number) {
		for (Contact element : contactList) {
			if (element.getNumber().equals(number)) {
				return element;
			}
		}

		return null;
	}

	/**
	 * @param number
	 * @param groupName
	 */
	public void addContactToGroup(String number, String groupName) {
		Contact c = findContact(number);
		Group g = findGroup(groupName);
		Contact c2 = new Contact(c.getName(), c.getNumber(), c.listGroups());
		c2.addToGroup(g);
		g.removeContact(c);
		g.addContact(c2);
		for (Group element : c.listGroups()) {
			element.removeContact(c);
			element.addContact(c2);
		}
		contactList.remove(c);
		contactList.add(c2);
	}

	/**
	 * @return
	 */
	public Collection<Contact> showAllContacts() {
		return contactList;
	}

	/**
	 * @param name
	 */
	public void addGroup(String name) {
		Group group = new Group(name);
		groupList.add(group);
	}

	/**
	 * @param name
	 */
	public void removeGroup(String name) {
		Group g = findGroup(name);
		groupList.remove(g);
		for (Contact element : contactList) {
			element.removeFromGroup(g);
		}
	}

	/**
	 * @param name
	 * @return
	 */
	public Group findGroup(String name) {
		for (Group element : groupList) {
			if (element.getName().equals(name)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public Collection<Group> showAllGroups() {
		return groupList;
	}

	/**
	 * @param oldName
	 * @param newName
	 */
	public void editGroup(String oldName, String newName) {
		Group g = findGroup(oldName);
		g.setName(newName);
	}

	/**
	 * Add Template Method
	 * @param title
	 * @param body
	 */
	public void addTemplate(String title, String body) {
		GroupMessageTemplate template = new GroupMessageTemplate(title, body);
		templateList.add(template);
	}

	/**
	 * @param oldName
	 * @param newTitle
	 * @param newBody
	 */
	public void editTemplate(String oldName, String newTitle, String newBody) {
		GroupMessageTemplate mt = findTemplate(oldName);
		mt.setBody(newBody);
		mt.setTitle(newTitle);
	}

	/**
	 * @param title
	 * @param body
	 * @param group
	 */
	public void groupAddTemplate(String title, String body, Group group) {
		GroupMessageTemplate template = new GroupMessageTemplate(title, body, group);
		templateList.add(template);
	}

	/**
	 * @param title
	 */
	public void removeTemplate(String title) {
		for (GroupMessageTemplate element : templateList) {
			if (element.getTitle().equals(title)) {
				templateList.remove(element);
			}
		}
	}

	/**
	 * @param title
	 * @return
	 */
	public GroupMessageTemplate findTemplate(String title) {
		for (GroupMessageTemplate element : templateList) {
			if (element.getTitle().equals(title)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public Collection<GroupMessageTemplate> showAllTemplates() {
		return templateList;
	}

	/**
	 * @param title
	 * @param groupName
	 */
	public void addTemplateToGroup(String title, String groupName) {
		GroupMessageTemplate gTemplate = findTemplate(title);
		Group g = findGroup(groupName);
		g.addTemplate(gTemplate);
	}
}
