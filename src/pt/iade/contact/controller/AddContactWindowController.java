package pt.iade.contact.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.iade.contact.Main;
import pt.iade.contact.model.Group;

public class AddContactWindowController {

	@FXML
	private Button confirm;
	@FXML
	private ListView<Group> groupsList;
	@FXML
	private TextField name;
	@FXML
	private TextField number;
	

	@FXML
	public void btConfirm(ActionEvent event) {
		Main.openContactManagementWindow();
		}

	@FXML
	public void groupTable() {
		
	}
	@FXML
	public void nameInput() {
		
	}
	@FXML
	public void numberInput() {
		
	}
}
