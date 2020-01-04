package entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class Group {

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

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

}
