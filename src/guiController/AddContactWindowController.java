package guiController;

import entities.Group;
import entities.GroupMessageTemplate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddContactWindowController {

	@FXML
	private Button confirm;
	@FXML
	private ListView<Group> groupsList;
	@FXML
	private TextField name;
	@FXML
	private TextField number;

	public void btConfirm() {
		application.Main.openContactManagementWindow();
		
	}
	
	public void groupTable() {
		
	}
	
	public void nameInput() {
		
	}
	
	public void numberInput() {
		
	}
}
