package guiController;

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
		
		application.Main.openAddGroupWindow();

	}

	public void editGroup() {
		application.Main.openAddGroupWindow();
	}

	public void deleteGroup() {

	}

	public void saveBt() {
		application.Main.openMainWindow();
	}
}
