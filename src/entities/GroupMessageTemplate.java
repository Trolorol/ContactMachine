package entities;

public class GroupMessageTemplate {

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

	String getTitle() {
		return title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	String getBody() {
		return body;
	}

	void setBody(String body) {
		this.body = body;
	}

}
