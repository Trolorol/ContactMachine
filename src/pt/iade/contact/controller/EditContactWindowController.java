package pt.iade.contact.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.iade.contact.model.Group;

public class EditContactWindowController {
	
	@FXML
	private Button confirm;
	@FXML
	private ListView<Group> groupList;

	@FXML
	private TextField name = new TextField();
	@FXML
	private TextField number = new TextField();

}
