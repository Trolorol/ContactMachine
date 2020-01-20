package pt.iade.contact.model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Contact {

	private String name;
	private String number;

	private Set<Group> groupsList;

	Contact(String name, String number) {

		this.groupsList = new LinkedHashSet<Group>(); // Garantia que não há duplicação de grupos, Class abstract "Set",
														// LinkedHashSet
		this.name = name;
		this.number = number;
	}

	Contact(String name, String number, Set <Group> groupsList) {
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
	/*public boolean equals(Object group) {
		if( this == group){
			return true;
		}else {
			if (this.getNumber().equals(group.get))
		}
	
	}*/
	public boolean equals (Object contact) {
		if (this != contact) {//Fazer ao contrário 
			if (contact instanceof Contact) { //saber se é uma instancai deste objeto
				Contact c = (Contact) contact; //cast após saber que é contact 
				return c.getName().equals(this.name) && c.getNumber().equals(this.number);
			}
			return false;
		}
		return true; 
	}

	@Override
	public String toString() {

		
		return name + "\n" + number;
	}
	
	
	/*
	@Override
	public String toString() {
		//String returnString = "Contact name : " + name + "\nNumber : " + number + "\nGroupsList : ";
		String returnString =  name + "\n" + number;
		Iterator <Group> itr = groupsList.iterator();
		while(itr.hasNext()) {
	           Group element = itr.next();
	           returnString += element.getName() + (itr.hasNext() ? " | " : "");
	       }
		
		return returnString;
	}
	*/
	
}
