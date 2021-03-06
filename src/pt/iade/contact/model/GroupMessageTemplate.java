package pt.iade.contact.model;

import java.io.Serializable;
import java.util.Objects;

public class GroupMessageTemplate implements Serializable {

	private static final long serialVersionUID = 7914001267049242062L;
	private String title;
	private String body;
	private Group group;

	GroupMessageTemplate(String title, String body) {
		this.group = null;
		this.title = title;
		this.body = body;
	}

	GroupMessageTemplate(String title, String body, Group group) {
		this.title = title;
		this.body = body;
		this.group = group;
	}

	public String getTitle() {
		return title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	void setBody(String body) {
		this.body = body;
	}

	public Group getGroup() {
		return group;
	}

	void setGroup(Group group) {
		this.group = group;
	}
		
	@Override
	public boolean equals(Object template) {
		if (this != template) {
			if (template instanceof GroupMessageTemplate) { // saber se � uma instancai deste objeto
				GroupMessageTemplate t = (GroupMessageTemplate) template; // cast ap�s saber que � group
				return t.getBody().equals(this.body) && t.getGroup().equals(this.group)
						&& t.getTitle().equals(this.title);
			}
			return false;
		}
		return true;
	}
	
	@Override	
	public int hashCode() {
		return Objects.hash(title, body, group);
	}
	
	@Override
	public String toString() {
		return title;
	}
	
}