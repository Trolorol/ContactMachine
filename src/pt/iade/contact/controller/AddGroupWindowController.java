package pt.iade.contact.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddGroupWindowController {
	
	
	@FXML
	private Button confirm;
	
	
	@FXML
	private TextField groupName;
	
	@FXML 
	private TextField templates;
	
	
	public void confirmBt() {
		pt.iade.contact.Main.openGroupManagementWindow();
	}
	
	
	public void nameInput() {
		
	}

	public void templateInput() {
		
	}
}
