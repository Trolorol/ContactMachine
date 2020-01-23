package pt.iade.contact.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Contact implements Serializable {

	private static final long serialVersionUID = -1275999734839815529L;
	private String name;
	private String number;
	private Set<Group> groupsList;

	/**
	 * 
	 * @param name
	 * @param number
	 * 
	 *               Method uses LinkedHashSet, abstract Class of Set, this insures
	 *               that are no duplicate objects in the Set.
	 */
	Contact(String name, String number) {
		this.groupsList = new LinkedHashSet<Group>();
		this.name = name;
		this.number = number;
	}

	Contact(String name, String number, Set<Group> groupsList) {
		this.name = name;
		this.number = number;
		this.groupsList = groupsList;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	void setNumber(String number) {
		this.number = number;
	}

	void addToGroup(Group group) {
		this.groupsList.add(group);
	}

	void removeFromGroup(Group group) {
		this.groupsList.remove(group);
	}

	public boolean isInGroup(Group group) {
		return this.groupsList.contains(group);
	}

	public Set<Group> listGroups() {
		return groupsList;
	}

	@Override
	public boolean equals(Object contact) {
		if (this != contact) {
			if (contact instanceof Contact) {
				Contact c = (Contact) contact;
				return c.getName().equals(this.name) && c.getNumber().equals(this.number);
			}
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, number);
	}

	@Override
	public String toString() {
		return name + "\n" + number;
	}
}
