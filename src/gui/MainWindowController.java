package gui;

import java.util.Collection;
import java.util.LinkedHashSet;

import entities.Group;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MainWindowController {
	
	
	@FXML private Button management;
	@FXML private Button send;
	@FXML private ListView<String> contactList;
	@FXML private ListView<String> groupList;
	@FXML private ListView<String> templateList;
	@FXML private TextField message;
	
	
	
	
	@FXML
	public void btManagementAction() {
		System.out.println("Click");
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
