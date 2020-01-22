package pt.iade.contact.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class EntitiesFacade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -480708598466181488L;

	private Set<Contact> contactList = new LinkedHashSet<Contact>();
	private Set<Group> groupList = new LinkedHashSet<Group>();
	private Set<GroupMessageTemplate> templateList = new LinkedHashSet<GroupMessageTemplate>();

	/************************* Contacts management *************************/

	public synchronized void addContact(String name, String number) {
		Contact contact = new Contact(name, number);
		contactList.add(contact);
	}

	public void editContact(String contactNumber, String newNumber, String newName) {
		Contact c = findContact(contactNumber);
		contactList.remove(c);
		addContact(newNumber, newName);

		for (Group element : groupList) {
			element.removeContact(c);
			element.addContact(findContact(newNumber));
		}

	}

	public void removeContact(String number) {

		Contact c = findContact(number);

		contactList.remove(c);

		for (Group element : groupList) {
			element.removeContact(c);
		}

	}

	public Contact findContact(String number) {
		for (Contact element : contactList) {
			if (element.getNumber().equals(number)) {

				return element;
			}
		}

		return null;
	}

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

	public Collection<Contact> showAllContacts() {
		return contactList;
	}

	/************************* Groups management *************************/

	public void addGroup(String name) {
		Group group = new Group(name);
		groupList.add(group);
	}

	public void removeGroup(String name) {

		Group g = findGroup(name);

		groupList.remove(g);

		for (Contact element : contactList) {
			element.removeFromGroup(g);
		}
	}

	public Group findGroup(String name) {

		for (Group element : groupList) {
			if (element.getName().equals(name)) {
				return element;
			}
		}
		return null;
	}

	public Collection<Group> showAllGroups() {
		return groupList;
	}

	public void editGroup(String oldName, String newName) {

		Group g = findGroup(oldName);
		g.setName(newName);
	}

	/************************* Templates management *************************/

	/**
	 * 
	 * @param title
	 * @param body
	 * 
	 *              addTemplate method without insertion of group. group variable
	 *              initialized with null value, see line 13 at
	 *              pt.iade.contact.model.GroupMessageTemplate
	 */
	public void addTemplate(String title, String body) {
		GroupMessageTemplate template = new GroupMessageTemplate(title, body);
		templateList.add(template);

	}
	
	public void editTemplate(String oldName, String newTitle, String newBody) {
		GroupMessageTemplate mt = findTemplate(oldName);
		
		mt.setBody(newBody);
		mt.setTitle(newTitle);
		

		
	}

	public void groupAddTemplate(String title, String body, Group group) {

		GroupMessageTemplate template = new GroupMessageTemplate(title, body, group);
		templateList.add(template);

	}

	public void removeTemplate(String title) {

		for (GroupMessageTemplate element : templateList) {
			if (element.getTitle().equals(title)) {
				templateList.remove(element);
			}

		}

	}

	public GroupMessageTemplate findTemplate(String title) {

		for (GroupMessageTemplate element : templateList) {
			if (element.getTitle().equals(title)) {
				return element;
			}
		}
		return null;
	}

	public Collection<GroupMessageTemplate> showAllTemplates() {
		return templateList;

	}

	public void addTemplateToGroup(String title, String groupName) {

		GroupMessageTemplate gTemplate = findTemplate(title);
		Group g = findGroup(groupName);

		g.addTemplate(gTemplate);
	}
}
