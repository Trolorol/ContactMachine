package pt.iade.contact.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GroupsManagementController {

	@FXML
	private Button addGroupBt;
	@FXML
	private Button editGroupBt;
	@FXML
	private Button deleteGroupBt;
	@FXML
	private Button saveBt;

	public void addGroup() {
		
		pt.iade.contact.Main.openAddGroupWindow();

	}

	public void editGroup() {
		pt.iade.contact.Main.openAddGroupWindow();
	}

	public void deleteGroup() {

	}

	public void saveBt() {
		pt.iade.contact.Main.openMainWindow();
	}
}
