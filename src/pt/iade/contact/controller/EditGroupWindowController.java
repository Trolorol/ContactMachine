package pt.iade.contact.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.iade.contact.model.GroupMessageTemplate;

public class EditGroupWindowController {
	@FXML
	private Button btConfirm;

	@FXML
	private Button addTemplateBt;

	@FXML
	private TextField groupName;

	@FXML
	private ListView<GroupMessageTemplate> templateList;
}
