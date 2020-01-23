package pt.iade.contact.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Group implements Serializable {

	private static final long serialVersionUID = -6584675298533575714L;
	private String name;
	private Set<Contact> contactList;
	private Set<GroupMessageTemplate> templateList;

	Group(String name) {
		this.contactList = new LinkedHashSet<Contact>();
		this.templateList = new LinkedHashSet<GroupMessageTemplate>();
		this.name = name;
	}

	Group(String name, Set<Contact> contactList, Set<GroupMessageTemplate> templateList) {
		this.name = name;
		this.contactList = contactList;
		this.templateList = templateList;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public Set<Contact> getContactList() {
		return contactList;
	}

	void setContactList(Set<Contact> contactList) {
		this.contactList = contactList;
	}

	public Set<GroupMessageTemplate> getTemplateList() {
		return templateList;
	}

	void setTemplateList(Set<GroupMessageTemplate> templateList) {
		this.templateList = templateList;
	}

	void addContact(Contact contact) {
		this.contactList.add(contact);
	}

	void removeContact(Contact contact) {
		this.contactList.remove(contact);
	}

	public boolean hasContact(Contact contact) {
		return this.contactList.contains(contact);
	}

	void addTemplate(GroupMessageTemplate template) {
		templateList.add(template);
	}

	void removeTemplate(GroupMessageTemplate template) {
		this.templateList.remove(template);
	}

	public boolean hasTemplate(GroupMessageTemplate template) {
		return this.templateList.contains(template);
	}

	public Set<Contact> listContacts() {
		return contactList;
	}

	public Set<GroupMessageTemplate> listTemplates() {
		return templateList;
	}

	@Override
	public boolean equals(Object group) {
		if (this != group) {// Fazer ao contrário
			if (group instanceof Group) { // saber se é uma instancai deste objeto
				Group g = (Group) group; // cast após saber que é group
				return g.getName().equals(this.name) && g.getContactList().equals(this.contactList)
						&& g.getTemplateList().equals(this.templateList);
			}
			return false;
		}
		return true;
	}
	
	@Override	
	public int hashCode() {
		return Objects.hash(name, contactList, templateList);
	}

	@Override
	public String toString() {
		return name;
	}
}