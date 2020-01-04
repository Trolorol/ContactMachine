package entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class Contact {

	private String name;
	private Integer number;

	private Set<Group> groupsList;

	Contact(String name, Integer number) {

		this.groupsList = new LinkedHashSet<Group>(); // Garantia que não há duplicação de grupos, Class abstract "Set",
														// LinkedHashSet
		this.name = name;
		this.number = number;
	}

	Contact(String name, Integer number, Set<Group> groupsList) {
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

	public Integer getNumber() {
		return number;
	}

	void setNumber(Integer number) {
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

}
