package guiController;

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
		application.Main.openGroupManagementWindow();
	}
	
	
	public void nameInput() {
		
	}

	public void templateInput() {
		
	}
}
