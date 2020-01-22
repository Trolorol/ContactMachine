package pt.iade.contact.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pt.iade.contact.Main;

public class AddTemplateWindowController {

	@FXML
	private Button btConfirm;
	@FXML
	private TextField titleField;
	@FXML
	private TextField bodyField;

	
	/*
	 * confirmBt method will store the newly created template in Main.facade GroupMessageTemplate Set
	 * this method will not call for a Serializable event.
	 */
	public void confirmBt() {
		String title = this.titleField.getText();
		String body = this.bodyField.getText();
		Main.facade.addTemplate(title, body);
		System.out.println("Template " + title + " ready to be saved.");
		pt.iade.contact.Main.openAddGroupWindow();
	}

	@FXML
	public void titleInput() {

	}

	@FXML
	public void bodyInput() {

	}
}
