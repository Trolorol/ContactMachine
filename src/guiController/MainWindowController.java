package guiController;

import java.util.Collection;

import entities.Contact;
import entities.Group;
import entities.GroupMessageTemplate;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindowController {
	
	
	@FXML
	private Button management;
	
	@FXML
	private Button send;
	
	@FXML
	private ListView<Group> contactList;
	
	@FXML
	private ListView<Contact> groupList;
	
	@FXML
	private ListView<GroupMessageTemplate> templateList;
	
	@FXML
	private TextField message;
	
	
	
	
	@FXML
	public void btManagementAction() {
		application.Main.openforkWindow();
	}
	
	@FXML
	public void btSendAction() {
		
	}
	
	
	@FXML
	public void showContactList() {
		
	}
	
	@FXML
	public Collection<Group> showGroupList() {
		return entities.EntitiesFacade.showAllGroups();
		
	}
	
	@FXML
	public void showTemplateList() {
		
	}
	
	
	
}
